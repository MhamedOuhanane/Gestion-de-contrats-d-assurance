package app.service.interfaces;

import app.model.Contrat;

public interface ContratService {
    Contrat ajouterContrat(Contrat contrat);
    Contrat findContrat(Integer contrat_id);
    Contrat deleteContrat(Integer contrat_Id);
}
