package kyoto.freeprojects.oldbigbuddha.Card;

public enum CardName {
    ONE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    TEN,
    FIFTEEN,
    TWENTY,;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
