package lection6.hw6.People;

/**
 * Created by Ivan Isaev on 27.02.2018.
 */
public class Main {
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
