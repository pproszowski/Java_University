import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GuessRandomNumberGame{
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        int min = 0;
        int max = 100;
        int decisionKey = 1;
        try{
            while(decisionKey == 1){
                int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
                int numberOfAttempts = 0;
                int guess = -1;
                while(guess != randomNum){
                    System.out.print("Guess a number: ");    
                    guess = scanner.nextInt();
                    if(guess < randomNum){
                        System.out.println("Typed number is less than number to guess");
                    }else if (guess > randomNum){
                        System.out.println("Typed number is greater than number to guess");
                    }
                    numberOfAttempts++;
                }

                System.out.println("Congratulations! You guess chosen randomly number!");
                System.out.println("Number of attempts: " + numberOfAttempts);
                System.out.println("If you want to play again type 1, otherwise type any key");
                decisionKey = scanner.nextInt();
            }
        }catch(Exception e){

        }
    }
}
