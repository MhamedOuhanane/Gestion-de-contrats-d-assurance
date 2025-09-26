package app.controller;

import app.model.Client;
import app.model.Conseiller;
import app.service.interfaces.ConseillerService;

import java.util.List;

public class ConseillerController {
    private final ConseillerService conseillerService;

    public ConseillerController(ConseillerService conseillerService) {
        this.conseillerService = conseillerService;
    }

    public String create(Conseiller conseiller) {
        try {
            conseiller = this.conseillerService.ajouterConseiller(conseiller);
            return "✅ Le conseiller est ajouter avec success avec l'id: " + conseiller.getId();
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

    public String  getClients(Integer id) {
        try {
            List<Client> clients = this.conseillerService.getClientsConseiller(id);
            if (clients.isEmpty()) {
                return " ➤ Ce conseiller n'a aucun client.";
            } else {
                StringBuilder affichage = new StringBuilder("📋 Liste des client de ce conseiller est: ");
                for (Client client : clients) {
                    affichage.append("\n 👤 ").append(client.toString());
                }
                return affichage.toString();
            }
        } catch (RuntimeException e) {
            return "❌ Erreur: " + e.getMessage();
        }
    }
}
