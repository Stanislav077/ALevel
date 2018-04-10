import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Ivan Isaev on 04.04.2018.
 */
public class SQLUtils {

    static FileUtils fileUtils = new FileUtils();

    public static void executeQueryCreateTable(String query){
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees",
                "root", "root");
             Statement statement = connection.createStatement();
             ){
            statement.executeUpdate(query);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    static String createQuery(String table, ArrayList<String> nameColumn){
        String query = "create table employees.".concat(table) + "\n";
        String constQuery = " VARCHAR(55) DEFAULT NULL, \n";
        for(int i = 0; i < nameColumn.size(); i++){
            if(i == 0){
                query += "(" + nameColumn.get(i) + " INT(11) NOT NULL, \n";
                continue;
            }
            if(i == nameColumn.size()-1){
                query += nameColumn.get(i) + constQuery;
                query += "PRIMARY KEY (" + nameColumn.get(0) + "))";
                break;
            }
            query += nameColumn.get(i) + constQuery;
        }
        return query;
    }

    static void addKeysForTable(String key){
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees",
                "root", "root");
             Statement statement = connection.createStatement();
        ){
            statement.executeUpdate(key);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    static void insertValuesInTable(String table, ArrayList<String> nameColumn, ArrayList<String> values){
        String nameColumnString = "";
        String valuesString = "";
        for(int i = 0; i < nameColumn.size(); i++){
            if(i == nameColumn.size() - 1){
                nameColumnString += nameColumn.get(i).toString();
                continue;
            }
            nameColumnString += nameColumn.get(i).toString() + ", ";
        }
        String query = "INSERT INTO ".concat(table) + "( " + nameColumnString + ")\n";
        for(int i = 0; i < values.size(); i++){
            if( i == 0){
                valuesString += values.get(i).toString().replace("\"", "") + ",";
                continue;
            }
            if(i == values.size()-1){
                valuesString += "'" + values.get(i).toString().replace("\"", "") + "'";
                continue;
            }
            valuesString += "'" + values.get(i).toString() + "',";
        }
        String queryValues = "VALUES (" + valuesString + ");";
        query += queryValues;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees",
                "root", "root");
             Statement statement = connection.createStatement();
        ){
            statement.executeUpdate(query);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void selectFromTable(){
        ArrayList<String> select;
        select = (fileUtils.readCSV("E:\\alevel\\src\\dbConsole\\src\\files\\select.sql"));
        String query = select.get(0);
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees",
                "root", "root");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)){
            int columns = resultSet.getMetaData().getColumnCount();
            while(resultSet.next()){
                for(int i = 1; i <= columns; i++){
                    System.out.print(resultSet.getString(i) + " ");
                }
                System.out.println();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}