package app.service.impl;

import app.model.Contrat;
import app.model.Sinistre;
import app.repository.interfaces.SinistreRepository;
import app.service.interfaces.ContratService;
import app.service.interfaces.SinistreService;

import java.sql.SQLException;

public class SinistreServiceImpl implements SinistreService {
    private final SinistreRepository sinistreRepository;
    private final ContratService contratService;

    public SinistreServiceImpl(SinistreRepository sinistreRepository, ContratService contratService) {
        this.sinistreRepository = sinistreRepository;
        this.contratService = contratService;
    }


    @Override
    public Sinistre ajouterSinistre(Sinistre sinistre) {
        if (sinistre == null) throw new IllegalArgumentException("Le sinistre ne peut pas être null");
        try {
            Contrat contrat = this.contratService.findContrat(sinistre.getContrat_id());
            return this.sinistreRepository.insertSinistre(sinistre)
                        .orElseThrow(() -> new RuntimeException("Impossible d'ajouter le sinistre"));
        } catch (RuntimeException e) {
            throw new RuntimeException("Erreur dans le service Sinistre: " + e.getMessage(), e);
        }
    }

    @Override
    public Sinistre findSinistre(Integer sinistre_id) {
        if (sinistre_id == null) throw new IllegalArgumentException("L'id de sinistre ne peut pas être null");
        try {
            return this.sinistreRepository.findSinistre(sinistre_id)
                    .orElseThrow(() -> new RuntimeException("Aucun sinistre trouvé avec l'id: " + sinistre_id));
        } catch (RuntimeException e) {
            throw new RuntimeException("Erreur dans le service Sinistre: " + e.getMessage(), e);
        }
    }

    @Override
    public Boolean deleteSinistre(Integer sinistre_id) {
        if (sinistre_id == null) throw new IllegalArgumentException("L'id de sinistre ne peut pas être null");
        try {
            Sinistre sinistre = this.findSinistre(sinistre_id);
            return this.sinistreRepository.deleteSinistre(sinistre);
        } catch (RuntimeException e) {
            throw new RuntimeException("Erreur dans le service Sinistre: " + e.getMessage(), e);
        }
    }
}
