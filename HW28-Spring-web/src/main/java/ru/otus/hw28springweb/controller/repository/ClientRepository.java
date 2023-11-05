package ru.otus.hw28springweb.controller.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.otus.hw28springweb.model.Client;

import java.util.List;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
//    Client save(Client client);
//    List<Client> findByFirstName(String name);
//    List<Client> getAll();
}
