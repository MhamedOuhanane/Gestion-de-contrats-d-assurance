package java.repository.interfaces;

import java.model.Client;
import java.util.HashMap;

public interface ClientRepository {
    Client createClient(Client client);
    HashMap<Integer, Client> getAllClient();
    boolean deleteClient(Client client);
}
