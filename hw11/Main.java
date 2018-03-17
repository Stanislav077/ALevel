import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * Created by Ivan Isaev on 16.03.2018.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter path:>> "); //E://lection12//untitled//src//demo
        String path = sc.nextLine();
        System.out.print("Enter name created file:>> ");
        String nameFile = sc.nextLine();
        long start = System.currentTimeMillis();
        File newFile = new File(path, nameFile);
        try {
            if (newFile.createNewFile()) {
                System.out.println("File created");
            } else {
                System.out.println("File already created");
                System.exit(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        writeIntoFile(path, nameFile);
        long finish = System.currentTimeMillis();
        System.out.println(finish - start);


    }

    public static void writeIntoFile(String path, String nameFile) {
        try (FileWriter fileWriter = new FileWriter(path + "//" + nameFile)) {
            seeDirectoryIerarchy(path, fileWriter, "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void seeDirectoryIerarchy(String path, FileWriter fileWriter, String temp) {
        File file = new File(path);
        if (file.listFiles() != null) {
            for (File list : file.listFiles()) {
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat();
                    long tempDate = list.lastModified();
                    fileWriter.write(temp + list.getName() + ":" + dateFormat.format(tempDate) + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (list.isDirectory()) {
                    seeDirectoryIerarchy(list.getPath(), fileWriter, temp + "\t");
                }
            }
        }
    }
}
