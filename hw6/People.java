package lection6.hw6;

import java.util.Scanner;

/**
 * Created by Ivan Isaev on 19.02.2018.
 */
class Main {
    public static void main(String[] args) {
        People people1 = new People();
        People people2 = new People(170, 75);
        people1.walk(40);
        people1.see(true);
        people1.talk(false);
        people1.see();
        people2.lookProfile();
        System.out.println();
        Warrior warrior1 = new Warrior();
        Warrior warrior2 = new Warrior(190, 110);
        warrior1.wantWar();
        warrior1.see(true);
        warrior2.profileSoldier();
        System.out.println();
        Ninja ninja = new Ninja();
        ninja.choiseSpec("shuriken", "kung-fu");
        System.out.println();
        Farmer farmer1 = new Farmer(180, 80, "non eco", 100);
        Farmer farmer2 = new Farmer();
        farmer2.digGarden(true);
        farmer1.profileFarmer();
        EcoFarmer ecoFarmer = new EcoFarmer(190, 90, "eco", 20);
        ecoFarmer.profileFarmer();
    }
}

class People {

    static int height;
    int weight;

    People(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    People() {
    }

    public static void walk(int distance) {
        System.out.println("Walk a distance - " + distance + " metres");
    }

    public static void see() {
        System.out.println("I'm blind");
    }

    public static void see(boolean see) {
        if (see == true) {
            System.out.println("Eyes open");
        } else {
            System.out.println("Eyes closed");
        }
    }

    public static void talk(boolean talk) {
        if (talk == true) {
            System.out.println("I can talk");
        } else {
            System.out.println("I can't talk");
        }
    }

    public String lookProfile() {
        String profile = "Profile: height " + height + " weight " + weight;
        return profile;
    }
}

class Warrior extends People {

    String weapon;
    String martialArts;

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

class Farmer extends People {

    String attachment;
    int squareLand;

    Farmer() {

    }

    Farmer(int height, int weight, String attachment, int squareLand) {
        super(height, weight);
        this.attachment = attachment;
        this.squareLand = squareLand;
    }


    public void profileFarmer() {
        String profile1 = "Height: " + height + ", weight: " + weight;
        String profile2 = "Attachment: " + attachment + ", squareLand: " + squareLand;
        System.out.println(profile1);
        System.out.println(profile2);
    }

    public static void digGarden(boolean choise) {
        if (choise == true) {
            System.out.println("DIG!!!");
        } else {
            System.out.println("NO DIG");
        }
    }
}

class Ninja extends Warrior {

    public static void choiseSpec(String weapon, String martialArts) {
        Warrior warrior = new Warrior(weapon, martialArts);
        String choise = warrior.choiseSpeciality();
        System.out.println(choise);
    }
}

class EcoFarmer extends Farmer {
    EcoFarmer(int height, int weight, String attachment, int squareLand) {
        super(height, weight, attachment, squareLand);
    }

    @Override
    public void profileFarmer() {
        super.profileFarmer();
    }
}
