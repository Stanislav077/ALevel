package lection6.hw6;

/**
 * Created by Ivan Isaev on 20.02.2018.
 */

class Main3 {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal animal1 = new Animal(true, 40);
        animal.see(true);
        animal1.lookProfile();
        Mammals mammals = new Mammals(4);
        Mammals mammals1 = new Mammals(false, 30);
        System.out.println("Have limbs: " + mammals.haveLi());
        mammals1.lookProfile();
        Fish fish = new Fish();
        Fish fish1 = new Fish(true, 1);
        Fish fish2 = new Fish(true);
        fish1.lookProfile();
        fish.seeFish();
        fish2.haveSq();
        Hamster hamster = new Hamster(true, 10);
        Hamster hamster1 = new Hamster(true, true);
        hamster.lookProfile();
        hamster1.lookHamster();
        Sturgeon sturgeon = new Sturgeon();
        Sturgeon sturgeon1 = new Sturgeon(1);
        Sturgeon sturgeon2 = new Sturgeon(false, 2);
        sturgeon.seeFish();
        sturgeon1.lookSturgeon();
        sturgeon2.lookProfile();
    }
}

class Animal {

    static boolean eat;
    static int walkSpeed;

    Animal() {

    }

    Animal(boolean eat, int walkSpeed) {
        this.eat = eat;
        this.walkSpeed = walkSpeed;
    }

    public void see(boolean see) {
        if (see == true) {
            System.out.println("See");
        } else {
            System.out.println("No see");
        }
    }

    public void lookProfile() {
        if (eat == true) {
            System.out.println("This animal can eat and speed " + walkSpeed);
        } else {
            System.out.println("Soon die");
        }
    }
}

class Mammals extends Animal {

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

class Fish extends Animal {

    static boolean haveSquama;

    Fish() {

    }

    Fish(boolean eat, int walkSpeed) {
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

class Hamster extends Mammals {

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

class Sturgeon extends Fish {
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