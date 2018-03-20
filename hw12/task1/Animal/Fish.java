package hw12.Animal;

/**
 * Created by Ivan Isaev on 27.02.2018.
 */
public class Fish extends Animal {
    static boolean haveSquama;

    Fish() {

    }

    public Fish(boolean eat, int walkSpeed) {
        super(eat, walkSpeed);
    }

    Fish(boolean haveSquama) {
        this.haveSquama = haveSquama;
    }

    @Override
    public void lookProfile() {
        super.lookProfile();
    }

    public void seeFish() {
        System.out.println("Class fish");
    }

    public void haveSq() {
        System.out.println(haveSquama);
    }
}
