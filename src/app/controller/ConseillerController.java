package app.controller;

import app.model.Conseiller;
import app.service.interfaces.ConseillerService;

import java.util.Map;

public class ConseillerController {
    private final ConseillerService conseillerService;

    public ConseillerController(ConseillerService conseillerService) {
        this.conseillerService = conseillerService;
    }

    public String create(Conseiller conseiller) {
        try {
            Conseiller newConsseiller = this.conseillerService.ajouterConseiller(conseiller);
            return "✅ Le conseiller est ajouter avec success avec l'id: " + newConsseiller.getId();
        } catch (RuntimeException e) {
            return "❌ Erreur: " + e.getMessage();
        }
    }

    public String find(Integer id) {
        try {
            Conseiller conseiller = this.conseillerService.findConseiller(id);
            if (conseiller != null) {
                return "👤 Conseiller trouvé: "
                        + conseiller.getNom() + " " + conseiller.getPrenom()
                        + " | Email: " + conseiller.getEmail();
            } else {
                return "⚠️ Aucun conseiller trouvé avec ID " + id;
            }
        } catch (RuntimeException e) {
            return "❌ Erreur: " + e.getMessage();
        }
    }

    public String delete(Integer id) {
        try {
            Boolean delete = this.conseillerService.deleteConsiller(id);
            if (delete) {
                return "🗑️ Conseiller avec ID " + id + " supprimé avec succès.";
            } else {
                return "⚠️ Aucun conseiller trouvé avec ID " + id;
            }
        } catch (RuntimeException e) {
            return "❌ Erreur: " + e.getMessage();
        }
    }
}
