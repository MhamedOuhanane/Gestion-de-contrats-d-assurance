package app.repository.interfaces;

import app.model.Client;
import app.model.Contrat;

import java.util.Map;
import java.util.Optional;

public interface ContratRepository {
    Optional<Contrat> insertContrat(Contrat contrat);
    Map<Integer, Contrat> getAllContrat();
    Optional<Contrat> findContrat(Integer contrat_id);
    Boolean deleteContrat(Contrat contrat);
}
