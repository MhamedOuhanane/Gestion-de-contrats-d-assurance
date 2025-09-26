package app.controller;

import app.model.Sinistre;
import app.service.interfaces.SinistreService;

public class SinistreController {
    private SinistreService sinistreService;

    public SinistreController(SinistreService sinistreService) {
        this.sinistreService = sinistreService;
    }

    public String create(Sinistre sinistre) {
        try {
            sinistre = this.sinistreService.ajouterSinistre(sinistre);
            return "✅ Le contrat est ajouter avec success avec l'id: " + sinistre.getId();
        } catch (RuntimeException e) {
            return "❌ Erreur: " + e.getMessage();
        }
    }
}
