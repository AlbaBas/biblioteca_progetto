package com.apuliadigitalmaker.biblioteca_progetto.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "autori", schema = "bliblioteca_progetto")
public class Autori {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "anno_nascita", nullable = false)
    private Integer annoNascita;

    @Column(name = "cognome", nullable = false)
    private String cognome;

    @ColumnDefault("current_timestamp(6)")
    @Column(name = "created")
    private Instant created;

    @Column(name = "deleted")
    private Instant deleted;

    @Column(name = "nome", nullable = false)
    private String nome;

    @ColumnDefault("current_timestamp(6)")
    @Column(name = "updated")
    private Instant updated;

    @OneToMany(mappedBy = "autore")
    private Set<com.apuliadigitalmaker.biblioteca_progetto.Libri> libris = new LinkedHashSet<>();

}