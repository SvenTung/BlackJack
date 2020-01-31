public class Runner {



    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.populate();
        deck.shuffle();

        UI ui = new UI();

        ui.welcomeUser();

        String name = ui.getPlayerName();
        Card playerCard = deck.deal();
        RankType playerRank = playerCard.getRank();
        SuitType playerSuit = playerCard.getSuit();

        Player player = new Player(name, playerCard);

        ui.showHand(playerRank, playerSuit);

        Card dealerCard = deck.deal();
        RankType dealerRank = dealerCard.getRank();
        SuitType dealerSuit = dealerCard.getSuit();

        ui.showDealerCard(dealerRank, dealerSuit);
        int playerRankValue = playerRank.getValueFromRank();
        int playerSuitValue = playerSuit.getValueFromSuit();
        int dealerRankValue = dealerRank.getValueFromRank();
        int dealerSuitValue = dealerSuit.getValueFromSuit();

        if (playerRankValue == dealerRankValue){
            if (playerSuitValue > dealerSuitValue) {
                ui.playerWins();
            }
            else {
                ui.playerLoses();
            }
        }
        else if (playerRankValue > dealerRankValue){
            ui.playerWins();
        }
        else {
            ui.playerLoses();
        }
    }
}
