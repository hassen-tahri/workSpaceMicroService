package com.ms.impl;

import com.ms.entities.Client;
import com.ms.repositories.ClientRepository;
import com.ms.services.ClientService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    public ClientRepository clrep;

    @Override
    public Client save(Client client) {
        return clrep.save(client);
    }

    @Override
    public Client getById(Long id) {
        return clrep.findById(id).get();
    }

	@Override
	public List<Client> getAll() {
		return (List<Client>) clrep.findAll();
	}

	@Override
	public void deleteById(Long id) {
		clrep.deleteById(id);
		
	}
}
