package hw12;

import hw12.Animal.Animal;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan Isaev on 18.03.2018.
 */
public class WrapperClass {
    public String path;

    WrapperClass(String path) {
        this.path = path;
    }

    public void writeIntoFile(List<Animal> animalList, String path) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            for (Animal an : animalList) {
                oos.writeObject(an);
                oos.flush();
            }
        } catch (IOException e) {
            System.out.println("Some error IOException" + e);
        }
    }

    public List<Animal> readFile(String path) {
        List<Animal> animalList = new ArrayList<>();
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(path))) {
            boolean check = true;
            while (check) {
                try {
                    animalList.add((Animal) input.readObject());
                } catch (EOFException e) {
                    check = false;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            System.out.println("Some error: " + e);
        }
        return animalList;
    }
}
