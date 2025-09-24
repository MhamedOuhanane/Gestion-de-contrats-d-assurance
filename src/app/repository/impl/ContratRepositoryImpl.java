package app.repository.impl;

import app.config.DatabaseConfig;
import app.model.Contrat;
import app.repository.interfaces.ContratRepository;

import java.sql.*;
import java.util.HashMap;

public class ContratRepositoryImpl implements ContratRepository {
    private static final Connection conn = DatabaseConfig.getInstance().getConnection();

    @Override
    public Contrat insertContrat(Contrat contrat) {
        String insertQuery = "INSERT INTO contrat (typeContrat, dateDebut, dateFin, client_id)";

        try (PreparedStatement stmt = conn.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)){
            stmt.setString(1, contrat.getTypeContrat().getDescription());
            stmt.setDate(2, Date.valueOf(contrat.getDateDebut()));
            stmt.setDate(3, Date.valueOf(contrat.getDateDebut()));
            stmt.setInt(4, contrat.getClient_id());

            int rowsAff = stmt.executeUpdate();

            if (rowsAff > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        contrat.setId(generatedKeys.getInt(1));
                    }
                }
            }
            return contrat;
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'insert du contrat: " + e.getMessage());
            return null;
        }
    }

    @Override
    public HashMap<Integer, Contrat> getAllContrat() {
        return null;
    }

    @Override
    public Contrat findContrat(Integer contrat_id) {
        return null;
    }

    @Override
    public Boolean deleteContrat(Contrat contrat) {
        return null;
    }
}
