package kyoto.freeprojects.oldbigbuddha.Card;

public abstract class Card {

    private int mIndex;

    public Card(int index) {
        mIndex = index;
    }

    public int getIndex() {
        return mIndex;
    }
}
