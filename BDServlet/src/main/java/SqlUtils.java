import java.sql.*;

public class SqlUtils {
    public static void insertIntoBd(String name, String email, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String query = "INSERT INTO bdservlet.user (name, email, password) \n" +
                "  VALUES ('" + name + "', '" + email + "', '" + password + "');";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdservlet",
                "root", "root");
             Statement statement = connection.createStatement();
        ) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int getMaxId() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String query = "SELECT max(id) from bdservlet.user";
        int id = 0;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdservlet",
                "root", "root");
             Statement statement = connection.createStatement();
             ResultSet resultset = statement.executeQuery(query)) {


            while (resultset.next()) {
                id = resultset.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public static String getById(int id, int count) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String query = "SELECT name, email from bdservlet.user\n" +
                "where id = " + id + ";";
        String result = "";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdservlet",
                "root", "root");
             Statement statement = connection.createStatement();
             ResultSet resultset = statement.executeQuery(query)) {
            while (resultset.next()) {
                result = resultset.getString(count);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
