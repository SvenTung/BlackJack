import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardTest {

    private Card card;

    @Before
    public void before(){
        card = new Card(SuitType.HEARTS,RankType.QUEEN);
    }

    @Test
    public void canGetSuit(){
        assertEquals(SuitType.HEARTS, card.getSuit());
    }

    @Test
    public void canGetRank(){
        assertEquals(RankType.QUEEN, card.getRank());
    }

    @Test
    public void canGeRankValue(){
        assertEquals(12, card.getRank().getValueFromRank());
    }

    @Test
    public void canGetRanksArray(){
        System.out.println(RankType.getRanks());
    }

    @Test
    public void canGetSuitsArray(){
        System.out.println(SuitType.getSuits());
    }


}
