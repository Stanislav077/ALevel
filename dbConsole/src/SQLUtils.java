import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Ivan Isaev on 04.04.2018.
 */
public class SQLUtils {

    public static void executeQueryCreateTable(String table, ArrayList<String> line){
        String query = "create table ".concat(table);
        query = query + " (" +
                "%s VARCHAR(11) NOT NULL AUTO_INCREMENT,\n" +
                "%s date VARCHAR(11) DEFAULT NULL,\n" +
                "%s user_id VARCHAR(11) DEFAULT NULL,\n" +
                "%s status_id VARCHAR(11) DEFAULT NULL,\n" +
                "%s status_id VARCHAR(11) DEFAULT NULL,\n" +
                "%s status_id VARCHAR(11) DEFAULT NULL,\n" +
                "PRIMARY KEY (%s)" +
                ")";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees",
                "root", "root");
             Statement statement = connection.createStatement();
             ){
            statement.executeUpdate(query);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
