package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOS {
    static String username = "root";
    static String password = "Mightymac18!";
    static String dbUrl = "jdbc:mysql://localhost:3306/cars";

    public static void main(String[] args) throws SQLException {

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(dbUrl, username, password);

            System.out.println("Connection Established to MYSQL Database");

        } catch (SQLException e) {

            System.err.println(e.getMessage());

        } finally {

            conn.close();

        }
//    Connection conn = null;
//
//  try{
//        conn = DriverManager.getConnection(dbUrl, username, password);
//
//        System.out.println("Connection Established to MYSQL Database");
//
//    } catch (SQLException e) {
//
//        System.err.println(e.getMessage());
//
//    } finally {
//
//        conn.close();
//
//    }


    }
}