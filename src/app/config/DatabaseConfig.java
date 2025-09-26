package app.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    private Connection connection;
    private static DatabaseConfig instance;

    private static final String URL = "jdbc:mysql://localhost:3306/gcassurance";
    private static final String USER = "Mhamed";
    private static final String PASSWORD = "";

    private DatabaseConfig() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connecté à la base de données avec succès !");
        } catch (SQLException e) {
            System.err.println("Erreur lors de la connexion à la base de données : " + e.getMessage());
        }
    }

    public static DatabaseConfig getInstance() {
        if (instance == null) {
            instance = new DatabaseConfig();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

}
