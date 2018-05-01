import org.json.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SqlUtils {
    public static final String NAME_COL = "col";
    static int count = 0;

    public static void createTable(String nameTable, int col) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String nameCol = "";
        String typeCol = " VARCHAR (255)";
        for (int i = 0; i <= col; i++) {
            if(i == 0){
                nameCol += "row int(11) NOT NULL AUTO_INCREMENT, ";
            }
            else if (i == col) {
                nameCol += NAME_COL + i + " " + typeCol + ", PRIMARY KEY (row));";
            } else {
                nameCol += NAME_COL + i + " " + typeCol + ",";
            }

            String query = "CREATE TABLE " + nameTable + " (" + nameCol;
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/excel",
                    "root", "root");
                 Statement statement = connection.createStatement();
            ) {
                statement.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void insertDataByRow(String nametable, int rowId, String data) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        int length = data.split(",").length;
        String query = "INSERT INTO " + nametable;
        for (int i = 0; i <= length; i++) {
            if (i == length) {
                query += "'" + parseData(data) + "');";
            } else if (i == 0) {
                for (int j = 0; j <= length; j++) {
                    if(j == 0){
                        query += "(row, ";
                    } else if(j == 1){
                        query += NAME_COL + j + ",";
                    } else if (j == length) {
                        query += NAME_COL + j + ") VALUES (" + rowId + ",";
                    } else {
                        query += NAME_COL + j + ",";
                    }
                }
            } else {
                query += "'" + parseData(data) + "',";
            }
        }
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/excel",
                "root", "root");
             Statement statement = connection.createStatement();
        ) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            count = 0;
        }
    }

    public static void insertDataWithoutRow(String nametable, String data) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(data);
        int length = data.split(",").length;
        String query = "INSERT INTO " + nametable;
        for (int i = 0; i <= length; i++) {
            if (i == length) {
                query += "'" + parseData(data) + "');";
            } else if (i == 0) {
                for (int j = 0; j <= length; j++) {
                    if(j == 0){
                        query += "(";
                    } else if(j == 1){
                        query += NAME_COL + j + ",";
                    } else if (j == length) {
                        query += NAME_COL + j + ") VALUES (";
                    } else {
                        query += NAME_COL + j + ",";
                    }
                }
            } else {
                query += "'" + parseData(data) + "',";
            }
        }
        System.out.println(query);
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/excel",
                "root", "root");
             Statement statement = connection.createStatement();
        ) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            count = 0;
        }
    }

    public static void dropTable(String nametable){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String query = "DROP TABLE " + nametable;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/excel",
                "root", "root");
             Statement statement = connection.createStatement();
        ) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteRow(String nametable, int row){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String query = "DELETE FROM " + nametable + " WHERE row = " + row + ";";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/excel",
                "root", "root");
             Statement statement = connection.createStatement();
        ) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*public static String[] getTable(String nametable){
        String[] arr = {};
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String query = "SELECT * FROM " + nametable + ";";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/excel",
                "root", "root");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            int columns = resultSet.getMetaData().getColumnCount();
            ArrayList<String> nameColumn = new ArrayList<>();
            ArrayList<String> data = new ArrayList<>();
            while (resultSet.next()){
                for(int i = 1; i <= columns; i++) {
                    if (i == 1) {
                        nameColumn.add("row");
                        data.add(resultSet.getString(i));
                    } else {
                        nameColumn.add("col" + (i-1));
                        data.add(resultSet.getString(i));
                    }
                }
            }
            arr = new String[nameColumn.size()];
            for(int i = 0; i < nameColumn.size(); i++){
                arr[i] = nameColumn.get(i) + " " + data.get(i);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arr;
    }*/

    public static ArrayList<JSONObject> getJson(String nametable){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<JSONObject> resList = new ArrayList<>();
        ArrayList<String> nameColumns = new ArrayList<>();
        String query = "SELECT * FROM " + nametable + ";";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/excel",
                "root", "root");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            int columns = resultSet.getMetaData().getColumnCount();
            for(int i = 1; i <= columns; i++){
                nameColumns.add(resultSet.getMetaData().getColumnName(i));
            }
            while (resultSet.next()){
                JSONObject jsonObject = new JSONObject();
                for(int j = 1; j <= columns; j++){
                    String key = nameColumns.get(j-1);
                    String value = resultSet.getString(j);
                    jsonObject.put(key, value);
                    System.out.println(key);
                    System.out.println(value);
                }
                resList.add(jsonObject);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return resList;

    }

    public static String parseData(String data){
        String temp = "";
        for(int i = count; i < data.split(",").length; i++){
            temp = data.split(",")[count];
            count++;
            break;
        }
        return temp;
    }
}
