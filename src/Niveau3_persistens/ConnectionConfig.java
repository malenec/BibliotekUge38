package Niveau3_persistens;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionConfig {

    public static Connection getConnectionMalene() {
        Connection connection = null;
        String url = "jdbc:mysql://localhost:3306/Bibliotek?serverTimezone=CET&useSSL=false";
        String user = "root";
        String password = null;
        try {
            password = "elvinha-17";
        } catch (Exception e) {
            password = "Grycecilie0510";
        }
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}


