package lection6.hw6.People;

/**
 * Created by Ivan Isaev on 27.02.2018.
 */
public class People {
    static int height;
    static int weight;

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
