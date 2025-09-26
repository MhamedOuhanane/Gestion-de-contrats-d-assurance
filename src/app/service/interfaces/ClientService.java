package app.service.interfaces;

import app.model.Client;
import app.model.Contrat;
import app.model.Sinistre;

import java.util.List;

public interface ClientService {
    Client ajouterClient(Client client);
    Client findClientById(Integer client_id);
    Client findClientByNom(String client_nom);
    List<Client> getFiltreClients();
    Boolean deleteClient(Integer client_id);
    List<Contrat> getContratsClient(Integer client_id);
    List<Sinistre> getSinistresClient(Integer client_id);
    Double getCoutTotalSinistre(Integer client_id);

}
