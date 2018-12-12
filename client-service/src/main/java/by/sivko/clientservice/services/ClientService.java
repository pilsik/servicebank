package by.sivko.clientservice.services;

import by.sivko.clientservice.models.Client;

import java.util.List;

public interface ClientService {
    
    List<Client> getAllClients();

    Client deleteClient(Client client);

    Client findClientByClientname(String clientname);

    Client saveClient(Client client);

    Client getClientById(Long id);

}
