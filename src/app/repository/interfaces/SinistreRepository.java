package app.repository.interfaces;

import app.model.Sinistre;

import java.util.List;
import java.util.Optional;

public interface SinistreRepository {
    Optional<Sinistre> insertSinistre(Sinistre contrat);
    List<Sinistre> getAllSinistre();
    Optional<Sinistre> findSinistre(Integer contrat_id);
    Boolean deleteSinistre(Sinistre contrat);
}
