import java.io.*;
import java.util.ArrayList;

/**
 * Created by Ivan Isaev on 04.04.2018.
 */
public class FileUtils {

    /*public static void main(String[] args) {
        readCSV("E:\\alevel\\src\\dbConsole\\src\\files\\employees.csv");
        parseLine(arrayListIntoFile);
        int count = 0;
        for(int i = count; i < arrayListIntoFile.size(); i++){
            for (int j = 0; j < length; j++){
                System.out.print(line.get(count).toString() + " ");
                count++;
            }
            System.out.println();
        }
    }*/
    static ArrayList<String> arrayListIntoFile = new ArrayList<>();

    static ArrayList<String> readDirectory(String path){
        ArrayList<String> nameFileInDirectory = new ArrayList<>();
        File file = new File(path);
        if(file.listFiles() != null) {
            for (File list : file.listFiles()) {
                nameFileInDirectory.add((list.getName().split("\\.")[0]));
            }
        }
        return nameFileInDirectory;
    }

    static void readCSV(String path){

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
    }

    static ArrayList<String> parseLine(ArrayList<String> arrayListIntoFile){
        ArrayList<String> line = new ArrayList<>();
        int length = arrayListIntoFile.get(1).split(",").length;
        for(int i = 0; i < arrayListIntoFile.size(); i++){
            for (int j = 0; j < length; j++) {
                 line.add(arrayListIntoFile.get(i).split(",")[j]);
            }
        }
        return line;
    }
}