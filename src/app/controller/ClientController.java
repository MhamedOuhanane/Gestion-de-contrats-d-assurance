package app.controller;

import app.model.Client;
import app.model.Conseiller;
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
}
