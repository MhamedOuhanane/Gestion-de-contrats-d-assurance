package java.repository.interfaces;

import java.model.Conseiller;
import java.util.List;

public interface ConseillerRepository {
    Conseiller createConseiller(Conseiller conseiller);
    List<Conseiller> getAllConseiller();
    boolean deleteConseiller(Conseiller conseiller);
}
