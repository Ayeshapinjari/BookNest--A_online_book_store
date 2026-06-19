package Projects.OnlineBookStore.Functions;

import Projects.OnlineBookStore.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class OrderDAO {

    Scanner sc = new Scanner(System.in);

    public void buyBook() {

        try {

            Connection con = DBConnection.getConnection();

            StringBuilder bill = new StringBuilder();

            double grandTotal = 0;

            bill.append("\n============================================\n");
            bill.append("               BOOKNEST BILL\n");
            bill.append("============================================\n");
            bill.append("Customer : ")
                    .append(UserDAO.currentUser)
                    .append("\n\n");

            bill.append(String.format("%-20s %-10s %-10s\n",
                    "BOOK", "QTY", "TOTAL"));

            bill.append("--------------------------------------------\n");

            while (true) {

                System.out.print("Enter Book ID : ");
                int bookId = sc.nextInt();

                System.out.print("Enter Quantity : ");
                int quantity = sc.nextInt();

                String selectBook =
                        "SELECT * FROM books WHERE id=? AND quantity>0";

                PreparedStatement ps1 =
                        con.prepareStatement(selectBook);

                ps1.setInt(1, bookId);

                ResultSet rs = ps1.executeQuery();

                if (!rs.next()) {

                    System.out.println("Book Not Found");
                    continue;
                }

                String bookName =
                        rs.getString("title");

                double price =
                        rs.getDouble("price");

                int availableQty =
                        rs.getInt("quantity");

                if (quantity > availableQty) {

                    System.out.println("Insufficient Stock");
                    continue;
                }

                double total = quantity * price;

                grandTotal += total;

                String insertOrder =
                        "INSERT INTO orders(user_name,book_name,quantity,total) VALUES(?,?,?,?)";

                PreparedStatement ps2 =
                        con.prepareStatement(insertOrder);

                ps2.setString(1, UserDAO.currentUser);
                ps2.setString(2, bookName);
                ps2.setInt(3, quantity);
                ps2.setDouble(4, total);

                ps2.executeUpdate();

                String updateBook =
                        "UPDATE books SET quantity=? WHERE id=?";

                PreparedStatement ps3 =
                        con.prepareStatement(updateBook);

                ps3.setInt(1, availableQty - quantity);
                ps3.setInt(2, bookId);

                ps3.executeUpdate();

                bill.append(
                        String.format(
                                "%-20s %-10d %-10.2f\n",
                                bookName,
                                quantity,
                                total
                        )
                );

                System.out.println("\n1. Add More Books");
                System.out.println("2. Generate Bill");

                int option = sc.nextInt();

                if (option == 2) {
                    break;
                }
            }

            bill.append("--------------------------------------------\n");
            bill.append(String.format(
                    "Grand Total : ₹%.2f\n",
                    grandTotal
            ));
            bill.append("============================================\n");
            bill.append("Thank You For Shopping With BookNest\n");
            bill.append("============================================\n");

            System.out.println(bill);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
    public void viewSalesHistory() {

        try {

            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM orders";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n==============================================================");
            System.out.printf("%-5s %-15s %-25s %-10s %-10s%n",
                    "ID",
                    "USER",
                    "BOOK",
                    "QTY",
                    "TOTAL");
            System.out.println("==============================================================");

            while (rs.next()) {

                System.out.printf("%-5d %-15s %-25s %-10d %-10.2f%n",
                        rs.getInt("id"),
                        rs.getString("user_name"),
                        rs.getString("book_name"),
                        rs.getInt("quantity"),
                        rs.getDouble("total"));
            }

            System.out.println("==============================================================");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
    }
