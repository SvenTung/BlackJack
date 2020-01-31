import java.util.ArrayList;

public enum SuitType {

    DIAMONDS(1),
    CLUBS(2),
    HEARTS(3),
    SPADES(4);

    private final int value;

    SuitType(int value) {
        this.value = value;
    }

    public int getValueFromSuit() {
        return value;
    }

    public static ArrayList<SuitType> getSuits(){
        ArrayList<SuitType> suitsArray = new ArrayList<SuitType>();
        for (SuitType suit: SuitType.values()){
            suitsArray.add(suit);
        }
        return suitsArray;
    }
}
