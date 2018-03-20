import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * Created by Ivan Isaev on 14.03.2018.
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter path:>> "); //E://lection12//untitled//src//demo
        String path = sc.nextLine();
        System.out.print("Enter name created file:>> ");
        String nameFile = sc.nextLine();
        File newFile = new File(path, nameFile);
        newFile.createNewFile();
        File catalog = new File(path);
        File[] list = catalog.listFiles();
        try (FileWriter fileWriter = new FileWriter(path + "//" + nameFile)) {
            for (int i = 0; i < list.length; i++) {
                fileWriter.write(list[i].getName());
                fileWriter.write(" : ");
                long temp = list[i].lastModified();
                SimpleDateFormat dateFormat = new SimpleDateFormat();
                fileWriter.write(dateFormat.format(temp));
                fileWriter.write("\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
