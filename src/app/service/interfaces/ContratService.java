package app.service.interfaces;

import app.model.Contrat;
import app.model.Sinistre;

import java.util.List;

public interface ContratService {
    Contrat ajouterContrat(Contrat contrat);
    Contrat findContrat(Integer contrat_id);
    Boolean deleteContrat(Integer contrat_id);
    List<Sinistre> getSinistresContrat(Integer contrat_id);
}
