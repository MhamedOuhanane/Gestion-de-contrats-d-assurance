package app.service.impl;

import app.model.Client;
import app.model.Conseiller;
import app.repository.interfaces.ConseillerRepository;
import app.service.interfaces.ConseillerService;

import java.util.Collections;
import java.util.List;

public class ConseillerServiceImpl implements ConseillerService {
    private ConseillerRepository conseillerRepository;

    public ConseillerServiceImpl(ConseillerRepository conseillerRepository) {
        this.conseillerRepository = conseillerRepository;
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
            throw new RuntimeException(e);
        }
    }

    @Override
    public Conseiller findConseiller(Integer conseiller_id) {
        if (conseiller_id == null) {
            throw new IllegalArgumentException("Le id conseiller ne peut pas être null");
        }
        try {
            return this.conseillerRepository.findConseiller(conseiller_id)
                    .orElseThrow(() -> new RuntimeException("Aucun conseiller trouvé avec l'id: " + conseiller_id));
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Client> getClientsConseiller(Integer conseiller_id) {
        return Collections.emptyList();
    }

    @Override
    public Boolean deleteConsiller(Integer conseiller_id) {
        return null;
    }
}
