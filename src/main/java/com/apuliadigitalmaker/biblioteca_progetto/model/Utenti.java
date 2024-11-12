package com.apuliadigitalmaker.biblioteca_progetto.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "utenti", schema = "bliblioteca_progetto")
public class Utenti {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cognome", nullable = false)
    private String cognome;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "ruolo", nullable = false)
    private String ruolo;

    @Column(name = "attivo")
    private Byte attivo;

    @Column(name = "ultimaVisita", nullable = false)
    private Instant ultimaVisita;

    @Column(name = "indirizzo", nullable = false)
    private String indirizzo;

    @Column(name = "telefono", nullable = false)
    private Integer telefono;

    @Column(name = "dataIscrizione", nullable = false)
    private Instant dataIscrizione;

    @Column(name = "created", nullable = false)
    private Instant created;

    @Column(name = "updated", nullable = false)
    private Instant updated;

    @Column(name = "deleted", nullable = false)
    private Instant deleted;

    @Column(name = "is_active")
    private Boolean isActive;

}