package lection4.hw4;

/**
 * Created by Ivan Isaev on 12.02.2018.
 */
public class Fibonaci {
    public static void main(String[] args) {
        fibo();
    }

    public static void fibo() {
        int fib1 = 1;
        int fib2 = 1;
        int temporary;
        System.out.print(fib1 + " " + fib2 + " ");
        for (int i = 0; i < 9; i++) {
            temporary = fib1 + fib2;
            System.out.print(temporary + " ");
            fib1 = fib2;
            fib2 = temporary;
        }
    }
}
