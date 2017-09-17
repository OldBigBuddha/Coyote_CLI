package kyoto.freeprojects.oldbigbuddha;

import kyoto.freeprojects.oldbigbuddha.Card.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Card> mCards = new ArrayList<>();

    private ShuffleRandom mRandom;

    public Deck() {}

    public void make(int four, int five, int ten, int fifteen, int twenty) {
        generateCards(CardName.FOUR, four);
        generateCards(CardName.FIVE, five);
        generateCards(CardName.TEN,  ten);
        generateCards(CardName.FIFTEEN, fifteen);
        generateCards(CardName.TWENTY,  twenty);
    }

    public void make() {
        for (CardName name: CardName.values()) {
            if (name == CardName.TEN || name == CardName.FIFTEEN || name == CardName.TWENTY) {
                generateCards(name, 1);
            } else {
                generateCards(name, 4);
            }
        }
        Collections.shuffle(mCards);
        mRandom = new ShuffleRandom(0, mCards.size());
//        make(4, 4, 4, 4, 4);
    }

    public Card drawn() {
        int position = mRandom.getRandomInt();
        Card card = mCards.get(position);
        mCards.remove(position);
        if (mCards.size() == 0) make();
        return card;
    }

    private void generateCards(CardName name, int number) {
        for (int i = 0; i < number; i++) {
            switch (name) {
                            case ONE:
                                mCards.add(new One());
                                break;
                            case TWO:
                                mCards.add(new Two());
                                break;
                            case THREE:
                                mCards.add(new Three());
                            case FOUR:
                                mCards.add(new Four());
                                break;
                            case FIVE:
                                mCards.add(new Five());
                                break;
                            case TEN:
                                mCards.add(new Ten());
                                break;
                            case FIFTEEN:
                                mCards.add(new Fifteen());
                                break;
                            case TWENTY:
                                mCards.add(new Twenty());
                                break;
                        }
                    }
            }
}
