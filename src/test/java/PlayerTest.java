import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    private Player player;
    private Card card;
    private Card card2;

    @Before
    public void before(){
        player = new Player("Jaden");
        card = new Card(SuitType.HEARTS, RankType.ACE);
        card2 = new Card(SuitType.SPADES, RankType.JACK);
    }

    @Test
    public void getName(){
        assertEquals("Jaden", player.getName());
    }

    @Test
    public void canAddCard(){
        assertEquals(0, player.getHand().size());
        player.addCard(card);
        assertEquals(1, player.getHand().size());
    }

    @Test
    public void getHand(){
        player.addCard(card);
        player.addCard(card2);
        ArrayList<Card> arrayList = new ArrayList<>();
        arrayList.add(card);
        arrayList.add(card2);
        assertEquals(arrayList, player.getHand());
    }

}
