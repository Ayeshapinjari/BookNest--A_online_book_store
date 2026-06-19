package Projects.OnlineBookStore.util;

import java.sql.*;

public class DBConnection {
        private static final String url="jdbc:mysql://localhost:3306/onlinebookstore";
        private static final String username="root";
        private static final String password="Ayshu#1177";

            public static Connection getConnection() {

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection(url,username,password);
                    //System.out.println("Database Connected Successfully");
                    return con;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
        }




