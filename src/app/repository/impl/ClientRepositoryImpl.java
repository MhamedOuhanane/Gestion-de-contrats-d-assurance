package app.repository.impl;

import app.config.DatabaseConfig;
import app.model.Client;
import app.model.Person;
import app.repository.interfaces.ClientRepository;
import app.repository.interfaces.PersonRepository;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ClientRepositoryImpl implements ClientRepository {
    private PersonRepository personRepository;
    private static final Connection conn = DatabaseConfig.getInstance().getConnection();

    public ClientRepositoryImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Optional<Client> createClient(Client client) {
        String insertQuery = "INSERT INTO client (id, nom, prenom, email, conseiller_id) VALUES (?, ?, ?, ?, ?)";
        try {
            Person person = this.personRepository.createPerson(client);
            PreparedStatement stmt = conn.prepareStatement(insertQuery);

            client.setId(person.getId());
            stmt.setInt(1, client.getId());
            stmt.setString(2, client.getNom());
            stmt.setString(3, client.getPrenom());
            stmt.setString(4, client.getEmail());
            stmt.setInt(5, client.getConseiller_id());

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                return Optional.of(client);
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de l'insert de client: " , e);
        }
    }

    @Override
    public Optional<Client> findClient(Integer client_id) {
        String selectQuery = "SELECT * FROM client WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(selectQuery)) {
            stmt.setInt(1, client_id);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String email = resultSet.getString("email");
                Integer conseiller_id = resultSet.getInt("conseiller_id");

                return Optional.of(new Client(id, nom, prenom, email, conseiller_id));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la selection de client: " , e);
        }
    }

    @Override
    public Map<Integer, Client> getAllClient() {
        String selectQuery = "SELECT * FROM client";
        try {
            PreparedStatement stmt = conn.prepareStatement(selectQuery);
            ResultSet resultSet = stmt.executeQuery();
            Map<Integer, Client> clients = new HashMap<>();
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
            throw new RuntimeException("Erreur lors de la selection des clients: " , e);
        }
    }

    @Override
    public boolean deleteClient(Client client) {
        String deleteQuery = "delete from client where id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(deleteQuery);
            stmt.setInt(1, client.getId());
            int rowsAff = stmt.executeUpdate();
            return rowsAff > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la suppression des clients: " , e);
        }
    }
}
