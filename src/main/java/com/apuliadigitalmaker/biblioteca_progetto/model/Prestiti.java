package com.apuliadigitalmaker.biblioteca_progetto.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "prestiti", schema = "bliblioteca_progetto")
public class Prestiti {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "utenti_id", nullable = false)
    private Integer utentiId;

    @Column(name = "libro_id", nullable = false)
    private Integer libroId;

    @Column(name = "data_inizio")
    private Instant dataInizio;

    @Column(name = "data_fine")
    private Instant dataFine;

    @Column(name = "restituito")
    private Byte restituito;

    @Column(name = "created")
    private Instant created;

    @Column(name = "updateted")
    private Instant updateted;

    @Column(name = "deleted")
    private Instant deleted;

    @Column(name = "utente_id", nullable = false)
    private Long utenteId;

}