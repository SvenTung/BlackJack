import java.util.ArrayList;
import java.util.Scanner;

public class UI {

    public void welcomeUser(){
        System.out.println("Welcome to BlackJack");
    }

    public String getPlayerName(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nPlease enter your name");
        String name = sc.nextLine();
        return name;
    }

    public void showHand(ArrayList<Card> cards, String message){
        for (int i = 0; i < cards.size(); i++){
            Card card = cards.get(i);
            RankType rank = card.getRank();
            SuitType suit = card.getSuit();
            if (i != cards.size() - 1){
                message = message + " " + rank + " of " + suit + " and a";
            }
            else {
                message = message + " " + rank + " of " + suit + ".";
            }
        }
        System.out.println(message);
    }

    public void showADealerCard(Card card){
        System.out.println("The dealer has a " + card.getRank() + " of " + card.getSuit() + " and a facedown card.");
    }

    public void displayValue(int value){
        System.out.println("This totals to " + value + ".");
    }

    public String hitOrStick(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to hit or stick?");
        return sc.nextLine();
    }

    public void gameOver(Player player, Player dealer, String game){
        String message = "You have a";
        showHand(player.getHand(), message);
        displayValue(player.getValue());

        message = "The dealer has a";
        showHand(dealer.getHand(), message);
        displayValue(dealer.getValue());

        if (game.equals("Won")){
            System.out.println("You won! Congratulations!");
        } else if (game.equals("Lost")){
            System.out.println("You lost! Better luck next time!");
        } else {
            System.out.println("You drew with the Dealer.");
        }
    }
}
