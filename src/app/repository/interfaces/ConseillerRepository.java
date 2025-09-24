package app.repository.interfaces;

import app.model.Conseiller;
import java.util.List;

public interface ConseillerRepository {
    Conseiller createConseiller(Conseiller conseiller);
    Conseiller findConseiller(Integer conseiller_id);
    List<Conseiller> getAllConseiller();
    boolean deleteConseiller(Conseiller conseiller);

}
