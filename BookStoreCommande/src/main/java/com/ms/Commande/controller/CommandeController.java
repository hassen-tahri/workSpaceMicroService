package com.ms.Commande.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ms.Commande.Service.CommandeService;
import com.ms.Commande.entity.Commande;

import java.util.Optional;

@RestController
public class CommandeController {

    @Autowired
    private CommandeService commandeService;


    @GetMapping("/commande/All")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(commandeService.findAll());
    }

    @PostMapping("/commande")
    public ResponseEntity<?> add(@RequestBody Commande c) {
        Optional<Commande> commande1 = Optional.of(commandeService.add(c));
        return ResponseEntity.created(null).body(commande1);
    }

    @PutMapping("/commande")
    public ResponseEntity<?> update(@RequestBody Commande commande) {

        Commande commande1 = commandeService.Update(commande);
        return ResponseEntity.accepted().body(commande1);

    }

    @DeleteMapping("/commande/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        commandeService.DeleteById(id);
        return ResponseEntity.noContent().build();
    }
}
