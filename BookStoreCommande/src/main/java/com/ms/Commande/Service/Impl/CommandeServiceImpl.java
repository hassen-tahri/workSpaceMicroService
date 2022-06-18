package com.ms.Commande.Service.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.Commande.Service.CommandeService;
import com.ms.Commande.entity.Commande;
import com.ms.Commande.repository.Repo;

import java.util.List;

@Service
public class CommandeServiceImpl implements CommandeService {

    @Autowired
    Repo commandeRepository;



    @Override
    public Commande add(Commande commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public Commande findById(Long id) {
        return commandeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Commande> findAll() {
        return (List<Commande>) commandeRepository.findAll();
    }

    @Override
    public void DeleteById(Long id) {
        commandeRepository.deleteById(id);
    }
    @Override
    public Commande Update(Commande commande){
        return commandeRepository.save(commande);
    }

}
