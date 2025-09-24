package app.repository.impl;

import app.config.DatabaseConfig;
import app.model.Client;
import app.repository.interfaces.ClientRepository;
import java.sql.*;
import java.util.HashMap;

public class ClientRepositoryImpl implements ClientRepository {
    private static final Connection conn = DatabaseConfig.getInstance().getConnection();

    @Override
    public Client createClient(Client client) {
        String insertQuery = "INSERT INTO client (nom, prenom, email, conseiller_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, client.getNom());
            stmt.setString(2, client.getPrenom());
            stmt.setString(3, client.getEmail());
            stmt.setInt(4, client.getConseiller_id());

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        client.setId(generatedKeys.getInt("id"));
                    }
                }
            }
            return client;
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'insert de client: " + e.getMessage());
            return null;
        }
    }

    @Override
    public HashMap<Integer, Client> getAllClient() {
        String selectQuery = "SELECT * FROM client";
        try {
            PreparedStatement stmt = conn.prepareStatement(selectQuery);
            ResultSet resultSet = stmt.executeQuery();
            HashMap<Integer, Client> clients = new HashMap<>();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String email = resultSet.getString("email");
                Integer conseiller_id = resultSet.getInt("conseiller_id");

                Client client = new Client(id, nom, prenom, email, conseiller_id);
                clients.put(id, client);
            }

            return clients;
        } catch (SQLException e) {
            System.out.println("Erreur lors de la selection des clients: " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteClient(Client client) {
        String deleteQuery = "delete from client where id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(deleteQuery);
            stmt.setInt(1, client.getId());
            int rowsAff = stmt.executeUpdate();
            if (rowsAff <= 0) {
                throw new SQLException("Suppression échouée");
            }
            return true;
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression des clients: " + e.getMessage());
            return false;
        }
    }
}
