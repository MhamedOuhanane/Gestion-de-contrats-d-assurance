package app.service.impl;

import app.model.Client;
import app.repository.interfaces.ClientRepository;
import app.service.interfaces.ClientService;

import java.util.Collections;
import java.util.List;

public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client ajouterClient(Client client) {
        if (client == null) {
            throw new IllegalArgumentException("Le client ne peut pas être null");
        }
        try {
            return this.clientRepository.createClient(client)
                    .orElseThrow(() -> new RuntimeException("Impossible d'ajouter le client: " + client.getNom() + client.getPrenom()));
        } catch (RuntimeException e) {
            throw new RuntimeException("Erreur dans le service Client: " + e.getMessage(), e);
        }
    }

    @Override
    public Client findClientById(Integer client_id) {
        return null;
    }

    @Override
    public Client findClientByNom(String client_nom) {
        return null;
    }

    @Override
    public List<Client> getFiltreClients() {
        return Collections.emptyList();
    }

    @Override
    public Boolean deleteClient(Integer client_id) {
        return null;
    }

}
