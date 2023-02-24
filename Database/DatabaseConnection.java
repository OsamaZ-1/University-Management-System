package Database;

import java.sql.*;

public class DatabaseConnection {
    private static Connection con = null;
  
    static
    {
        String url = "jdbc:mysql://localhost:3306/UMS";
        String user = "root";
        String pass = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        return con;
    }
}
