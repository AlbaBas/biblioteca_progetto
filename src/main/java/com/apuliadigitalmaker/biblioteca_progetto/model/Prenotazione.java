package com.apuliadigitalmaker.biblioteca_progetto.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.Instant;

@Entity
@Table(name = "prenotazioni", schema = "biblioteca_progetto")
@Data
public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "utente_id", nullable = false)
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "libro_id", nullable = false)
    private Libro libro;

    @Column(name = "data_prenotazione", nullable = false)
    private Instant dataPrenotazione;

    @Column(name = "attiva", nullable = false)
    private boolean attiva;
}
