package lection6.hw6.People;

/**
 * Created by Ivan Isaev on 27.02.2018.
 */
public class Ninja extends Warrior {
    public static void choiseSpec(String weapon, String martialArts) {
        Warrior warrior = new Warrior(weapon, martialArts);
        String choise = warrior.choiseSpeciality();
        System.out.println(choise);
    }
}
