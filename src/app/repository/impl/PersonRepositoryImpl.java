package app.repository.impl;

import app.config.DatabaseConfig;
import app.model.Conseiller;
import app.model.Person;
import app.repository.interfaces.PersonRepository;

import java.sql.*;

public class PersonRepositoryImpl implements PersonRepository {
    private static final Connection conn = DatabaseConfig.getInstance().getConnection();

    @Override
    public Person createPerson(Person person) {
        String insertQuery = "INSERT INTO person (nom, prenom, email) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, person.getNom());
            stmt.setString(2, person.getPrenom());
            stmt.setString(3, person.getEmail());

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        person.setId(generatedKeys.getInt(1));
                    }
                }
            }
            return person;
        } catch (SQLException e) {
            throw new RuntimeException("Erreur SQL lors de la création de Person", e);
        }
    }

    @Override
    public Boolean deletePerson(Person person) {
        String deleteQuery = "DELETE FROM person WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(deleteQuery)) {
            stmt.setInt(1, person.getId());
            int rowsAff = stmt.executeUpdate();
            return rowsAff > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la suppression de person: ", e);
        }
    }
}
