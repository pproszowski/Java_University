import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.InputMismatchException;

public class GuessRandomNumberGame{
    public static void main(String[] args){
        int min = 0;
        int max = 100;
        int decisionKey = 1;
        int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);

        while(decisionKey == 1){
        Scanner scanner = new Scanner(System.in);
            int numberOfAttempts = 0;
            int guess;
            try{
                do{
                    System.out.print("Guess a number: ");    
                    guess = scanner.nextInt();
                    numberOfAttempts++;
                }while(checkNumber(randomNum,guess));
            }catch(InputMismatchException e){
                System.out.println("Invalid input. Please try again.");
                continue;
            }

                System.out.println("************************************************************");
                System.out.println("Congratulations! You guess chosen randomly number!");
                System.out.println("Number of attempts: " + numberOfAttempts);
                System.out.println("If you want to play again type 1, otherwise type any other key");

            try{
                decisionKey = scanner.nextInt();
            }catch(InputMismatchException e){
                decisionKey = 0;
            }
        }
    }

    private static boolean checkNumber(int randomNum, int guess){
        if(guess < randomNum){
            System.out.println("Typed number is less than number to guess");
        }else if (guess > randomNum){
            System.out.println("Typed number is greater than number to guess");
        }else{
            return false;
        }

        return true;
    }
}
