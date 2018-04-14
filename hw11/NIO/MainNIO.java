package hw11.NIO;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;

/**
 * Created by Ivan Isaev on 26.03.2018.
 */
public class MainNIO {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        writeIntoFile("E:\\alevel\\src");
        long finish = System.currentTimeMillis();
        System.out.println(finish - start);
        System.out.println("Well Done");
    }

    public static void writeIntoFile(String path) {
        Path newPath = Paths.get(path + "/out.txt");
        try (BufferedWriter fileWriter = Files.newBufferedWriter(newPath)) {
            seeDirectoryIerarchyNIO(Paths.get(path), fileWriter, "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void seeDirectoryIerarchyNIO(Path path, BufferedWriter fileWriter, String temp) {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
            for (Path files : stream) {
                if (Files.isReadable(path)) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat();
                    FileTime lastModified = Files.getLastModifiedTime(files);
                    String name = files.getName(files.getNameCount() - 1).toString();
                    if (Files.isDirectory(path)) {
                        fileWriter.write(String.format(temp + name + " : " + dateFormat.format(lastModified.toMillis()) + "\n"));
                        seeDirectoryIerarchyNIO(files, fileWriter, temp + "\t");
                        continue;
                    }
                    fileWriter.write(temp + name + " : " + dateFormat.format(lastModified.toMillis()) + "\n");
                }
            }
        } catch (IOException e) {
            String paths = "E:\\alevel\\src\\hw11\\NIO";
            Path newP = Paths.get(paths + "/log.txt");
            try(BufferedWriter bufferedWriter = Files.newBufferedWriter(newP)) {
                bufferedWriter.write(e.toString());
            } catch (IOException e1){
                e1.printStackTrace();
            }
        }
    }
}