package app.repository.interfaces;

import app.model.Sinistre;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public interface SinistreRepository {
    Optional<Sinistre> insertSinistre(Sinistre contrat);
    Map<Integer, Sinistre> getAllSinistre();
    Optional<Sinistre> findSinistre(Integer contrat_id);
    Boolean deleteSinistre(Sinistre contrat);
}
