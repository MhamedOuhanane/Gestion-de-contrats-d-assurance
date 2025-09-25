package app.service.impl;

import app.model.Contrat;
import app.repository.interfaces.ContratRepository;
import app.service.interfaces.ContratService;

public class ContratServiceImpl implements ContratService {
    private final ContratRepository contratRepository;

    public ContratServiceImpl(ContratRepository contratRepository) {
        this.contratRepository = contratRepository;
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
        return null;
    }

    @Override
    public Contrat deleteContrat(Integer contrat_Id) {
        return null;
    }
}
