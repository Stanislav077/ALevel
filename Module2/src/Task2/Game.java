package Task2;

import java.util.Scanner;

/**
 * Created by Ivan Isaev on 07.04.2018.
 */
public class Game {

    static String st;

    public static String getSt() {
        return st;
    }

    public static void setSt(String st) {
        Game.st = st;
    }

    public static void main(String[] args) {
        PingPong pingPong = new PingPong();
        Thread pingpongThread = new Thread(pingPong);
        pingpongThread.start();
        while(pingpongThread.isAlive()){
            st = stringConsole();
        }
    }

    public static String stringConsole(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

}
