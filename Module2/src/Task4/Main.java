package Task4;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Ivan Isaev on 12.04.2018.
 */
public class Main {
    static SqlUtils sqlUtils = new SqlUtils();
    static ArrayList<Account> listAccount = new ArrayList<>();
    static ArrayList<Photo> listPhoto = new ArrayList<>();
    static ArrayList<Comment> listComment = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        sqlUtils.executeDropTable();
        while (true){
            System.out.println("Menu:\n" +
                "1. Add user\n" +
                "2. Add photo by user\n" +
                "3. Add comment to photo\n" +
                "4. Add like\n" +
                "5. See like\n" +
                "6. Delete like comment\n" +
                "7. Delete like photo\n" +
                "8. Delete like user\n" +
                "9. Exit");
            switch (sc.nextInt()){
                case 1:
                    System.out.print("Enter a name please:> ");
                    addUser(sc.next());
                    break;
                case 2:
                    addPhoto(listAccount);
                    break;
                case 3:
                    addComment();
                    break;
                case 4:
                    addLike();
                    break;
                case 5:
                    seeAllLike();
                    break;
                case 6:
                    deleteLikeComment();
                    break;
                case 7:
                    deleteLikePhoto();
                    break;
                case 8:
                    deleteLikeUser();
                    break;
                case 9:
                    System.exit(0);
            }
        }
    }

    public static void addUser(String name){
        String query = "INSERT INTO socialnetwork.user (name)\n" +
                "VALUES ('" + name + "');";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialnetwork",
                "root", "root");
             Statement statement = connection.createStatement();
        ){
            statement.executeUpdate(query);
            listAccount.add(new Account(name));
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void addComment(){
        int count = 1;
        for(Account ar: listAccount){
            System.out.println((count) + ". " + ar.toString());
            count++;
        }
        System.out.print("Choose user:> ");
        int userId = sc.nextInt() - 1;
        int countPhoto = 1;
        for (Photo ar: listPhoto){
            System.out.println((countPhoto) + ". " + ar.toString());
            countPhoto++;
        }
        int namePhoto = sc.nextInt();
        System.out.println("Enter a comment: ");
        String comment = sc.next();
        String query = "INSERT INTO socialnetwork.comments (data_comment, author_id, photo_id)\n" +
                "VALUES ('" + comment + "', " + (userId+1) + ", " + (namePhoto) + ");";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialnetwork",
                "root", "root");
             Statement statement = connection.createStatement();
        ){
            statement.executeUpdate(query);
            listComment.add(new Comment((listAccount.get(userId).toString()), listPhoto.get(namePhoto-1).toString()));
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void addPhoto(ArrayList<Account> listAccount){
        int count = 1;
        for(Account ar: listAccount){
            System.out.println((count) + ". " + ar.toString());
            count++;
        }
        System.out.print("Choose user:> ");
        int userId = sc.nextInt() - 1;
        System.out.println("Enter a name photo (name must be one word): ");
        String namePhoto = sc.next();
        String query = "INSERT INTO socialnetwork.photo (name_id, author_id)\n" +
                "VALUES ('" + namePhoto + "', " + (userId+1) + ");";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialnetwork",
                "root", "root");
             Statement statement = connection.createStatement();
        ){
            statement.executeUpdate(query);
            listPhoto.add(new Photo(listAccount.get(userId).toString(), namePhoto));
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void addLike(){
        while(true){
            System.out.println("1. Like photo\n" +
                    "2. Like comment\n" +
                    "3. Like user\n");
            switch (sc.nextInt()){
                case 1:
                    int countUser1 = 1;
                    for(Account ar: listAccount){
                        System.out.println((countUser1) + ". " + ar.toString());
                        countUser1++;
                    }
                    System.out.println("Choose user: ");
                    int userID = sc.nextInt() - 1;
                    int countPhoto = 1;
                    for(Photo ar: listPhoto){
                        System.out.println((countPhoto) + ". " + ar.toString());
                        countPhoto++;
                    }
                    System.out.println("Choose photo:> ");
                    int photoIDlike = sc.nextInt();
                    String queryPho = "SELECT IF(assigned = 1, 1,0), if(status_id = 1, 1,0), if(author_id =" + (userID+1) +", 1,0), if(assigned_id =" + (photoIDlike+1) + ", 1,0) from socialnetwork.action";
                    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialnetwork",
                            "root", "root");
                         Statement statement = connection.createStatement();
                         ResultSet resultSet = statement.executeQuery(queryPho)){
                        if(!resultSet.next()){
                            System.out.println("Like....");
                            String queryPhoto = "INSERT INTO socialnetwork.action (assigned, status_id, author_id, assigned_id)\n" +
                                    "VALUES (1, 1," + (userID+1) + ", " + (photoIDlike) + ");";
                            try (Connection connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialnetwork",
                                    "root", "root");
                                 Statement statement1 = connection1.createStatement();
                            ){
                                statement1.executeUpdate(queryPhoto);
                            } catch (SQLException e){
                                e.printStackTrace();
                            }
                        } else if(resultSet.next()){
                            System.out.println("Like already take!");
                            return;
                        }
                    } catch (SQLException e){
                        e.printStackTrace();
                    }
                    return;
                case 2:
                    int countuser = 1;
                    for(Account ar: listAccount){
                        System.out.println((countuser) + ". " + ar.toString());
                        countuser++;
                    }
                    System.out.println("Choose user:> ");
                    int userid = sc.nextInt()-1;
                    int countComments = 1;
                    for(Comment ar: listComment){
                        System.out.println((countComments) + ". " + ar.toString());
                        countComments++;
                    }
                    int userComment = sc.nextInt()-1;
                    String queryCom = "SELECT IF(assigned = 2, 1,0), if(status_id = 1, 1,0), if(author_id =" + (userid+1) +", 1,0), if(assigned_id =" + (userComment+1) + ", 1,0) from socialnetwork.action";
                    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialnetwork",
                            "root", "root");
                         Statement statement = connection.createStatement();
                         ResultSet resultSet = statement.executeQuery(queryCom)){
                        if(!resultSet.next()){
                            System.out.println("Like....");
                            String queryComments = "INSERT INTO socialnetwork.action (assigned, status_id, author_id, assigned_id)\n" +
                                    "VALUES ( 2, 1, " + (userid+1) + ", " + (userComment+1) + ");";
                            try (Connection connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialnetwork",
                                    "root", "root");
                                 Statement statement1 = connection1.createStatement();
                            ){
                                statement1.executeUpdate(queryComments);
                            } catch (SQLException e){
                                e.printStackTrace();
                            }
                        } else if(resultSet.next()){
                            System.out.println("Like already take!");
                            return;
                        }
                    } catch (SQLException e){
                        e.printStackTrace();
                    }
                    return;
                case 3:
                    int countUser = 1;
                    for(Account ar: listAccount){
                        System.out.println((countUser) + ". " + ar.toString());
                        countUser++;
                    }
                    System.out.print("Choose user:> ");
                    int userId = sc.nextInt() - 1;
                    System.out.println("Choose user add like:> ");
                    int userIdLike = sc.nextInt() - 1;
                    String queryUs = "SELECT IF(assigned = 3, 1,0), if(status_id = 1, 1,0), if(author_id =" + (userId+1) +", 1,0), if(assigned_id =" + (userIdLike+1) + ", 1,0) from socialnetwork.action";
                    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialnetwork",
                            "root", "root");
                         Statement statement = connection.createStatement();
                         ResultSet resultSet = statement.executeQuery(queryUs)){
                        if(!resultSet.next()){
                            String queryUser = "INSERT INTO socialnetwork.action (assigned, status_id, author_id, assigned_id)\n" +
                                    "VALUES ( 3, 1, " + (userId+1) + ", " + (userIdLike+1) + ");";
                            try (Connection connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialnetwork",
                                    "root", "root");
                                 Statement statement1 = connection1.createStatement();
                            ){
                                statement1.executeUpdate(queryUser);
                            } catch (SQLException e){
                                e.printStackTrace();
                            }
                        }  else if(resultSet.next()){
                            System.out.println("Like already take!");
                            return;
                        }
                    } catch (SQLException e){
                        e.printStackTrace();
                    }
                    return;
            }
        }
    }

    public static void seeAllLike(){
        while (true){
            System.out.println("1. See Photo like\n" +
                    "2. See Comments like\n" +
                    "3. See User like");
            switch (sc.nextInt()){
                case 1:
                    String query = "SELECT\n" +
                            "  u.name,\n" +
                            "  p.name_id,\n" +
                            "  up.name\n" +
                            "FROM socialnetwork.action a\n" +
                            "  INNER join socialnetwork.user u on (u.id = a.author_id)\n" +
                            "  INNER join socialnetwork.photo p on (a.assigned = p.id)\n" +
                            "  INNER JOIN socialnetwork.user up on (up.id = a.assigned_id)\n" +
                            "   WHERE status_id = 1";
                    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees",
                            "root", "root");
                         Statement statement = connection.createStatement();
                         ResultSet resultSet = statement.executeQuery(query)){
                        while(resultSet.next()){
                            System.out.println("Author name: " + resultSet.getString(1) + ": namephoto: " + resultSet.getString(2) +  " by photo: " + resultSet.getString(3));
                        }
                    } catch (SQLException e){
                        e.printStackTrace();
                    }
                    return;
                case 2:
                    String query1 = "SELECT\n" +
                            "u.name,\n" +
                            "c.data_comment,\n" +
                            "up.name\n" +
                            "FROM socialnetwork.action a\n" +
                            "  INNER join socialnetwork.user u on (u.id = a.author_id)\n" +
                            "  INNER join socialnetwork.comments c on (a.assigned_id = c.id)\n" +
                            "  INNER join socialnetwork.user up on (up.id = c.author_id)\n" +
                            "  WHERE a.status_id = 1";
                    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees",
                            "root", "root");
                         Statement statement = connection.createStatement();
                         ResultSet resultSet = statement.executeQuery(query1)){
                        while(resultSet.next()){
                            System.out.println("Author name: " + resultSet.getString(1) + ": namephoto: " + resultSet.getString(2) +  " by photo: " + resultSet.getString(3));
                        }
                    } catch (SQLException e){
                        e.printStackTrace();
                    }
                    return;
                case 3:
                    String query2 = "SELECT\n" +
                            " u.name,\n" +
                            " uu.name\n" +
                            "FROM socialnetwork.action a\n" +
                            "  INNER join user u on (u.id = a.author_id)\n" +
                            "  INNER join user uu on (uu.id = a.assigned_id)\n" +
                            "  WHERE a.status_id = 1";
                    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialnetwork",
                            "root", "root");
                         Statement statement = connection.createStatement();
                         ResultSet resultSet = statement.executeQuery(query2)){
                        while(resultSet.next()){
                            System.out.println("Author name: " + resultSet.getString(1) + ": nameUser: " + resultSet.getString(2));
                        }
                    } catch (SQLException e){
                        e.printStackTrace();
                    }
                    return;
            }
        }
    }

    public static void deleteLikeComment(){
        String query1 = "SELECT\n" +
                "a.id,\n"+
                "u.name,\n" +
                "c.data_comment,\n" +
                "up.name\n" +
                "FROM socialnetwork.action a\n" +
                "  INNER join socialnetwork.user u on (u.id = a.author_id)\n" +
                "  INNER join socialnetwork.comments c on (a.assigned_id = c.id)\n" +
                "  INNER join socialnetwork.user up on (up.id = c.author_id)\n" +
                "  WHERE a.status_id = 1";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialnetwork",
                "root", "root");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query1)){
            while(resultSet.next()){
                System.out.println(resultSet.getInt(1) + ". Author name: " + resultSet.getString(2) + ": namephoto: " + resultSet.getString(3) +  " by photo: " + resultSet.getString(4));
            }
            int row = sc.nextInt();
            String query2 = "UPDATE socialnetwork.action \n" +
                    "  SET status_id = 0\n" +
                    "  WHERE id = " + row;
            statement.executeUpdate(query2);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void deleteLikePhoto(){
        String query = "SELECT\n" +
                "  a.id,\n" +
                "  u.name,\n" +
                "  p.name_id,\n" +
                "  up.name\n" +
                "FROM socialnetwork.action a\n" +
                "  INNER join socialnetwork.user u on (u.id = a.author_id)\n" +
                "  INNER join socialnetwork.photo p on (a.assigned = p.id)\n" +
                "  INNER JOIN socialnetwork.user up on (up.id = a.assigned_id)\n" +
                "   WHERE status_id = 1";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialnetwork",
                "root", "root");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)){
            while(resultSet.next()){
                System.out.println(resultSet.getInt(1) + ". Author name: " + resultSet.getString(2) + ": namephoto: " + resultSet.getString(3) +  " by photo: " + resultSet.getString(4));
            }
            int row = sc.nextInt();
            String query2 = "UPDATE socialnetwork.action \n" +
                    "  SET status_id = 0\n" +
                    "  WHERE id = " + row;
            statement.executeUpdate(query2);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void deleteLikeUser(){
        String query = "SELECT\n" +
                " a.id\n," +
                " u.name,\n" +
                " uu.name\n" +
                "FROM socialnetwork.action a\n" +
                "  INNER join user u on (u.id = a.author_id)\n" +
                "  INNER join user uu on (uu.id = a.assigned_id)\n" +
                "  WHERE a.status_id = 1";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialnetwork",
                "root", "root");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)){
            while(resultSet.next()){
                System.out.println(resultSet.getInt(1) + ". Author name: " + resultSet.getString(2) + ": namephoto: " + resultSet.getString(3) +  " by photo: " + resultSet.getString(4));
            }
            int row = sc.nextInt();
            String query2 = "UPDATE socialnetwork.action \n" +
                    "  SET status_id = 0\n" +
                    "  WHERE id = " + row;
            statement.executeUpdate(query2);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}