package one.digitalinnovation.padroesspring.service;

import one.digitalinnovation.padroesspring.model.Client;

import java.util.List;


public interface ClientService {
    List<Client> findAll();
    Client findById(Long id);
    void insert(Client client);
    void update(Long id, Client client);
    void delete(Long id);
}

