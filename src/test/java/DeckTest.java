import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeckTest {

    private Deck deck;

    @Before
    public void before(){
        deck = new Deck();
    }

    @Test
    public void deckStartsEmpty(){
        assertEquals(0,deck.deckCount());
    }

    @Test
    public void canPopulate(){
        deck.populate();
        assertEquals(52, deck.deckCount());
    }

    @Test
    public void canShuffle(){
        deck.populate();
        System.out.println(deck.getDeck());
        deck.shuffle();
        System.out.println(deck.getDeck());
    }

    @Test
    public void canDeal(){
        deck.populate();
        System.out.println(deck.deal());
    }
}
