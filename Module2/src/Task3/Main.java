package Task3;


import com.mysql.jdbc.exceptions.MySQLSyntaxErrorException;

import java.util.ArrayList;

/**
 * Created by Ivan Isaev on 07.04.2018.
 */
public class Main {
    static FileUtils fileUtils = new FileUtils();
    static SqlUtils sqlUtils = new SqlUtils();
    static ArrayList<String> tableNames = new ArrayList<>();
    static ArrayList<String> intoFile = new ArrayList<>();
    static ArrayList<String> line = new ArrayList<>();
    static ArrayList<String> values = new ArrayList<>();
    static ArrayList<String> valuesLine = new ArrayList<>();
    static int count = 1;

    public static void main(String[] args) {
        String path = "E:\\Module2\\src\\Task3\\files\\";
        tableNames =  fileUtils.readDirectory(path);
        for(int i = 0; i < tableNames.size(); i++){
            intoFile = fileUtils.readCSV(path+tableNames.get(i).toString() + ".csv");
            line = fileUtils.parseLine(intoFile);
            sqlUtils.executeDropTable(tableNames.get(i).toString());

            sqlUtils.executeQueryCreateTable(sqlUtils.createQuery(tableNames.get(i).toString(), line));
            line.clear();
        }
        tableNames =  fileUtils.readDirectory(path);
        for(int i = 0; i < tableNames.size(); i++){
            intoFile = fileUtils.readCSV(path+tableNames.get(i).toString() + ".csv");
            line = fileUtils.parseLine(intoFile);
            values = fileUtils.readCSV(path+tableNames.get(i).toString() + ".csv");
            for(int j = 1; j < values.size() ; j++){
                valuesLine = fileUtils.parseLineValues(intoFile, count);
                count++;
                sqlUtils.insertValuesInTable(tableNames.get(i).toString(), line, valuesLine);
            }
        }
        sqlUtils.selectFromTable();
    }
}
