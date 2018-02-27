package lection6.hw6.Animal;

/**
 * Created by Ivan Isaev on 27.02.2018.
 */
public class Main {
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
