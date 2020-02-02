import java.util.ArrayList;

public enum RankType {

    ACE(11),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(10),
    QUEEN(10),
    KING(10),
    ONE(1);


    private final int value;

    RankType(int value){
        this.value = value;
    }

    public int getValueFromRank(){
        return this.value;
    }

    public static ArrayList<RankType> getRanks(){
        ArrayList<RankType> ranksArray = new ArrayList<RankType>();
        for (RankType rank: RankType.values()){
            ranksArray.add(rank);
        }
        ranksArray.remove(13);
        return ranksArray;
    }
}
