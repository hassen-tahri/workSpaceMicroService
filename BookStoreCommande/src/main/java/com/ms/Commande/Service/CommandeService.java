package com.ms.Commande.Service;


import java.util.List;

import com.ms.Commande.entity.Commande;

public interface CommandeService {

    public Commande add(Commande commande);
    public Commande findById( Long id);
    public List<Commande> findAll();
    public void DeleteById( Long id);
    public Commande Update(Commande commande);

}
