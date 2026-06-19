package Projects.OnlineBookStore.Functions;

import Projects.OnlineBookStore.BookNest;
import Projects.OnlineBookStore.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BookDAO implements BookOperations {

    @Override
    public void addBook() {

        try {

            Connection con = DBConnection.getConnection();

            String title;

            while (true) {

                System.out.print("Enter Book Title : ");
                title = BookNest.sc.nextLine().trim();

                if (!title.isEmpty()) {
                    break;
                }

                System.out.println("Book Title Cannot Be Empty!");
            }

            double price;

            while (true) {

                System.out.print("Enter Price : ");

                try {

                    price = Double.parseDouble(
                            BookNest.sc.nextLine());

                    if (price > 0) {
                        break;
                    }

                    System.out.println(
                            "Price Must Be Greater Than 0");

                } catch (Exception e) {

                    System.out.println(
                            "Enter Valid Price");
                }
            }

            int quantity;

            while (true) {

                System.out.print("Enter Quantity : ");

                try {

                    quantity = Integer.parseInt(
                            BookNest.sc.nextLine());

                    if (quantity > 0) {
                        break;
                    }

                    System.out.println(
                            "Quantity Must Be Greater Than 0");

                } catch (Exception e) {

                    System.out.println(
                            "Enter Valid Quantity");
                }
            }

            String query =
                    "INSERT INTO books(title,price,quantity) VALUES(?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1, title);
            ps.setDouble(2, price);
            ps.setInt(3, quantity);

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println(
                        "Book Added Successfully");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @Override
    public void viewBooks() {

        try {

            Connection con = DBConnection.getConnection();

            String query =
                    "SELECT * FROM books WHERE quantity > 0";

            PreparedStatement ps =
                    con.prepareStatement(query);

            var rs = ps.executeQuery();

            System.out.println("\n==========================================================");
            System.out.printf("%-5s %-25s %-10s %-10s%n",
                    "ID", "TITLE", "PRICE", "QTY");
            System.out.println("==========================================================");

            while (rs.next()) {

                System.out.printf("%-5d %-25s %-10.2f %-10d%n",
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getDouble("price"),
                        rs.getInt("quantity"));
            }

            System.out.println("==========================================================");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateQuantity() {

        try {

            Connection con = DBConnection.getConnection();

            System.out.print("Enter Book ID : ");
            int id =
                    Integer.parseInt(BookNest.sc.nextLine());

            System.out.print("Enter New Quantity : ");
            int quantity =
                    Integer.parseInt(BookNest.sc.nextLine());

            String query =
                    "UPDATE books SET quantity=? WHERE id=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, quantity);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Quantity Updated Successfully");
            } else {
                System.out.println("Book ID Not Found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBook() {

        try {

            Connection con = DBConnection.getConnection();

            System.out.print("Enter Book ID : ");
            int id =
                    Integer.parseInt(BookNest.sc.nextLine());

            String query =
                    "DELETE FROM books WHERE id=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Book Deleted Successfully");
            } else {
                System.out.println("Book ID Not Found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}