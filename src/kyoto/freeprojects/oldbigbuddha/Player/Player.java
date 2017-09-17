package kyoto.freeprojects.oldbigbuddha.Player;

import kyoto.freeprojects.oldbigbuddha.Card.Card;
import kyoto.freeprojects.oldbigbuddha.Deck;

public abstract class Player {

    private String mName;
    private Card   mCard;
    private int    mIndex;

    public Player(String name, int index) {
        mName  = name;
        mIndex = index;
    }
    public abstract int turn();

    public String getName() {
        return mName;
    }

    public void draw(Deck deck) {
        mCard = deck.drawn();
    }
}
