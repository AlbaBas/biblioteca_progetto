package com.apuliadigitalmaker.biblioteca_progetto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
    List<Prenotazione> findByUtenteId(Long utenteId);
    List<Prenotazione> findByLibroId(Long libroId);
    List<Prenotazione> findByAttiva(boolean attiva);
}

