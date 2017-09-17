package kyoto.freeprojects.oldbigbuddha;

import kyoto.freeprojects.oldbigbuddha.Card.*;
import kyoto.freeprojects.oldbigbuddha.Player.HumanPlayer;
import kyoto.freeprojects.oldbigbuddha.Player.Player;

import java.io.IOException;
import java.util.*;

public class Game {

    public static int count = 0;

//    private List<Card>    mCards    = new ArrayList<>();
    private List<Player>  mPlayers = new ArrayList<>();
    private Map<String, Integer> mCardNumbers = new HashMap<>();

    private Deck          mDeck;

    private ShuffleRandom random;
    private int[]         mNumber;

    public Game() {
        while (true) {
            if (initGame()) break;
            else clear();
        }
        random  = new ShuffleRandom(0, mPlayers.size());
        mNumber = new int[mPlayers.size()];
    }

    public void start() {
        for (Player player: mPlayers) {
            player.draw(mDeck);
        }

    }

    private boolean initGame() {
        println("Setting Time");
        generatePlayers();
        mDeck = new Deck();
        mDeck.make();
        print("Please input(y/n):");
        if (getKey().equals("n")) return false;
        return true;
    }

    private void generatePlayers() {
        int playersNumber;
        while (true) {
            playersNumber = howManyPlayers();
            for (int i = 0; i < playersNumber; i++) {
                mPlayers.add(generatePlayer());
            }

            println("Is this OK?");
            println("Players");
            for (Player player : mPlayers) {
                println(player.getName());
            }
            println();

            print("Please tell me(y/n):");
            if (getKey().equals("n")) continue;
            break;
        }
    }

    private int howManyPlayers() {
        int number;
        while (true) {
            try {
                println("Please tell me how many players?(lowest:2)");
                print("Players:");
                number = Integer.parseInt(getKey());
                if (number <= 1) {
                    println("Please input number more than 2");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                println("Please input integer");
                continue;
            }
        }
        return number;
    }

    private HumanPlayer generatePlayer() {
        println("What's your name?");
        print("Your Name:");
        String name = getKey();
        count++;
        return new HumanPlayer( name, count );
    }

    private int questionHowManyCards(CardName name) {
            println("How many " + name.toString() + " cards do you want to use?");
            print("Number of " + name.toString() + "cards(Max 4):");
            return getInteger();
    }

//    private void makeDeck() {
//        for (CardName name: CardName.values()) {
//        }
//    }
//
//    private void makeDeck_test() {
//        for (int i = 0; i < 4; i++) {
//            mCards.add(new One());
//            mCards.add(new Two());
//            mCards.add(new Three());
//        }
//        mCardNumbers.put("One", 4);
//        mCardNumbers.put("Two", 4);
//        mCardNumbers.put("Three", 4);
//    }
//
//    private void dealCard() {
//        for (int i = 0; i < mNumber.length; i++) {
//            mNumber[i] = random.getRandomInt();
//        }
//    }

    /**
     * Clear Console
     * */
    public static void clear() {
        try {
            new ProcessBuilder( "clear").inheritIO().start().waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void println(String ...arg) {
        if (arg == null) {
            System.out.println();
        }
        System.out.println(arg[0]);
    }

    public static void print(String arg) {
        System.out.print(arg);
    }


    public static int getInteger() {
        int number;
        while (true) {
            try {
                number = Integer.parseInt(getKey());
                break;
            } catch (NumberFormatException e) {
                println("Please input integer");
                continue;
            }
        }
        return number;
    }

    public static String getKey() {
        return new Scanner(System.in).nextLine();
    }

}
