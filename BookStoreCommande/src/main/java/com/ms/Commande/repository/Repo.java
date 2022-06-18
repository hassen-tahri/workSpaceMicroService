package com.ms.Commande.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ms.Commande.entity.Commande;

@Repository
public interface Repo extends CrudRepository <Commande, Long> {

}
