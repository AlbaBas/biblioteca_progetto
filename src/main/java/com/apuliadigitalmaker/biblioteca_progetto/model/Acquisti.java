package com.apuliadigitalmaker.biblioteca_progetto.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "acquisti", schema = "bliblioteca_progetto")
public class Acquisti {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "libro_id")
    private Integer libroId;

    @Column(name = "utente_id")
    private Integer utenteId;

    @Column(name = "dataAcquisto", nullable = false)
    private Instant dataAcquisto;

    @Column(name = "completato")
    private Integer completato;

    @Column(name = "prezzoTot")
    private Integer prezzoTot;

    @Column(name = "consegnato")
    private Byte consegnato;

    @Column(name = "reso")
    private Byte reso;

    @Column(name = "libriTot")
    private Integer libriTot;

    @Column(name = "created", nullable = false)
    private Instant created;

    @Column(name = "updated", nullable = false)
    private Instant updated;

    @Column(name = "deleted", nullable = false)
    private Instant deleted;

}