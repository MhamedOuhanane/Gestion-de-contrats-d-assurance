package app.repository.interfaces;

import app.model.Conseiller;
import java.util.*;

public interface ConseillerRepository {
    Optional<Conseiller> createConseiller(Conseiller conseiller);
    Optional<Conseiller> findConseiller(Integer conseiller_id);
    List<Conseiller> getAllConseiller();
    boolean deleteConseiller(Conseiller conseiller);

}
