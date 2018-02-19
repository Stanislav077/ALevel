package lection4.hw4;

/**
 * Created by Ivan Isaev on 12.02.2018.
 */
public class luckyTicket {
    public static void main(String[] args) {
        luckyTicket();
    }

    public static void luckyTicket() {
        int sum = 0;
        for (int i = 000001; i <= 999999; i++) {
            int n1 = i / 100000;
            int n2 = (i % 100000) / 10000;
            int n3 = (i % 10000) / 1000;
            int n4 = (i % 1000) / 100;
            int n5 = (i % 100) / 10;
            int n6 = i % 10;
            if (n1 + n2 + n3 == n4 + n5 + n6) {
                sum++;
            }
        }
        System.out.println("Sum lucky ticket = " + sum);
    }
}
