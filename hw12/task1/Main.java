package hw12;

import hw12.Animal.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Ivan Isaev on 18.03.2018.
 */
public class Main {
    public static List<Animal> animalList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter path:>> ");//E:\alevel\src\hw12
        String path = sc.nextLine();
        System.out.print("Enter name created file:>> ");
        String nameFile = sc.nextLine();
        path = path + "\\" + nameFile;
        File newFile = new File(path);
        WrapperClass wrapperClass = new WrapperClass(path);
        try {
            if(newFile.exists()){
                if(newFile.length() == 0){
                    animalList = initDefaultAnimal();
                    wrapperClass.writeIntoFile(animalList, path);
                } else {
                    animalList = wrapperClass.readFile(path);
                }
            } else{
                newFile.createNewFile();
                animalList = initDefaultAnimal();
                wrapperClass.writeIntoFile(animalList, path);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }


    public static List<Animal> initDefaultAnimal() {
        List<Animal> animalList = new ArrayList<>();
        animalList.add(new Fish(true, 3));
        animalList.add(new Fish(false, 5));
        animalList.add(new Hamster(true, 5));
        animalList.add(new Mammals(true, 4));
        animalList.add(new Sturgeon(true, 3));
        return animalList;
    }
}
