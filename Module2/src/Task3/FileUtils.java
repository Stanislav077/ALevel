package Task3;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Ivan Isaev on 07.04.2018.
 */
public class FileUtils {

    static ArrayList<String> readDirectory(String path){
        ArrayList<String> nameFileInDirectory = new ArrayList<>();
        File file = new File(path);
        if(file.listFiles() != null) {
            for (File list : file.listFiles()) {
                if(list.getName().equals("index.txt") || list.getName().equals(("select.sql"))){
                    continue;
                }
                nameFileInDirectory.add((list.getName().split("\\.")[0]));
            }
        }
        return nameFileInDirectory;
    }

    static ArrayList<String> readCSV(String path){
        ArrayList<String> arrayListIntoFile = new ArrayList<>();
        try(Reader reader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(reader)){
            while (bufferedReader.ready() == true){
                arrayListIntoFile.add(bufferedReader.readLine());
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return arrayListIntoFile;
    }

    static ArrayList<String> parseLine(ArrayList<String> arrayListIntoFile){
        ArrayList<String> line = new ArrayList<>();
        int length = arrayListIntoFile.get(0).split(",").length;
        for(int i = 0; i < length; i++){
            line.add(arrayListIntoFile.get(0).split(",")[i].replace("\"", ""));
        }
        return line;
    }
    static ArrayList<String> parseLineValues(ArrayList<String> arrayListIntoFile, int count){
        ArrayList<String> line = new ArrayList<>();
        int length = arrayListIntoFile.get(0).split(",").length;
        for(int j = 0; j < length; j++) {
            line.add(arrayListIntoFile.get(count).split(",")[j]);
        }
        count++;
        return line;
    }
}
