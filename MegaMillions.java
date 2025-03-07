import java.util.Arrays;
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
    static int megaBaller;
    static int winBall;
     
     
        public static void main(String[] args) {
            initializeGame();
            runGame();
            printGameSummary();
            input.close();
        }
     
     
        public static void initializeGame(){
            balance = 50.0;
            System.out.println("\n\n\nWELCOME TO MEGA MILLIONS");
     
     
        }
     
     
        public static void runGame(){
            String buyTicket;
            do { 
                playRound();
                System.out.print("\n\nDo you want to play again? (yes/no): ");
                buyTicket = input.nextLine();
     
     
                while (!("yes".equals(buyTicket.toLowerCase())) && !("no".equals(buyTicket.toLowerCase()))){
                    System.out.println("\nPlease input yes or no...\n");
                    System.out.print("Do you want to play again? (yes/no): ");
                    buyTicket = input.nextLine();
                } 
                
     
                switch(buyTicket.toLowerCase()){
                    case "yes" ->  {
                        System.out.println("\n\nBuying Ticket...\n");
                    }
                    case "no" -> {
                        System.out.println("\n\nEnding program...\n");
                    }
                }

                if (balance < 2.0){
                    System.out.println("Not enough money...\nGo home...");
                }
     
            } while ("yes".equals(buyTicket.toLowerCase()) && balance >= 2.0);
        }
     
     
        public static void playRound(){
            System.out.println("===================================\n===================================\n\t    WELCOME\n\tYou have: $" + balance + "\n===================================\n" +
                                "===================================");
            int expense = 2;
            int megaplier = 1;
            winBall = ran.nextInt(25) + 1; 

            System.out.print("\nDo you want Quick Pick? (yes/no): ");
            String quickPick = input.nextLine();
            while (!("yes".equals(quickPick.toLowerCase())) && !("no".equals(quickPick.toLowerCase()))){
                System.out.println("\nPlease input yes or no...\n");
                System.out.print("\nDo you want Quick Pick? (yes/no): ");
                quickPick = input.nextLine();
            } 
     
     
            switch(quickPick.toLowerCase()){
                case "yes" ->  {
                    userNums = generateNumbers(true);
                    System.out.println("Your quick pick: " + Arrays.toString(userNums) + "\nYour MegaBall: " + megaBaller);
                }
                case "no" -> {
                   userNums = getValidNumber();
                }}


                System.out.println("____________________________________________________________________________________________");
                System.out.print("\nGo for MEGAPLIER for just one dollar? (yes/no): ");
                String goMega = input.nextLine();

                while (!("yes".equals(goMega.toLowerCase())) && !("no".equals(goMega.toLowerCase()))){
                    System.out.println("\nPlease input yes or no...\n");
                    System.out.print("Go for MEGAPLIER for just one dollar? (yes/no): ");
                    goMega = input.nextLine();
                } 
                
                switch(goMega.toLowerCase()){
                    case "yes" ->{
                        if (balance - expense >= 1.0){
                        megaplier = getRandomMegaplier();
                        expense += 1;}
                        else{
                            System.out.println("Cannot afford");
                        }
                    }
                }
    
            winningNums = generateNumbers(false);
            int matches = countMatches(winningNums, userNums);
            long prize = getPrize(matches, megaplier);
            System.out.println("\n\nWinning Numbers: " + Arrays.toString(winningNums));
            System.out.println("Winning Megaball: " + winBall + "\n____________________________________________________________________________________________");

            updateBalance(prize, expense);
        }
        public static void updateBalance(long prize, int expense){
            totalWinnings += prize;
            balance += prize;
            totalSpent += expense;
            balance -= expense;
            
        }
     
     
        public static void  printGameSummary(){
            System.out.println("===================================\n       \tGAME OVER\n===================================\n");
            System.out.print("Current Balance: $");
            System.out.printf("%.2f\n", balance);
            System.out.print("Total Winnings: $");
            System.out.printf("%.2f\n", (totalWinnings));
            System.out.print("Total Expenditure: $");
            System.out.printf("%.2f\n", totalSpent);
            System.out.println("===================================\n===================================\n");

        }
     
     
        public static int[] generateNumbers(boolean mega){
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
            if (mega){
                megaBaller = ran.nextInt(25) + 1;
            }
            return numbers;

        }
     
     
        public static int[] getValidNumber(){
            int[] userList = new int[5];
            int userNum;
            boolean loop;
            boolean loop2;
            for (int i = 0; i < 5; i++){
                do { 
                    System.out.print("\nNumber " + (i+1) + ": ");
                    userNum = input.nextInt();
                    if (((userNum > 0) && (userNum < 71)) && (!(contains(userList, userNum)))){
                        userList[i] = userNum;
                        loop = false;
                    } else{
                        System.out.println("\nMake sure you enter within the range & no repeat values...");
                        loop = true;
                    }
                } while (loop);
    
                
            }
            do {
                    System.out.print("\nInput a number 1-25 for the MEGABALL: ");
                    megaBaller = input.nextInt();
                if ((megaBaller > 0) && (megaBaller < 26)){
                    loop2 = false;
                } else{
                    System.out.println("\nPlease input a number 1-25...");
                    loop2 = true;
                } 
            }while(loop2);
 
        return userList;
    }
 
 
    public static boolean contains(int[] array, int target){
        for (int i = 0; i < array.length; i++){
            if (array[i] == target){
                return true;
            } 
        }
        return false;
    }
 
 
    public static int countMatches(int[] winningNums, int[] userNums){
        int count = 0;
        for (int i = 0; i < 5; i++){
            if (contains(winningNums, userNums[i])){
                count++;
            }
        }

        return count;
    }
 
 
    public static long getPrize(int numMatches, int megaplier){
        long prize = 0;
        boolean mega = megaBaller == winBall;
        switch(numMatches){
            case 5 ->{
                if (mega){
                    
                    prize = 1000000000;
                } else{
                    prize = 1000000 * megaplier;
                }
            }
            case 4->{
                if(mega){
                    prize = 10000 * megaplier;
                } else{
                    prize = 500 * megaplier;
                }
            }
            case 3 ->{
                if (mega){
                    prize = 200 * megaplier;
                } else{
                    prize = 10 * megaplier;
                }
            }
            case 2 ->{
                if (mega){
                    prize = 10 * megaplier;
                }
            }
            case 1 ->{
                if (mega){
                    prize = 4 * megaplier; 
                }
            }
            case 0 ->{
                if(mega){
                    prize = 2 * megaplier;
                }
            }
        }
        System.out.println("\n\n____________________________________________________________________________________________");
        System.out.println("YOU WON: $" );
        System.out.printf("%d", prize);
        return prize;
    }
 
 
    public static int getRandomMegaplier(){
        return ran.nextInt(5) + 1;
    }
}