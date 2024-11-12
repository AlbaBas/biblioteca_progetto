package com.apuliadigitalmaker.biblioteca_progetto.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "libri", schema = "bliblioteca_progetto")
public class Libri {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "anno_pubblicazione", nullable = false)
    private Integer annoPubblicazione;

    @ColumnDefault("current_timestamp(6)")
    @Column(name = "created")
    private Instant created;

    @Column(name = "deleted")
    private Instant deleted;

    @Column(name = "disponibile")
    private Boolean disponibile;

    @Column(name = "genere", nullable = false)
    private String genere;

    @Column(name = "titolo", nullable = false)
    private String titolo;

    @ColumnDefault("current_timestamp(6)")
    @Column(name = "updated")
    private Instant updated;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "autore_id", nullable = false)
    private com.apuliadigitalmaker.biblioteca_progetto.Autori autore;

}