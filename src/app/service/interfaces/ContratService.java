package app.service.interfaces;

import app.model.Contrat;

public interface ContratService {
    Contrat ajouterContrat(Contrat contrat);
    Contrat findContrat(Integer contrat_id);
    Boolean deleteContrat(Integer contrat_id);
}
