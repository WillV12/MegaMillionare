import java.util.Random;
import java.util.Scanner;

public class MegaMillions {
    static Scanner input = new Scanner(System.in);
    static Random ran = new Random();
    static double balance;
    static double totalWinnings = 0;
    static double totalSpent = 0;

    public static void main(String[] args) {
        initializeGame();
        
        // TODO: Run the game loop until the player can no longer play
        runGame();
        
        



        printGameSummary();
        input.close();
    }

    // TODO: Initialize the game (set balance, print welcome message)
    public static void initializeGame(){
        balance = 50.0;
        System.out.println("WELCOME TO MEGA MILLIONS");

    }

    // TODO: Run the game loop (handle multiple rounds of play)
    public static void runGame(){
        String buyTicket;
        do { 
            playRound();
            System.out.println("Do you want to play again? (yes/no)");
            buyTicket = input.nextLine();

            while (!("yes".equals(buyTicket.toLowerCase())) && !("no".equals(buyTicket.toLowerCase()))){
                System.out.println("\nPlease input yes or no...\n");
                System.out.println("Do you want to play again? (yes/no)");
                buyTicket = input.nextLine();
            } 

            switch(buyTicket.toLowerCase()){
                case "yes" ->  {
                    System.out.println("Buying Ticket...\n");
                }
                case "no" -> {
                    System.out.println("Ending program...\n");
                }
            }

        } while ("yes".equals(buyTicket.toLowerCase()));
    }

    // TODO: Play one round (handle number selection, ticket purchase, drawing numbers, checking results, updating balance)
    public static void playRound(){
        System.out.println("Do you want Quick Pick? (yes/no)");
        String quickPick = input.nextLine();

    }
    // TODO: Update balance after ticket purchase and winnings
    public static void updateBalance(){}

    // TODO: Print game summary (total spent, total winnings, final balance)
    public static void  printGameSummary(){

    }

    // TODO: Generate an array of 5 unique random numbers (1-70)

    // TODO: Get a valid number input from the user within a given range

    // TODO: Check if an array contains a specific number

    // TODO: Count matching numbers between user and winning numbers

    // TODO: Determine the prize amount based on matches

    // TODO: Get a random Megaplier value (2x, 3x, 4x, or 5x)
}
