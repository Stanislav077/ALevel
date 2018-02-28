package lection9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Ivan Isaev on 28.02.2018.
 */
public class Demo {
    public static String readTryCatchFinally(String path) {  // try/catch/finally
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(path));
        } catch (IOException e){
            e.printStackTrace();
        }
        StringBuilder stringBuilder = new StringBuilder();

        String currentString;
        try {
            while ((currentString = reader.readLine()) != null){
                stringBuilder.append(currentString);
                stringBuilder.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(readTryCatchFinally("E:\\alevel\\src\\lection9\\ex.txt"));
    }
}
