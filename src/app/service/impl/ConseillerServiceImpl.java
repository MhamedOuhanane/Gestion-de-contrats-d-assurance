package app.service.impl;

import app.model.Client;
import app.model.Conseiller;
import app.repository.interfaces.ClientRepository;
import app.repository.interfaces.ConseillerRepository;
import app.service.interfaces.ConseillerService;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ConseillerServiceImpl implements ConseillerService {
    private final ConseillerRepository conseillerRepository;
    private final ClientRepository clientRepository;

    public ConseillerServiceImpl(ConseillerRepository conseillerRepository, ClientRepository clientRepository) {
        this.conseillerRepository = conseillerRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public Conseiller ajouterConseiller(Conseiller conseiller) {
        if (conseiller == null) {
            throw new IllegalArgumentException("Le conseiller ne peut pas être null");
        }
        try {
            return this.conseillerRepository.createConseiller(conseiller)
                    .orElseThrow(() -> new RuntimeException("Impossible d'ajouter le conseiller: " + conseiller.getNom() + conseiller.getPrenom()));
        } catch (RuntimeException e) {
            throw new RuntimeException("Erreur dans le service Conseiller: " + e.getMessage(), e);
        }
    }

    @Override
    public Conseiller findConseiller(Integer conseiller_id) {
        if (conseiller_id == null) {
            throw new IllegalArgumentException("L'id conseiller ne peut pas être null");
        }
        try {
            return this.conseillerRepository.findConseiller(conseiller_id)
                    .orElseThrow(() -> new RuntimeException("Aucun conseiller trouvé avec l'id: " + conseiller_id));
        } catch (RuntimeException e) {
            throw new RuntimeException("Erreur dans le service Conseiller: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Client> getClientsConseiller(Integer conseiller_id) {
        if (conseiller_id == null) {
            throw new IllegalArgumentException("L'id conseiller ne peut pas être null");
        }
        try {
            Conseiller conseiller = this.conseillerRepository.findConseiller(conseiller_id)
                    .orElseThrow(() -> new RuntimeException("Aucun conseiller trouvé avec l'id: " + conseiller_id));
            List<Client> clients = this.clientRepository.getAllClient();
            return clients.stream()
                    .filter(client -> Objects.equals(client.getConseiller_id(), conseiller.getId()))
                    .collect(Collectors.toList());
        } catch (RuntimeException e) {
            throw new RuntimeException("Erreur dans le service Conseiller: " + e.getMessage(), e);
        }
    }

    @Override
    public Boolean deleteConsiller(Integer conseiller_id) {
        if (conseiller_id == null) {
            throw new IllegalArgumentException("L'id conseiller ne peut pas être null");
        }

        try {
            Conseiller conseiller = this.conseillerRepository.findConseiller(conseiller_id)
                    .orElseThrow(() -> new RuntimeException("Aucun conseiller trouvé avec l'id: " + conseiller_id));
            return this.conseillerRepository.deleteConseiller(conseiller);
        } catch (RuntimeException e) {
            throw new RuntimeException("Erreur dans le service Conseiller: " + e.getMessage(), e);
        }
    }
}
