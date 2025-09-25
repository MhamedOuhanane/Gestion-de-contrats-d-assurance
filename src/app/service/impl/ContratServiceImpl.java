package app.service.impl;

import app.model.Contrat;
import app.model.Sinistre;
import app.repository.interfaces.ContratRepository;
import app.repository.interfaces.SinistreRepository;
import app.service.interfaces.ContratService;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ContratServiceImpl implements ContratService {
    private final ContratRepository contratRepository;
    private final SinistreRepository sinistreRepository;

    public ContratServiceImpl(ContratRepository contratRepository, SinistreRepository sinistreRepository) {
        this.contratRepository = contratRepository;
        this.sinistreRepository = sinistreRepository;
    }

    @Override
    public Contrat ajouterContrat(Contrat contrat) {
        if (contrat == null) throw new IllegalArgumentException("Le contrat ne peut pas être null");
        try {
            return this.contratRepository.insertContrat(contrat)
                    .orElseThrow(() -> new RuntimeException("Impossible d'ajouter le contrat d'id: " + contrat.getId()));
        } catch (RuntimeException e) {
            throw new RuntimeException("Erreur dans le service Contrat: " + e.getMessage(), e);
        }
    }

    @Override
    public Contrat findContrat(Integer contrat_id) {
        if (contrat_id == null) throw new IllegalArgumentException("L'id de contrat ne peut pas être null");
        try {
            return this.contratRepository.findContrat(contrat_id)
                    .orElseThrow(() -> new RuntimeException("Aucun contrat trouvé avec l'id: " + contrat_id));
        } catch (RuntimeException e) {
            throw new RuntimeException("Erreur dans le service Contrat: " + e.getMessage(), e);
        }
    }

    @Override
    public Boolean deleteContrat(Integer contrat_id) {
        if (contrat_id == null) throw new IllegalArgumentException("L'id de contrat ne peut pas être null");
        try {
            Contrat contrat = this.contratRepository.findContrat(contrat_id)
                    .orElseThrow(() -> new RuntimeException("Aucun contrat trouvé avec l'id: " + contrat_id));
            return this.contratRepository.deleteContrat(contrat);
        } catch (RuntimeException e) {
            throw new RuntimeException("Erreur dans le service Contrat: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Sinistre> getSinistresContrat(Integer contrat_id) {
        if (contrat_id == null) throw new IllegalArgumentException("L'id de contrat ne peut pas être null");
        try {
            Contrat contrat = this.contratRepository.findContrat(contrat_id)
                    .orElseThrow(() -> new RuntimeException("Aucun contrat trouvé avec l'id: " + contrat_id));
            return this.sinistreRepository.getAllSinistre().stream()
                    .filter(sinistre -> Objects.equals(sinistre.getContrat_id(), contrat.getId()))
                    .collect(Collectors.toList());
        } catch (RuntimeException e) {
            throw new RuntimeException("Erreur dans le service Contrat: " + e.getMessage(), e);
        }
    }
}
