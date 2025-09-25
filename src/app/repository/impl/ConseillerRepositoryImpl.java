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
import java.util.*;

public class ConseillerRepositoryImpl implements ConseillerRepository {
    private static final Connection conn = DatabaseConfig.getInstance().getConnection();
    private final PersonRepository personRepository;

    public  ConseillerRepositoryImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Optional<Conseiller> createConseiller(Conseiller conseiller) {
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
                return Optional.of(conseiller);
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de l'insert de conseiller: ", e);
        }
    }

    @Override
    public Optional<Conseiller> findConseiller(Integer conseiller_id) {
        String selectQuery = "SELECT * FROM conseiller WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(selectQuery)) {
            stmt.setInt(1, conseiller_id);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String email = resultSet.getString("email");

                return Optional.of(new Conseiller(id, nom, prenom, email));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de trouver le conseiller: ", e);
        }
    }

    @Override
    public List<Conseiller> getAllConseiller() {
        String selectQuery = "SELECT * FROM conseiller";
        try (PreparedStatement stmt = conn.prepareStatement(selectQuery)) {
            ResultSet resultSet = stmt.executeQuery();
            List<Conseiller> conseillers = new ArrayList<>();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String email = resultSet.getString("email");

                Conseiller conseiller = new Conseiller(id, nom, prenom, email);
                conseillers.add(conseiller);
            }
            return conseillers;
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de trouver les conseiller: " , e);
        }
    }

    @Override
    public boolean deleteConseiller(Conseiller conseiller) {
        String deleteQuery = "DELETE FROM conseiller WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(deleteQuery)) {
            stmt.setInt(1, conseiller.getId());
            int rowsAff = stmt.executeUpdate();
            return rowsAff > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la suppression de client: ", e);
        }
    }
}
