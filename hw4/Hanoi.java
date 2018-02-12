package lection4.hw4;

import java.util.Scanner;

/**
 * Created by Ivan Isaev on 10.02.2018.
 */
public class Hanoi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a quantity ring:\n>> ");
        int n = in.nextInt();
        hanoi(n);
    }

    public static void hanoi(int n) {
        hanoiLocal(n, "A", "B", "C");
    }

    private static void hanoiLocal(int n, String a, String b, String c) {
        if (n != 0) {
            hanoiLocal(n - 1, a, c, b);
            System.out.printf("Transfer a ring from %s to %s\n", a, c);
            hanoiLocal(n - 1, b, a, c);
        }
    }
}

