import java.util.Scanner;

public class UI {

    public void welcomeUser(){
        System.out.println("Welcome to Higher card game");
    }

    public String getPlayerName(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nPlease enter your name");
        String name = sc.nextLine();
        return name;
    }

    public String buildDisplayString(String message, RankType rank, SuitType suit){
        message = message + " " + rank.getValueFromRank() + " of " + suit.toString() + " and ";
        return message;
    }

    public void showHand(String message){
        System.out.println(message);
    }

    public void showDealerCard(RankType rank, SuitType suit){
        System.out.println("The dealer has " + rank.toString() + " of " + suit.toString() + ".");
    }

    public void playerWins() {
        System.out.println("You won! Congratulations!");
    }

    public void playerLoses() {
        System.out.println("You lost! Better luck next time!");
    }



}
