package app.repository.impl;

import app.config.DatabaseConfig;
import app.model.Conseiller;
import app.model.Person;
import app.repository.interfaces.ConseillerRepository;
import app.repository.interfaces.PersonRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class ConseillerRepositoryImpl implements ConseillerRepository {
    private static final Connection conn = DatabaseConfig.getInstance().getConnection();
    private PersonRepository personRepository;

    @Override
    public Conseiller createConseiller(Conseiller conseiller) {
        String insertQuery = "INSERT INTO conseiller (id, nom, prenom, email) VALUES (?, ?, ?, ?)";
        try {
            Person person = personRepository.createPerson(conseiller);

            PreparedStatement stmt = conn.prepareStatement(insertQuery);

            conseiller.setId(person.getId());
            stmt.setInt(1, conseiller.getId());
            stmt.setString(2, conseiller.getNom());
            stmt.setString(3, conseiller.getPrenom());
            stmt.setString(4, conseiller.getEmail());

            int rowsAff = stmt.executeUpdate();
            if (rowsAff > 0) {
                return conseiller;
            }
            return null;
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'insert de conseiller: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Conseiller findConseiller(Integer conseiller_id) {
        String selectQuery = "SELECT * FROM conseiller WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(selectQuery)) {
            stmt.setInt(1, conseiller_id);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String email = resultSet.getString("email");

                return new Conseiller(id, nom, prenom, email);
            }
            return null;
        } catch (SQLException e) {
            System.out.println("Erreur lors de trouver le conseiller: " + e.getMessage());
            return null;
        }
    }

    @Override
    public HashMap<Integer, Conseiller> getAllConseiller() {
        String selectQuery = "SELECT * FROM conseiller";
        try (PreparedStatement stmt = conn.prepareStatement(selectQuery)) {
            ResultSet resultSet = stmt.executeQuery();
            HashMap<Integer, Conseiller> conseillers = new HashMap<>();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String email = resultSet.getString("email");

                Conseiller conseiller = new Conseiller(id, nom, prenom, email);
                conseillers.put(conseiller.getId(), conseiller);
            }
            return conseillers;
        } catch (SQLException e) {
            System.out.println("Erreur lors de trouver le conseiller: " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteConseiller(Conseiller conseiller) {
        String deleteQuery = "DELETE FROM conseiller WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(deleteQuery)) {
            stmt.setInt(1, conseiller.getId());
            int rowsAff = stmt.executeUpdate();
            if (rowsAff <= 0) {
                throw new SQLException("Suppression échouée");
            }
            return true;
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression de client: " + e.getMessage());
            return false;
        }
    }
}
