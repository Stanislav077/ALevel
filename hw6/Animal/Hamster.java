package lection6.hw6.Animal;

/**
 * Created by Ivan Isaev on 27.02.2018.
 */
public class Hamster extends Mammals {
    static boolean thickFur;
    static boolean smallSize;

    Hamster(boolean thickFur, boolean smallSize) {
        this.thickFur = thickFur;
        this.smallSize = smallSize;
    }

    Hamster(boolean eat, int walkSpeed) {
        super(eat, walkSpeed);
    }

    @Override
    public void lookProfile() {
        super.lookProfile();
        System.out.println("Override parent-child-child2");
    }

    public void lookHamster() {
        if (thickFur == true && smallSize == true) {
            System.out.println("Ideal Hamster");
        } else {
            System.out.println("Bad Hamster");
        }
    }
}
