package app.service.interfaces;

import app.model.Sinistre;

public interface SinistreService {
    Sinistre ajouterSinistre(Sinistre sinistre);
    Sinistre findSinistre(Integer sinistre_id);
    Boolean deleteSinistre(Integer sinistre_id);
}
