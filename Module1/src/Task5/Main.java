package Task5;

import java.util.Scanner;

/**
 * Created by Ivan Isaev on 15.03.2018.
 */
public class Main {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("For Y position:\n1:a\n2:b\n3:c\n4:d\n5:e\n6:f\n7:g\n8:h");
        System.out.println("Enter a start coordinat:");
        ChessKnight startPosition = checkInitPosition();
        System.out.println("Enter a next coordinat:");
        ChessKnight finishPosition = checkInitPosition();
        if (checkChessWay(startPosition, finishPosition)) {
            System.out.println("This way correct");
        } else {
            System.out.println("This way is not correct");
        }
    }

    public static boolean checkChessWay(ChessKnight start, ChessKnight finish) {
        int chessX = start.getxPosition();
        int chessFinishX = finish.getxPosition();
        char chessY = start.getyPosition();
        char chessFinishY = finish.getyPosition();
        int temp1 = Math.abs(chessX - chessFinishX);
        int temp2 = Math.abs((int) chessY - (int) chessFinishY);
        return ((temp1 == 1 && temp2 == 2) || (temp1 == 2 && temp2 == 1));
    }

    public static ChessKnight checkInitPosition() {
        System.out.print("Enter X position:>> ");
        int x = in.nextInt();
        System.out.print("Enter Y position:>> ");
        char y = (char)(96 + in.nextInt());
        if ((x > 0 && x < 9) && ((int) y > 96 && (int) y < 105)) {
            return new ChessKnight(x, y);
        } else {
            System.out.println("Error, incorrect position");
            return checkInitPosition();
        }
    }
}
