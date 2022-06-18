package com.ms.Commande.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Commande")
public class Commande {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "montant")
    private  Double montant;

    @Column(name = "type")
    private String type;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "nomClient")
    private String nomClient;

    @Column(name = "nbAchat")
    private Integer nbAchat;

}