package com.apuliadigitalmaker.biblioteca_progetto.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "libro", schema = "bliblioteca_progetto")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "autore_id")
    private Integer autoreId;

    @Column(name = "titolo", nullable = false)
    private String titolo;

    @Column(name = "annoPubblicazione", nullable = false)
    private Integer annoPubblicazione;

    @Column(name = "genere", nullable = false)
    private String genere;

    @Column(name = "disponibili")
    private Byte disponibili;

    @Column(name = "editore", nullable = false)
    private String editore;

    @Column(name = "lingua", nullable = false)
    private String lingua;

    @Column(name = "nrPagine", nullable = false)
    private Integer nrPagine;

    @Lob
    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "prezzo")
    private Integer prezzo;

    @Column(name = "created", nullable = false)
    private Instant created;

    @Column(name = "updated", nullable = false)
    private Instant updated;

    @Column(name = "deleted", nullable = false)
    private Instant deleted;

}