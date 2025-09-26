package app.controller;

import app.model.Client;
import app.model.Contrat;
import app.model.Sinistre;
import app.service.interfaces.ClientService;

import java.util.List;

public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    public String create(Client client) {
        try {
            client = this.clientService.ajouterClient(client);
            return "✅ Le client est ajouter avec success avec l'id: " + client.getId();
        } catch (RuntimeException e) {
            return "❌ Erreur: " + e.getMessage();
        }
    }

    public String findById(Integer id) {
        try {
            Client client = this.clientService.findClientById(id);
            if (client != null) {
                return "👤 Client trouvé: "
                        + client.getNom() + " " + client.getPrenom()
                        + " | Email: " + client.getEmail();
            } else {
                return "⚠️ Aucun client trouvé avec ID " + id;
            }
        } catch (RuntimeException e) {
            return "❌ Erreur: " + e.getMessage();
        }
    }

    public String findByNom(String nom) {
        try {
            Client client = this.clientService.findClientByNom(nom);
            if (client != null) {
                return "👤 Client trouvé: "
                        + client.getNom() + " " + client.getPrenom()
                        + " | Email: " + client.getEmail();
            } else {
                return "⚠️ Aucun client trouvé avec le nom " + nom;
            }
        } catch (RuntimeException e) {
            return "❌ Erreur: " + e.getMessage();
        }
    }

    public String delete(Integer id) {
        try {
            Boolean delete = this.clientService.deleteClient(id);
            if (delete) {
                return "🗑️ Client avec ID " + id + " supprimé avec succès.";
            } else {
                return "⚠️ Aucun client trouvé avec ID " + id;
            }
        } catch (RuntimeException e) {
            return "❌ Erreur: " + e.getMessage();
        }
    }

    public String getContrats(Integer id) {
        try {
            List<Contrat> contrats = this.clientService.getContratsClient(id);
            if (contrats.isEmpty()) return " ➤ Ce Client n'a aucun Contrat.";
            else {
                StringBuilder listContrat = new StringBuilder("📋 La liste des Contrat de ce Client est: ");
                for (Contrat contrat : contrats) {
                    listContrat.append("\n 📜 ").append(contrat.toString());
                }
                return listContrat.toString();
            }
        } catch (RuntimeException e) {
            return "❌ Erreur: " + e.getMessage();
        }
    }

    public String getSinistres(Integer id) {
        try {
            List<Sinistre> sinistres = this.clientService.getSinistresClient(id);
            if (sinistres.isEmpty()) return " ➤ Ce Clients n'a aucun Sinistre.";
            else {
                StringBuilder listSinistre = new StringBuilder("📋 La liste des Sinistres de ce Client est: ");
                for (Sinistre sinistre : sinistres) {
                    listSinistre.append("\n 💥 ").append(sinistre.toString());
                }
                return listSinistre.toString();
            }
        } catch (RuntimeException e) {
            return "❌ Erreur: " + e.getMessage();
        }
    }
}
