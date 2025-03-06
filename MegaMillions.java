import java.util.Random;
import java.util.Scanner;
 
 
public class MegaMillions {
    static Scanner input = new Scanner(System.in);
    static Random ran = new Random();
    static double balance;
    static double totalWinnings = 0;
    static double totalSpent = 0;
    static int[] winningNums;
    static int[] userNums;
 
 
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
                    balance -= 2.0;
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
        while (!("yes".equals(quickPick.toLowerCase())) && !("no".equals(quickPick.toLowerCase()))){
            System.out.println("\nPlease input yes or no...\n");
            System.out.println("Do you want Quick Pick? (yes/no)");
            quickPick = input.nextLine();
        } 
 
 
        switch(quickPick.toLowerCase()){
            case "yes" ->  {
                userNums = generateNumbers();
            }
            case "no" -> {
               userNums = getValidNumber();
            }}

        winningNums = generateNumbers();
        int matches = countMatches(winningNums, userNums);
        System.out.println(matches + "\nUserNums: " + UserNums.toString() + "\nWinningNums: " + winningNums.toString());
 
 
    }
    // TODO: Update balance after ticket purchase and winnings
    public static void updateBalance(){}
 
 
    // TODO: Print game summary (total spent, total winnings, final balance)
    public static void  printGameSummary(){
        System.out.println(balance);
        System.out.println(totalWinnings);
        System.out.println(totalSpent);
    }
 
 
    // TODO: Generate an array of 5 unique random numbers (1-70)
    public static int[] generateNumbers(){
        int[] numbers = new int[5];
        boolean loop;
        int randNum;
 
 
        for (int i = 0;  i < 5; i++){
            do {
                randNum = ran.nextInt(70) + 1;
                loop = contains(numbers, randNum);
            } while (loop);
            numbers[i] = randNum;
        }
        return numbers;
    }
 
 
    // TODO: Get a valid number input from the user within a given range
    public static int[] getValidNumber(){
        int[] userList = new int[5];
        int userNum;
        boolean loop;
        for (int i = 1; i <= 5; i++){
            do { 
                System.out.println("Input a number between 1-70");
                userNum = input.nextInt();
                if (((userNum > 0) && (userNum < 71)) || contains(userList, userNum)){
                    System.out.println("Make sure you enter within the range ");
                    loop = false;
                } else{
                    loop = true;
                }
            } while (loop);
        }
 
 
        return userList;
    }
 
 
    // TODO: Check if an array contains a specific number
    public static boolean contains(int[] array, int target){
        for (int i = 0; i < array.length; i++){
            if (array[i] == target){
                return true;
            } 
        }
        return false;
    }
 
 
    // TODO: Count matching numbers between user and winning numbers
    public static int countMatches(int[] winningNums, int[] userNums){
        int count = 0;
        for (int i = 0; i < 6; i++){
            if (contains(winningNums, userNums[i])){
                count++;
            }
        }

        return count;
    }
 
 
    // TODO: Determine the prize amount based on matches
 
 
    // TODO: Get a random Megaplier value (2x, 3x, 4x, or 5x)
}