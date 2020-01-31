import java.util.ArrayList;

public class Runner {



    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<>();
        Deck deck = new Deck();
        deck.populate();
        deck.shuffle();

        UI ui = new UI();

        ui.welcomeUser();

        String name = ui.getPlayerName();

        //initalises the players
        Player dealer = new Player("The Dealer");
        Player player = new Player(name);


        // adds players to the players arraylist
        players.add(dealer);
        players.add(player);

        // deals 2 cards to each player
        for (Player person : players){
            person.addCard(deck.deal());
            person.addCard(deck.deal());
        }

        // gets the card in the player's hand and shows it
        String playerDisplayString = "You have a";
        for (int i = 0; i < player.getHand().size(); i++){
            Card card = player.getHand().get(i);
            playerDisplayString = ui.buildDisplayString(playerDisplayString, card.getRank(), card.getSuit());
        }
        ui.showHand(playerDisplayString);



//        ui.showDealerCard(dealerRank, dealerSuit);
//        int playerRankValue = playerRank.getValueFromRank();
//        int playerSuitValue = playerSuit.getValueFromSuit();
//        int dealerRankValue = dealerRank.getValueFromRank();
//        int dealerSuitValue = dealerSuit.getValueFromSuit();

//        if (playerRankValue == dealerRankValue){
//            if (playerSuitValue > dealerSuitValue) {
//                ui.playerWins();
//            }
//            else {
//                ui.playerLoses();
//            }
//        }
//        else if (playerRankValue > dealerRankValue){
//            ui.playerWins();
//        }
//        else {
//            ui.playerLoses();
//        }
    }
}
