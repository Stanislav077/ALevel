package lection6.hw6.Animal;

/**
 * Created by Ivan Isaev on 27.02.2018.
 */
public class Sturgeon extends Fish {
    static int size;

    Sturgeon() {

    }

    Sturgeon(int size) {
        this.size = size;
    }

    Sturgeon(boolean eat, int walkSpeed) {
        super(eat, walkSpeed);
    }

    @Override
    public void lookProfile() {
        super.lookProfile();
    }

    public void lookSturgeon() {
        System.out.println("Size: " + size);
    }

    @Override
    public void seeFish() {
        super.seeFish();
    }
}
