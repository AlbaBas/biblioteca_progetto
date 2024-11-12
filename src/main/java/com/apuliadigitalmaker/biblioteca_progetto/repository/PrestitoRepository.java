package com.apuliadigitalmaker.biblioteca_progetto.repository;

import com.apuliadigitalmaker.biblioteca_progetto.model.Prestito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrestitoRepository extends JpaRepository<Prestito, Long> {
    List<Prestito> findByUtenteId(Long utenteId);
    List<Prestito> findByLibroId(Long libroId);
    List<Prestito> findByRestituito(boolean restituito);
}

