package app.service.interfaces;

import app.model.Client;

import java.util.List;

public interface ClientService {
    Client ajouterClient(Client client);
    Client findClientById(Integer client_id);
    Client findClientByNom(String client_nom);
    List<Client> getFiltreClients();
    Boolean deleteClient(Integer client_id);

}
