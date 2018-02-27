package lection4.hw4;

import java.util.Scanner;

/**
 * Created by Ivan Isaev on 12.02.2018.
 */
public class sumNumber {
    public static void main(String[] args) {
        System.out.println(sumNumber());
    }

    public static int sumNumber() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a some integer number:\n>> ");
        int number = in.nextInt();
        int sum = 0;
        while (number > 0) {
            sum = sum + number % 10;
            number = number / 10;
        }
        return sum;
    }
}
