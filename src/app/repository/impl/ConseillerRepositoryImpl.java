package app.repository.impl;

import app.model.Conseiller;
import app.repository.interfaces.ConseillerRepository;
import java.util.Collections;
import java.util.List;

public class ConseillerRepositoryImpl implements ConseillerRepository {
    @Override
    public Conseiller createConseiller(Conseiller conseiller) {
        return null;
    }

    @Override
    public Conseiller findConseiller(Integer conseiller_id) {
        return null;
    }

    @Override
    public List<Conseiller> getAllConseiller() {
        return Collections.emptyList();
    }

    @Override
    public boolean deleteConseiller(Conseiller conseiller) {
        return false;
    }
}
