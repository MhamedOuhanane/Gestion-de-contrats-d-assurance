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
import java.util.Collections;
import java.util.List;

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
        return null;
    }

    @Override
    public List<Conseiller> getAllConseiller() {
        return Collections.emptyList();
    }

    @Override
    public boolean deleteConseiller(Conseiller conseiller) {
        return false;
    }
}
