package app.repository.interfaces;

import app.model.Contrat;
import java.util.List;
import java.util.Optional;

public interface ContratRepository {
    Optional<Contrat> insertContrat(Contrat contrat);
    List<Contrat> getAllContrat();
    Optional<Contrat> findContrat(Integer contrat_id);
    Boolean deleteContrat(Contrat contrat);
}
