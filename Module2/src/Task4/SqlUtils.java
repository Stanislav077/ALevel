package Task4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Ivan Isaev on 13.04.2018.
 */
public class SqlUtils {
    public static void executeDropTable(){
        String query1 = "DROP TABLE action";
        String query2 = "DROP TABLE comments";
        String query3 = "DROP TABLE user";
        String query4 = "DROP TABLE photo";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialnetwork",
                "root", "root");
             Statement statement = connection.createStatement();
        ){
            statement.executeUpdate(query4);
            statement.executeUpdate(query1);
            statement.executeUpdate(query2);
            statement.executeUpdate(query3);
        } catch (SQLException e){
            System.out.println("Table net");
        }
    }
}
