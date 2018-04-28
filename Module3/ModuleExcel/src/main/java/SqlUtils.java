import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlUtils {
    public static final String NAME_COL = "row";
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
                nameCol += "id int(11) NOT NULL AUTO_INCREMENT, ";
            }
            else if (i == col) {
                nameCol += NAME_COL + i + " " + typeCol + ", PRIMARY KEY (id));";
            } else {
                nameCol += NAME_COL + i + " " + typeCol + ",";
            }

            String query = "CREATE TABLE " + nameTable + " (" + nameCol;
            System.out.println(query);
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

    public static void insertData(String nametable, int rowId, String data){
        int length = data.split(",").length;
        String query = "INSERT INTO " + nametable;
        for(int i = 1; i <= length; i++){
            if(i == length){
               query += parseData(data) + ", " + ")\nWHERE id = " + rowId + ";\n";
            } else if(i == 1){
                for(int j = 1; j <= length; i++){
                    query += "(" + NAME_COL + j + ",";
                    if(j == length){
                        query += NAME_COL + j + ") VALUES (";
                    }
                }
            } else {
                query += parseData(data) + ",";
            }
        }
        System.out.println(query);
    }

    public static String parseData(String data){
        while (true){
            String temp = data.split(",")[count];
            count++;
            return temp;
        }
    }
}
