package Task2;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Ivan Isaev on 13.03.2018.
 */
public class GuessNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rn = new Random();
        System.out.print("Hello, this wonderfull game!!!\nEnter number to how many guessing\n>> ");
        int n = in.nextInt();
        System.out.print("Enter the number of attempts with how much you guess the number\n>> ");
        int k = in.nextInt();
        int ran = rn.nextInt((n-1) + 1) + 1;
        System.out.println("The computer made a guess. Guess!!!");
        while (k > 0){
            System.out.print("Enter a number\n>> ");
            int guess = in.nextInt();
            if (guess == ran){
                System.out.println("Congratulations. You guessed a number!!!");
                break;
            } else if (guess > ran){
                System.out.println("The number that the computer guess is less than the number you entered.\nTRY YET!");
                k--;
            } else if( guess < ran){
                System.out.println("The number that the computer guess is more than the number you entered.\nTRY YET!");
                k--;
            }
            if(k == 0){
                System.out.println("GAME OVER!!!");
            }
        }
    }
}
