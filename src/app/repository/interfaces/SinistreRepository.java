package app.repository.interfaces;

import app.model.Sinistre;

import java.util.HashMap;

public interface SinistreRepository {
    Sinistre insertSinistre(Sinistre contrat);
    HashMap<Integer, Sinistre> getAllSinistre();
    Sinistre findSinistre(Integer contrat_id);
    Boolean deleteSinistre(Sinistre contrat);
}
