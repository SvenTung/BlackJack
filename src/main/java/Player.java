import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Card> hand;

    public Player(String name){
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Card> getHand() { return this.hand; }

    public void addCard(Card card) {
        this.hand.add(card);
    }

    public int totalValue(){
        int total = 0;
        for (Card card: this.hand) {
            total += card.getRank().getValueFromRank();
        }
        return total;
    }
}
