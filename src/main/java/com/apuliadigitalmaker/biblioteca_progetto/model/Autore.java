package com.apuliadigitalmaker.biblioteca_progetto.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "autore", schema = "bliblioteca_progetto")
public class Autore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cognome", nullable = false)
    private String cognome;

    @Column(name = "annoNascita", nullable = false)
    private Instant annoNascita;

    @Column(name = "`nazionalità`", nullable = false)
    private String nazionalità;

    @Column(name = "luogoNascita", nullable = false)
    private String luogoNascita;

    @Column(name = "morto")
    private Byte morto;

    @Column(name = "created", nullable = false)
    private Instant created;

    @Column(name = "updated", nullable = false)
    private Instant updated;

    @Column(name = "deleted", nullable = false)
    private Instant deleted;

}