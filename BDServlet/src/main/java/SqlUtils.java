import java.sql.*;

public class SqlUtils {
    public static void insertIntoBd(String name, String email, String password){
        String query = "INSERT INTO bdservlet.user (name, email, password) \n" +
                "  VALUES ('" + name + "', '" + email + "', '" + password + "');";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdservlet",
                "root", "root");
             Statement statement = connection.createStatement();
        ){
            statement.executeUpdate(query);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static int getMaxId(){
        String query = "SELECT max(id) from bdservlet.user";
        int id = 0;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdservlet",
                "root", "root");
             Statement statement = connection.createStatement();
             ResultSet resultset  = statement.executeQuery(query)){


            while (resultset.next()){
                id = resultset.getInt(1);
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return id;
    }
}
