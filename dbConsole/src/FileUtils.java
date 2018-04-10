import java.io.*;
import java.util.ArrayList;

/**
 * Created by Ivan Isaev on 04.04.2018.
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
        return line;
    }

    static ArrayList<String> readKeysFile(String path) {
        ArrayList<String> arrayListIntoFile = new ArrayList<>();
        try (Reader reader = new FileReader(path);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            while (bufferedReader.ready() == true) {
                arrayListIntoFile.add(bufferedReader.readLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayListIntoFile;
    }

    static String key(ArrayList<String> line, int count){
        String query = "";
        if(count == 0){
            String[] key = line.get(0).split(" ");
            String keys = key[2].substring(key[2].indexOf("(") + 1, key[2].indexOf(")"));
            String table2 = key[2].substring(0, key[2].indexOf("("));
            String table1 = key[0].split(" ")[0];
            String[] key2 = line.get(1).split(" ");
            String keys2 = key2[2].substring(key2[2].indexOf("(") + 1, key2[2].indexOf(")"));
            query = "ALTER TABLE employees.`" +table1+ "` ADD FOREIGN KEY ("+keys+") REFERENCES " + table2 + "("+ keys2 +");";
            return query;
        } else if (count == 1) {
            String[] key = line.get(1).split(" ");
            String keys = key[2].substring(key[2].indexOf("(") + 1, key[2].indexOf(")"));
            String table2 = key[2].substring(0, key[2].indexOf("("));
            String table1 = key[0].split(" ")[0];
            String[] key2 = line.get(0).split(" ");
            String keys2 = key2[2].substring(key2[2].indexOf("(") + 1, key2[2].indexOf(")"));
            query = "ALTER TABLE employees.`" +table1+ "` ADD FOREIGN KEY ("+keys+") REFERENCES " + table2 + "("+ keys2 +");";
            return query;
            }
        return query;
    }
}