package kyoto.freeprojects.oldbigbuddha;

import kyoto.freeprojects.oldbigbuddha.Player.HumanPlayer;
import kyoto.freeprojects.oldbigbuddha.Player.Player;

import java.util.Scanner;

import static kyoto.freeprojects.oldbigbuddha.Game.*;

public class Main {

    public static void main(String[] args) {
        clear();
        println("Welcome to Coyote!");
        println("(C) BigBuddha 2017");
        getKey();
        clear();
        Game game = new Game();

    }
}
