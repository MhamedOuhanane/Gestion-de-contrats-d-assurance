package app.service.impl;

import app.model.Client;
import app.model.Contrat;
import app.model.Sinistre;
import app.repository.interfaces.ClientRepository;
import app.repository.interfaces.ContratRepository;
import app.repository.interfaces.SinistreRepository;
import app.service.interfaces.ClientService;
import app.service.interfaces.ContratService;

import java.util.*;
import java.util.stream.Collectors;

public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ContratRepository contratRepository;
    private final SinistreRepository sinistreRepository;
    private final ContratService contratService;

    public ClientServiceImpl(ClientRepository clientRepository, ContratRepository contratRepository, SinistreRepository sinistreRepository, ContratService contratService) {
        this.clientRepository = clientRepository;
        this.contratRepository = contratRepository;
        this.sinistreRepository = sinistreRepository;
        this.contratService = contratService;
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
        if (client_id == null) {
            throw new IllegalArgumentException("L'id client ne peut pas être null");
        }
        try {
            return this.clientRepository.findClient(client_id)
                    .orElseThrow(() -> new RuntimeException("Aucun client trouvé avec l'id: " + client_id));
        } catch (RuntimeException e) {
            throw new RuntimeException("Erreur dans le service Client: " + e.getMessage(), e);
        }
    }

    @Override
    public Client findClientByNom(String client_nom) {
        if (client_nom == null || client_nom.isEmpty()) {
            throw new IllegalArgumentException("Le nom de client ne peut pas être null ou vide");
        }

        try {
            return this.clientRepository.getAllClient().stream()
                    .filter(client -> Objects.equals(client.getNom(), client_nom))
                    .findFirst().orElseThrow(() -> new RuntimeException("Aucun client trouvé avec le nom: \"" + client_nom + "\"."));
        } catch (RuntimeException e) {
            throw new RuntimeException("Erreur dans le service Client: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Client> getFiltreClients() {
        try {
            return this.clientRepository.getAllClient().stream()
                    .sorted((c1, c2) -> {
                        int compareNom = c1.getNom().compareToIgnoreCase(c2.getNom());
                        if (compareNom == 0) return c1.getPrenom().compareToIgnoreCase(c2.getPrenom());
                        return compareNom;
                    })
                    .collect(Collectors.toList());
        } catch (RuntimeException e) {
            throw new RuntimeException("Erreur dans le service Client: " + e.getMessage(), e);
        }
    }

    @Override
    public Boolean deleteClient(Integer client_id) {
        if (client_id == null) throw new IllegalArgumentException("L'id de client ne peut pas être null");
        try {
            Client client = this.clientRepository.findClient(client_id)
                    .orElseThrow(() -> new RuntimeException("Aucun client trouvé avec l'id: " + client_id));
            return this.clientRepository.deleteClient(client);
        } catch (RuntimeException e) {
            throw new RuntimeException("Erreur dans le service Client: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Contrat> getContratsClient(Integer client_id) {
        if (client_id == null) throw new IllegalArgumentException("L'id de client ne peut pas être null");

        try {
            Client client = this.clientRepository.findClient(client_id)
                    .orElseThrow(() -> new RuntimeException("Aucun client trouvé avec l'id: " + client_id));

            return this.contratRepository.getAllContrat().stream()
                    .filter(c -> Objects.equals(c.getClient_id(), client.getId()))
                    .collect(Collectors.toList());
        } catch (RuntimeException e) {
            throw new RuntimeException("Erreur dans le service Client: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Sinistre> getSinistresClient(Integer client_id) {
        try {
            List<Contrat> contrats = this.getContratsClient(client_id);
            List<Sinistre> sinistres = new ArrayList<>();
            for (Contrat contrat : contrats) {
                sinistres.addAll(this.contratService.getSinistresContrat(contrat.getId()));
            }
            return sinistres;
        } catch (RuntimeException e) {
            throw new RuntimeException("Erreur lors de récupération des sinistres du client " + client_id, e);
        }
    }

}
