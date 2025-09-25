package app.repository.impl;

import app.config.DatabaseConfig;
import app.model.Sinistre;
import app.model.EnumSinistre;
import app.repository.interfaces.SinistreRepository;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;

public class SinistreRepositoryImpl implements SinistreRepository {
    private static final Connection conn = DatabaseConfig.getInstance().getConnection();

    @Override
    public Optional<Sinistre> insertSinistre(Sinistre sinistre) {
        String insertQuery = "INSERT INTO sinistre (typeSinistre, date, montant, description, contrat_id) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)){
            stmt.setString(1, sinistre.getTypeSinistre().getDescription());
            stmt.setTimestamp(2, Timestamp.valueOf(sinistre.getDate()));
            stmt.setDouble(3, sinistre.getMontant());
            stmt.setString(4, sinistre.getDescription());
            stmt.setInt(5, sinistre.getContrat_id());

            int rowsAff = stmt.executeUpdate();

            if (rowsAff > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        sinistre.setId(generatedKeys.getInt(1));
                    }
                }
            }
            return Optional.of(sinistre);
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de l'insert du sinistre: " , e);
        }
    }

    @Override
    public List<Sinistre> getAllSinistre() {
        String selectQuery = "SELECT * FROM sinistre";
        try (PreparedStatement stmt = conn.prepareStatement(selectQuery)) {
            ResultSet resultSet = stmt.executeQuery();
            List<Sinistre> sinistres = new ArrayList<>();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                EnumSinistre typeSinistre = EnumSinistre.valueOf(resultSet.getString("typeSinistre"));
                LocalDateTime date = resultSet.getTimestamp("date").toLocalDateTime();
                Double montant = resultSet.getDouble("montant");
                String description = resultSet.getString("description");
                Integer contrat_id = resultSet.getInt("contrat_id");

                Sinistre sinistre = new Sinistre(id, typeSinistre, date, montant, description, contrat_id);
                sinistres.add(sinistre);
            }
            return sinistres;
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors du selection des sinistres: " , e);
        }
    }

    @Override
    public Optional<Sinistre> findSinistre(Integer sinistre_id) {
        String selectQuery = "SELECT * FROM sinistre WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(selectQuery)) {
            stmt.setInt(1, sinistre_id);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                EnumSinistre typeSinistre = EnumSinistre.valueOf(resultSet.getString("typeSinistre"));
                LocalDateTime date = resultSet.getTimestamp("date").toLocalDateTime();
                Double montant = resultSet.getDouble("montant");
                String description = resultSet.getString("description");
                Integer contrat_id = resultSet.getInt("contrat_id");

                return Optional.of(new  Sinistre(id, typeSinistre, date, montant, description, contrat_id));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors du selection des sinistres: " , e);
        }
    }

    @Override
    public Boolean deleteSinistre(Sinistre sinistre) {
        String deleteQuery = "DELETE FROM sinistre WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(deleteQuery)) {
            stmt.setInt(1, sinistre.getId());
            int rowsAff = stmt.executeUpdate();
            return rowsAff > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors du suppression de sinistre: " , e);
        }
    }
}
