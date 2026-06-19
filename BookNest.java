package Projects.OnlineBookStore;
import Projects.OnlineBookStore.Functions.AdminDAO;
import Projects.OnlineBookStore.Functions.BookDAO;
import Projects.OnlineBookStore.Functions.OrderDAO;
import Projects.OnlineBookStore.Functions.UserDAO;

import java.util.Scanner;

public class BookNest {

    public static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        UserDAO userDAO = new UserDAO();
        AdminDAO adminDAO = new AdminDAO();
        BookDAO bookDAO = new BookDAO();
        OrderDAO orderDAO = new OrderDAO();

        while (true) {

            System.out.println("\n=================================");
            System.out.println("      ONLINE BOOK STORE");
            System.out.println("=================================");
            System.out.println("1. Register");
            System.out.println("2. User Login");
            System.out.println("3. Admin Login");
            System.out.println("4. Exit");
            System.out.println("=================================");

            System.out.print("Enter Choice : ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    userDAO.registerUser();
                    break;

                case 2:

                    if (userDAO.loginUser()) {

                        while (true) {

                            System.out.println("\n=================================");
                            System.out.println("         USER DASHBOARD");
                            System.out.println("=================================");
                            System.out.println("1. View Books");
                            System.out.println("2. Buy Books");
                            System.out.println("3. Logout");
                            System.out.println("=================================");

                            System.out.print("Enter Choice : ");
                            int userChoice =
                                    Integer.parseInt(sc.nextLine());

                            switch (userChoice) {

                                case 1:
                                    bookDAO.viewBooks();
                                    break;

                                case 2:
                                    bookDAO.viewBooks();
                                    orderDAO.buyBook();
                                    break;

                                case 3:
                                    System.out.println("User Logged Out");
                                    break;

                                default:
                                    System.out.println("Invalid Choice");
                            }

                            if (userChoice == 3)
                                break;
                        }
                    }
                    break;

                case 3:

                    if (adminDAO.loginAdmin()) {

                        while (true) {

                            System.out.println("\n=================================");
                            System.out.println("        ADMIN DASHBOARD");
                            System.out.println("=================================");
                            System.out.println("1. Add Book");
                            System.out.println("2. View Books");
                            System.out.println("3. Update Quantity");
                            System.out.println("4. Delete Book");
                            System.out.println("5. View sales history");
                            System.out.println("6.LogOut");
                            System.out.println("=================================");

                            System.out.print("Enter Choice : ");

                            int adminChoice =
                                    Integer.parseInt(sc.nextLine());

                            switch (adminChoice) {

                                case 1:
                                    bookDAO.addBook();
                                    break;

                                case 2:
                                    bookDAO.viewBooks();
                                    break;

                                case 3:
                                    bookDAO.updateQuantity();
                                    break;

                                case 4:
                                    bookDAO.deleteBook();
                                    break;

                                case 5:
                                    orderDAO.viewSalesHistory();
                                    break;

                                case 6:
                                    System.out.println("Admin Logged Out");
                                    break;


                                default:
                                    System.out.println("Invalid Choice");
                            }

                            if (adminChoice == 6)
                                break;
                        }
                    }

                    break;

                case 4:
                    System.out.println("Thank You For Using BookNest");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}