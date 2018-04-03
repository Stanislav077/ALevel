import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Ivan Isaev on 31.03.2018.
 */
public class DBWorker {

    static ArrayList<Employees> arrayListQuery1 = new ArrayList();
    static ArrayList<Employees> arrayListQuery2 = new ArrayList();
    static ArrayList<Employees> arrayListQuery3 = new ArrayList();

    public static void main(String[] args) {
        query1();
        query2();
        query3();
    }

    public static void query1(){
        String query = "select employees.first_name, employees.last_name, employees.hire_date from employees.employees LIMIT 200;";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees",
                "root", "root");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)){

            while(resultSet.next()){
                arrayListQuery1.add(new Employees(resultSet.getString(1), resultSet.getString(2),
                        resultSet.getDate(3)));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void query2(){
        String query = "select em.first_name, em.last_name, sal.salary\n" +
                "from employees.employees em \n" +
                "inner join employees.salaries sal on (em.emp_no=sal.emp_no) \n" +
                "where sal.to_date like ? LIMIT 100;";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees",
                    "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1, "2000%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                arrayListQuery2.add(new Employees(resultSet.getString(1), resultSet.getString(2),
                        resultSet.getInt(3)));
            }
            resultSet.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void query3(){
        String query = "select employees.first_name\n" +
                "from employees.employees\n" +
                "where employees.last_name like ? ; ";
        try (
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees",
                    "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, "K%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                arrayListQuery3.add(new Employees(resultSet.getString(1)));
            }
            resultSet.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
