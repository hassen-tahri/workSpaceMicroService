package com.ms.book.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "prix")
    private  Double prix;

    @Column(name = "statut")
    private String statut;

    @Column(name = "langue")
    private String langue;

    @Column(name = "titre")
    private String titre;

    @Column(name = "couverture")
    private String couverture;

    @Column(name = "auteurId")
    private Long auteurId;

    @Column(name = "langueOrigine")
    private String langueOrigine;

    @Column(name = "dateDeParution")
    private String dateDeParution;

    @Column(name = "lieuParution")
    private String lieuParution;

    @Column(name = "editeur")
    private String editeur;

    @Column(name = "collection")
    private String collection;

    @Column(name = "adaptation")
    private String adaptation;

    @Column(name = "sommaire")
    private String sommaire;

    @Column(name = "isbn")
    private Long isbn;

    @Column(name = "nombreDePage")
    private Integer nombreDePage;

    @Column(name = "quantiteStock")
    private Integer quantiteStock;


}

