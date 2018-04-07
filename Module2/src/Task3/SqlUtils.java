package Task3;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Ivan Isaev on 07.04.2018.
 */
public class SqlUtils {

    static FileUtils fileUtils = new  FileUtils();

    public static void executeQueryCreateTable(String query){
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/geo",
                "root", "root");
             Statement statement = connection.createStatement();
        ){
            statement.executeUpdate(query);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    static String createQuery(String table, ArrayList<String> nameColumn){
        String query = "create table geo.".concat(table) + "\n";
        String constQuery = " VARCHAR(255) DEFAULT NULL, \n";
        for(int i = 0; i < nameColumn.size(); i++){
            if(i == 0){
                query += "(" + nameColumn.get(i) + " VARCHAR(255) NOT NULL, \n";
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
            if(i == values.size()-1){
                valuesString += "'" + values.get(i).toString() + "'";
                continue;
            }
            valuesString += "'" + values.get(i).toString() + "',";
        }
        String queryValues = "VALUES (" + valuesString + ");";
        query += queryValues;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/geo",
                "root", "root");
             Statement statement = connection.createStatement();
        ){
            statement.executeUpdate(query);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void executeDropTable(String table){
        String query = "DROP TABLE ".concat(table);
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/geo",
                "root", "root");
             Statement statement = connection.createStatement();
        ){
            statement.executeUpdate(query);
        } catch (SQLException e){
            System.out.println("Bazy net");
        }
    }

    public static void selectFromTable(){
        ArrayList<String> select;
        ArrayList<School> resultQuery = new ArrayList<>();
        select = (fileUtils.readCSV("E:\\Module2\\src\\Task3\\files\\select.sql"));
        String query = select.get(0);
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees",
                "root", "root");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)){
            while(resultSet.next()){
                resultQuery.add(new School(resultSet.getString(1), resultSet.getString(2),
                        resultSet.getString(3)));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        for(School ar: resultQuery){
            System.out.println(ar);
        }
    }
}
