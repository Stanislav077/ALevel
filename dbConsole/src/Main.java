import java.util.ArrayList;

/**
 * Created by Ivan Isaev on 04.04.2018.
 */
public class Main {
    static int count;
    static FileUtils fileUtils = new FileUtils();
    static SQLUtils sqlUtils = new SQLUtils();
    static ArrayList<String> tableNames = new ArrayList<>();
    static ArrayList<String> intoFile = new ArrayList<>();
    static ArrayList<String> line = new ArrayList<>();
    static ArrayList<String> values = new ArrayList<>();
    static ArrayList<String> valuesLine = new ArrayList<>();
    public static void main(String[] args) {
        String path = "E:\\alevel\\src\\dbConsole\\src\\files\\";
        tableNames =  fileUtils.readDirectory(path);
        for(int i = 0; i < tableNames.size(); i++){
            intoFile = fileUtils.readCSV(path+tableNames.get(i).toString() + ".csv");
            line = fileUtils.parseLine(intoFile);
            sqlUtils.executeQueryCreateTable(sqlUtils.createQuery(tableNames.get(i).toString(), line));
            line.clear();
        }
        int length = fileUtils.readKeysFile("E:\\alevel\\src\\dbConsole\\src\\files\\index.txt").size();
        for(int i =0; i < length; i++){
            int count = i;
            String key = fileUtils.key(fileUtils.readKeysFile("E:\\alevel\\src\\dbConsole\\src\\files\\index.txt"), count);
            sqlUtils.addKeysForTable(key);
        }
        for(int i = 0; i < tableNames.size(); i++){
            intoFile = fileUtils.readCSV(path+tableNames.get(i).toString() + ".csv");
            line = fileUtils.parseLine(intoFile);
            values = fileUtils.readCSV(path+tableNames.get(i).toString() + ".csv");
            count = 1;
            for(int j = 1; j < values.size() ; j++){
                valuesLine = fileUtils.parseLineValues(intoFile, count);
                count++;
                sqlUtils.insertValuesInTable(tableNames.get(i).toString(), line, valuesLine);
            }
        }
        sqlUtils.selectFromTable();
    }
}
