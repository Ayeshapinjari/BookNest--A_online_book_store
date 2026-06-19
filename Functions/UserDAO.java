package Projects.OnlineBookStore.Functions;
import Projects.OnlineBookStore.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UserDAO {
    public static String currentUser;
    Scanner sc = new Scanner(System.in);

    public void registerUser() {

        try {

            Connection con = DBConnection.getConnection();

            System.out.print("Enter Name : ");
            String name = sc.nextLine();

            System.out.print("Enter Email : ");
            String email = sc.nextLine();

            System.out.print("Enter Password : ");
            String password = sc.nextLine();

            String role = "USER";

            String query =
                    "INSERT INTO users(name,email,password,role) VALUES(?,?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4, role);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Registration Successful");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean loginUser() {

        try {

            Connection con = DBConnection.getConnection();

            System.out.print("Enter Email : ");
            String email = sc.nextLine();

            System.out.print("Enter Password : ");
            String password = sc.nextLine();

            String query =
                    "SELECT * FROM users WHERE email=? AND password=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1, email);
            ps.setString(2, password);

            var rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("\nLogin Successful");
                System.out.println("Welcome " + rs.getString("name"));
                currentUser = rs.getString("name");
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Invalid Credentials");
        return false;
    }
}