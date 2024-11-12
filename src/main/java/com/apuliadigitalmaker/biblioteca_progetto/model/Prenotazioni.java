package com.apuliadigitalmaker.biblioteca_progetto.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "prenotazioni", schema = "bliblioteca_progetto")
public class Prenotazioni {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "utenti_id", nullable = false)
    private Integer utentiId;

    @Column(name = "libro_id", nullable = false)
    private Long libroId;

    @Column(name = "data_preonatzione")
    private Instant dataPreonatzione;

    @Column(name = "attiva", nullable = false)
    private Boolean attiva = false;

    @Column(name = "created")
    private Instant created;

    @Column(name = "updated")
    private Instant updated;

    @Column(name = "deletd")
    private Instant deletd;

    @Column(name = "utente_id", nullable = false)
    private Long utenteId;

}