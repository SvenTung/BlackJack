import java.util.ArrayList;

public class Runner {



    public static void main(String[] args) {

        // initialises the game state
        String game = "";

        // initialises a players arraylist
        ArrayList<Player> players = new ArrayList<>();

        // initialises the deck and populates it with all the cards and shuffles it
        Deck deck = new Deck();
        deck.populate();
        deck.shuffle();

        // initialises the ui module
        UI ui = new UI();

        // initialises the dealer
        Player dealer = new Player("The Dealer");

        // initialises the player's choice
        String choice = "";

        // welcomes the user to BlackJack
        ui.welcomeUser();

        // gets the user's name
        String name = ui.getPlayerName();

        // initialises the player
        Player player = new Player(name);

        // adds players to the players arraylist
        players.add(dealer);
        players.add(player);

        // deals 2 cards to each player
        for (Player person : players) {
            person.addCard(deck.deal());
            person.addCard(deck.deal());
            // checks if either player got dealt 2 aces and sets the value to 12 instead of 22
            if (person.getValue() > 21) {
                for (Card card : person.getHand()) {
                    if (card.getRank() == RankType.ACE){
                        card.setRank(RankType.ONE);
                        System.out.println("Changed the value of one of your ACEs to ONE to prevent you from going bust!");
                        break;
                    }
                }
            }
        }

        // checks for blackjack in either hand
        if (player.getValue() == 21 && dealer.getValue() == 21) {
            // if they are both 21 then it's a draw
            game = "Draw";
            ui.gameOver(player, dealer, game);
        } else if (player.getValue() == 21 && dealer.getValue() != 21) {
            // if the player gets BlackJack then they win
            game = "Won";
            ui.gameOver(player, dealer, game);
        } else if (player.getValue() != 21 && dealer.getValue() == 21) {
            // if the dealer gets BlackJack then the player loses
            game = "Lost";
            ui.gameOver(player, dealer, game);
        }



        while (!game.equals("Won") && !game.equals("Lost") && !game.equals("Draw")) {
            // player's turn
            while (!choice.equals("stick") && player.getValue() <= 21) {
                choice = "";
                // gets the cards in the player's hand and shows them
                String message = "You have a";
                ui.showHand(player.getHand(), message);

                // gets the value of the hand and displays it
                ui.displayValue(player.getValue());

                // gets the first card of the dealer and shows it to the player
                ui.showADealerCard(dealer.getHand().get(0));

                // asks the player to hit or stick
                while (!choice.equals("hit") && !choice.equals("stick")) {
                    choice = ui.hitOrStick();
                }

                // deals a card to the player if they hit
                if (choice.equals("hit")){
                    System.out.println("You hit and get another card.");
                    player.addCard(deck.deal());
                }

                // checks if the player can change an ACE to a 1
                if (player.getValue() > 21) {
                    for (Card card : player.getHand()) {
                        if (card.getRank() == RankType.ACE){
                            card.setRank(RankType.ONE);
                            System.out.println("Changed the value of your ACE to ONE to prevent you from going bust!");
                            break;
                        }
                    }
                }
            }

            //checks if player has gone bust
            if (player.getValue() > 21) {
                game = "Lost";
                System.out.println("You went bust!");
                ui.gameOver(player, dealer, game);
                break;
            }

            // dealer's turn
            while (dealer.getValue() < 16) {
                dealer.addCard(deck.deal());
                System.out.println("The dealer hits!");
            }

            //checks if dealer has gone bust
            if (dealer.getValue() > 21) {
                game = "Won";
                System.out.println("The dealer goes bust!");
                ui.gameOver(player, dealer, game);
                break;
            }

            // compares the values of each hand and checks which player has won if neither has gone bust
            if (player.getValue() == dealer.getValue()) {
                game = "Draw";
            } else if (player.getValue() > dealer.getValue()) {
                game = "Won";
            } else {
                game = "Lost";
            }
            ui.gameOver(player, dealer, game);
        }
    }
}
