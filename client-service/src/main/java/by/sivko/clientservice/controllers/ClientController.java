package by.sivko.clientservice.controllers;

import by.sivko.clientservice.models.Client;
import by.sivko.clientservice.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/{id}")
    @Procedure("application/json")
    public Client getClientById(@PathVariable long id) {
        return this.clientService.getClientById(id);
    }

    @GetMapping
    @Procedure("application/json")
    public List<Client> getAllClients() {
        return this.clientService.getAllClients();
    }

}
