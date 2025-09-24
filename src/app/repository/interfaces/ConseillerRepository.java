package app.repository.interfaces;

import app.model.Conseiller;
import java.util.List;

public interface ConseillerRepository {
    Conseiller createConseiller(Conseiller conseiller);
    List<Conseiller> getAllConseiller();
    boolean deleteConseiller(Conseiller conseiller);
}
