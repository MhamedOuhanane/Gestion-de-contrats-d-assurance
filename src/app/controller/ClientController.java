package app.controller;

import app.model.Client;
import app.service.interfaces.ClientService;

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

}
