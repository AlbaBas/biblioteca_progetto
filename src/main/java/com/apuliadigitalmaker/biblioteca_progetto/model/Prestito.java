package com.apuliadigitalmaker.biblioteca_progetto.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.Instant;

@Entity
@Table(name = "prestiti", schema = "biblioteca_progetto")
@Data
public class Prestito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "utente_id", nullable = false)
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "libro_id", nullable = false)
    private Libro libro;

    @Column(name = "data_inizio", nullable = false)
    private Instant dataInizio;

    @Column(name = "data_fine")
    private Instant dataFine;

    @Column(name = "restituito", nullable = false)
    private boolean restituito;
}
