package lection6.hw6.People;

import java.util.Scanner;

/**
 * Created by Ivan Isaev on 27.02.2018.
 */
public class Warrior extends People {
    static String weapon;
    static String martialArts;

    Warrior() {

    }

    Warrior(int height, int weight) {
        super(height, weight);
    }

    Warrior(String weapon, String martialArts) {
        this.weapon = weapon;
        this.martialArts = martialArts;
    }

    public String choiseSpeciality() {
        String choise = "You choised weapon a " + weapon + " and martial arts " + martialArts;
        return choise;
    }

    public String profileSoldier() {
        String soldier = "Profile: height -" + height + " weight " + weight;
        return soldier;
    }

    public static void wantWar() {
        Scanner in = new Scanner(System.in);
        System.out.print("Do you want to fight?(y/n)");
        String choice = in.next();
        if (choice.equals("y")) {
            System.out.println("Enter a aim: ");
            String aim = in.next();
            System.out.println("Go with war on " + aim);
        } else if (choice.equals("n")) {
            System.out.println("We are not going to fight");
        }
    }

    public static void see(boolean see) {
        if (see == true) {
            System.out.println("OK");
        } else {
            System.out.println("Very bad");
        }
    }
}
