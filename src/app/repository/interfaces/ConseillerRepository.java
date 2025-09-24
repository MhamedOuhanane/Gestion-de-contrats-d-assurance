package app.repository.interfaces;

import app.model.Conseiller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface ConseillerRepository {
    Conseiller createConseiller(Conseiller conseiller);
    Conseiller findConseiller(Integer conseiller_id);
    HashMap<Integer, Conseiller> getAllConseiller();
    boolean deleteConseiller(Conseiller conseiller);

}
