package lection6.hw6.Animal;

/**
 * Created by Ivan Isaev on 27.02.2018.
 */
public class Mammals extends Animal {
    static int haveLimbs;

    Mammals() {

    }

    Mammals(int haveLimbs) {
        this.haveLimbs = haveLimbs;
    }

    Mammals(boolean eat, int walkSpeed) {
        super(eat, walkSpeed);
    }

    @Override
    public void lookProfile() {
        super.lookProfile();
        System.out.println("Override");
    }

    public int haveLi() {
        return haveLimbs;
    }
}
