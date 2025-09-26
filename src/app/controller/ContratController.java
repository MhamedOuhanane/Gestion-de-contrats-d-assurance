package app.controller;

import app.model.Contrat;
import app.model.Sinistre;
import app.service.interfaces.ContratService;

import java.util.List;

public class ContratController {
    private final ContratService contratService;


    public ContratController(ContratService contratService) {
        this.contratService = contratService;
    }

    public String create(Contrat contrat) {
        try {
            contrat = this.contratService.ajouterContrat(contrat);
            return "✅ Le contrat est ajouter avec success avec l'id: " + contrat.getId();
        } catch (RuntimeException e) {
            return "❌ Erreur: " + e.getMessage();
        }
    }

    public String delete(Integer id) {
        try {
            Boolean delete = this.contratService.deleteContrat(id);
            if (delete) {
                return "🗑️ Contrat avec ID " + id + " supprimé avec succès.";
            } else {
                return "⚠️ Aucun Contrat trouvé avec ID " + id;
            }
        } catch (RuntimeException e) {
            return "❌ Erreur: " + e.getMessage();
        }
    }

    public String find(Integer id) {
        try {
            Contrat contrat = this.contratService.findContrat(id);
            if (contrat != null) {
                return "📜 Contrat trouvé: " + contrat.toString();
            } else {
                return "⚠️ Aucun contrat trouvé avec ID " + id;
            }
        } catch (RuntimeException e) {
            return "❌ Erreur: " + e.getMessage();
        }
    }

    public String getSinistres(Integer id) {
        try {
            List<Sinistre> sinistres = this.contratService.getSinistresContrat(id);
            if (sinistres.isEmpty()) return "➤ Ce Contrat n'a aucun Sinistre.";
            else {
                StringBuilder listSinistres = new StringBuilder("📋 La liste des Sinistres de ce Client est: ");
                for (Sinistre sinistre : sinistres) {
                    listSinistres.append("\n 💥 ").append(sinistre.toString());
                }
                return listSinistres.toString();
            }
        } catch (RuntimeException e) {
            return "❌ Erreur: " + e.getMessage();
        }
    }
}
