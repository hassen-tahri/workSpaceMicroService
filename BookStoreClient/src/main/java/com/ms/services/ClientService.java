package com.ms.services;

import java.util.List;

import com.ms.entities.Client;

public interface ClientService {
    Client save(Client client);
    Client getById(Long id);
    List<Client> getAll();
    void deleteById(Long id);

}