package kyoto.freeprojects.oldbigbuddha.Player;

import static kyoto.freeprojects.oldbigbuddha.Game.*;

public class HumanPlayer extends Player {

    public HumanPlayer(String name, int index) {
        super(name, index);
        println("Your name is " + name);
    }

    @Override
    public int turn() {
        return getInteger();
    }
}
