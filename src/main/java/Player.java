import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Card> hand;
    private int value;

    public Player(String name){
        this.name = name;
        this.hand = new ArrayList<>();
        this.value = 0;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Card> getHand() { return this.hand; }

    public int getValue() {
        this.value = 0;
        for (Card card: this.hand){
            this.value += card.getRank().getValueFromRank();
        }
        return this.value;
    }

    public void addCard(Card card) {
        this.hand.add(card);
        this.value += card.getRank().getValueFromRank();
    }


}
