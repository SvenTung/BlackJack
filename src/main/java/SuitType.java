import java.util.ArrayList;

public enum SuitType {

    DIAMONDS,
    CLUBS,
    HEARTS,
    SPADES;

    public static ArrayList<SuitType> getSuits(){
        ArrayList<SuitType> suitsArray = new ArrayList<SuitType>();
        for (SuitType suit: SuitType.values()){
            suitsArray.add(suit);
        }
        return suitsArray;
    }
}
