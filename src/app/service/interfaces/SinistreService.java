package app.service.interfaces;

import app.model.Sinistre;

import java.time.LocalDateTime;
import java.util.List;

public interface SinistreService {
    Sinistre ajouterSinistre(Sinistre sinistre);
    Sinistre findSinistre(Integer sinistre_id);
    Boolean deleteSinistre(Integer sinistre_id);
    List<Sinistre> getSinistresTriMontantDec();
    List<Sinistre> filtreSinistreDateAv(LocalDateTime date);
    List<Sinistre> filtreSinistreCautSup(Double montant);
}
