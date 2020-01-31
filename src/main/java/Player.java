public class Player {

    private String name;
    private Card hand;

    public Player(String name, Card hand){
        this.name = name;
        this.hand =hand;
    }

    public String getName() {
        return this.name;
    }

    public Card getHand() {
        return this.hand;
    }
}
