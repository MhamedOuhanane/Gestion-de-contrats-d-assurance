package app.service.interfaces;

import app.model.Client;
import app.model.Conseiller;

import java.util.HashMap;
import java.util.List;

public interface ConseillerService {
    Conseiller ajouterConseiller(Conseiller conseiller);
    Conseiller findConseiller(Integer conseiller_id);
    List<Client> getClientsConseiller(Integer conseiller_id);
    Boolean deleteConsiller(Integer conseiller_id);
}
