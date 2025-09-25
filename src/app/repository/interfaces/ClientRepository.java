package app.repository.interfaces;

import app.model.Client;
import java.util.Map;
import java.util.Optional;

public interface ClientRepository {
    Optional<Client> createClient(Client client);
    Optional<Client> findClient(Integer client_id);
    Map<Integer, Client> getAllClient();
    boolean deleteClient(Client client);
}
