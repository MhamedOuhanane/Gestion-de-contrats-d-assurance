package app.repository.interfaces;

import app.model.Contrat;

import java.util.HashMap;

public interface ContratRepository {
    Contrat insertContrat(Contrat contrat);
    HashMap<Integer, Contrat> getAllContrat();
    Contrat findContrat(Integer contrat_id);
    Boolean deleteContrat(Contrat contrat);
}
