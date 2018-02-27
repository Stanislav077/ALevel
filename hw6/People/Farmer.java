package lection6.hw6.People;

/**
 * Created by Ivan Isaev on 27.02.2018.
 */
public class Farmer extends People {
    static String attachment;
    static int squareLand;

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
