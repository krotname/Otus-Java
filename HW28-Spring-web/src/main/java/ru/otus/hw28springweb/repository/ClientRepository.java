package ru.otus.hw28springweb.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import ru.otus.hw28springweb.entity.Client;

@Repository
public interface ClientRepository extends ListCrudRepository<Client, Long> {
//    Client save(Client client);
//    List<Client> findByFirstName(String name);
//    List<Client> getAll();
}
