package lection9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Ivan Isaev on 28.02.2018.
 */
public class Demo {
    static StringBuilder stringBuilder = null;
    public static String readTryCatchFinally(String path) {
        try (BufferedReader reader = new BufferedReader((new FileReader(path)))){
            stringBuilder = new StringBuilder();

            String currentString;
            while ((currentString = reader.readLine()) != null) {
                stringBuilder.append(currentString);
                stringBuilder.append("\n");
            }
            // reader.close(); - тупанул, он сам закрывает этот поток в try-with-resources
        } catch (IOException e){
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(readTryCatchFinally("E:\\alevel\\src\\lection9\\ex.txt"));
    }
}
