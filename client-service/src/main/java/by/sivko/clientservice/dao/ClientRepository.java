package by.sivko.clientservice.dao;

import by.sivko.clientservice.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
   Client findByName(String name);
   List<Client> findAll();
}
