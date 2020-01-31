import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Deck {

    private ArrayList<Card> deck;



    public Deck(){
        this.deck = new ArrayList<Card>();
    }

    public void populate(){
        for(RankType rank: RankType.getRanks()) {

            for (SuitType suit : SuitType.getSuits()) {
                Card card = new Card(suit, rank);
                this.deck.add(card);
            }
        }
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public int deckCount(){
        return this.deck.size();
    }

    public void shuffle(){
        Collections.shuffle(this.deck);
    }

    public Card deal(){
        return this.deck.remove(0);
    }
}
