package app.repository.impl;

import app.config.DatabaseConfig;
import app.model.Contrat;
import app.model.EnumContrat;
import app.repository.interfaces.ContratRepository;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

public class ContratRepositoryImpl implements ContratRepository {
    private static final Connection conn = DatabaseConfig.getInstance().getConnection();

    @Override
    public Optional<Contrat> insertContrat(Contrat contrat) {
        String insertQuery = "INSERT INTO contrat (typeContrat, dateDebut, dateFin, client_id) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)){
            stmt.setString(1, contrat.getTypeContrat().toString());
            stmt.setDate(2, Date.valueOf(contrat.getDateDebut()));
            stmt.setDate(3, Date.valueOf(contrat.getDateFin()));
            stmt.setInt(4, contrat.getClient_id());

            int rowsAff = stmt.executeUpdate();

            if (rowsAff > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        contrat.setId(generatedKeys.getInt(1));
                    }
                }
            }
            return Optional.of(contrat);
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de l'insert du contrat: " , e);
        }
    }

    @Override
    public List<Contrat> getAllContrat() {
        String selectQuery = "SELECT * FROM contrat";
        try (PreparedStatement stmt = conn.prepareStatement(selectQuery)) {
            ResultSet resultSet = stmt.executeQuery();
            List<Contrat> contrats = new ArrayList<>();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                EnumContrat typeContrat = EnumContrat.valueOf(resultSet.getString("typeContrat"));
                LocalDate dateDebut = resultSet.getDate("dateDebut").toLocalDate();
                LocalDate dateFin = resultSet.getDate("dateFin").toLocalDate();
                Integer client_id = resultSet.getInt("client_id");

                Contrat contrat = new Contrat(id, typeContrat, dateDebut, dateFin, client_id);
                contrats.add(contrat);
            }
            return contrats;
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors du selection des contrats: " , e);
        }
    }

    @Override
    public Optional<Contrat> findContrat(Integer contrat_id) {
        String selectQuery = "SELECT * FROM contrat WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(selectQuery)) {
            stmt.setInt(1, contrat_id);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                EnumContrat typeContrat = EnumContrat.valueOf(resultSet.getString("typeContrat"));
                LocalDate dateDebut = resultSet.getDate("dateDebut").toLocalDate();
                LocalDate dateFin = resultSet.getDate("dateFin").toLocalDate();
                Integer client_id = resultSet.getInt("client_id");

                return Optional.of(new Contrat(id, typeContrat, dateDebut, dateFin, client_id));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors du selection des contrats: " , e);
        }
    }

    @Override
    public Boolean deleteContrat(Contrat contrat) {
       String deleteQuery = "DELETE FROM contrat WHERE id = ?";
       try (PreparedStatement stmt = conn.prepareStatement(deleteQuery)) {
           stmt.setInt(1, contrat.getId());
           int rowsAff = stmt.executeUpdate();
           return rowsAff > 0;
       } catch (SQLException e) {
           throw new RuntimeException("Erreur lors du suppression de contrat: " , e);
       }
    }
}
