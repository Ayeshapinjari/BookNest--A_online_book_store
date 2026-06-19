package Projects.OnlineBookStore.Functions;

import Projects.OnlineBookStore.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class AdminDAO {

    Scanner sc = new Scanner(System.in);

    public boolean loginAdmin() {

        try {

            Connection con = DBConnection.getConnection();

            System.out.print("Enter Admin Email : ");
            String email = sc.nextLine();

            System.out.print("Enter Admin Password : ");
            String password = sc.nextLine();

            String query =
                    "SELECT * FROM admins WHERE email=? AND password=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("\n=================================");
                System.out.println("Admin Login Successful");
                System.out.println("Welcome " + rs.getString("name"));
                System.out.println("=================================");

                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Invalid Admin Credentials");
        return false;
    }
}