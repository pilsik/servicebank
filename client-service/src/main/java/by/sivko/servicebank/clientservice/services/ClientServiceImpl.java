package by.sivko.servicebank.clientservice.services;

import by.sivko.servicebank.clientservice.dao.ClientRepository;
import by.sivko.servicebank.clientservice.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> getAllClients() {
        return this.clientRepository.findAll();
    }

    @Override
    public Client deleteClient(Client client) {
        this.clientRepository.delete(client);
        return client;
    }

    @Override
    public Client findClientByClientname(String clientname) {
        return this.clientRepository.findByName(clientname);
    }

    @Override
    public Client saveClient(Client client) {
        return this.clientRepository.save(client);
    }

    @Override
    public Client getClientById(Long id) {
        return this.clientRepository.getOne(id);
    }
}
