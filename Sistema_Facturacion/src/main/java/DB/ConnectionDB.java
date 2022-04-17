package DB;

import java.sql.*;
import javax.swing.*;

public class ConnectionDB {

    private static Connection conn = null;

    public Connection getConnection() {

        try {

            String url = "";
            String user = "";
            String password = "";

            conn = DriverManager.getConnection(url, user, password);
            
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Error "+ e.toString());
        }

        return conn;
    }
}
