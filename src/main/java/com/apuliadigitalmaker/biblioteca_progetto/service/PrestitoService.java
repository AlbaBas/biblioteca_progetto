package com.apuliadigitalmaker.biblioteca_progetto.service;

import com.apuliadigitalmaker.biblioteca_progetto.model.Prestito;
import com.apuliadigitalmaker.biblioteca_progetto.repository.PrestitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class PrestitoService {

    private final PrestitoRepository prestitoRepository;

    @Autowired
    public PrestitoService(PrestitoRepository prestitoRepository) {
        this.prestitoRepository = prestitoRepository;
    }

    // Metodo per creare un nuovo prestito
    public Prestito creaPrestito(Prestito prestito) {
        prestito.setDataInizio(Instant.now()); // Imposta la data di inizio a quella corrente
        prestito.setRestituito(false);         // Indica che il libro non è ancora restituito
        return prestitoRepository.save(prestito);
    }

    // Metodo per restituire un libro
    public Prestito restituisciLibro(Long prestitoId) {
        Optional<Prestito> prestitoOpt = prestitoRepository.findById(prestitoId);
        if (prestitoOpt.isPresent()) {
            Prestito prestito = prestitoOpt.get();
            prestito.setDataFine(Instant.now()); // Imposta la data di fine a quella corrente
            prestito.setRestituito(true);        // Segna il prestito come restituito
            return prestitoRepository.save(prestito);
        }
        return null;
    }

    // Metodo per ottenere tutti i prestiti
    public List<Prestito> trovaTuttiIPrestiti() {
        return prestitoRepository.findAll();
    }

    // Metodo per eliminare un prestito
    public boolean eliminaPrestito(Long id) {
        Optional<Prestito> prestito = prestitoRepository.findById(id);
        if (prestito.isPresent()) {
            prestitoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Metodo per trovare prestiti per ID utente
    public List<Prestito> trovaPrestitiPerUtenteId(Long utenteId) {
        return prestitoRepository.findByUtenteId(utenteId);
    }

    // Metodo per trovare prestiti per ID libro
    public List<Prestito> trovaPrestitiPerLibroId(Long libroId) {
        return prestitoRepository.findByLibroId(libroId);
    }

    // Metodo per trovare i prestiti non restituiti
    public List<Prestito> trovaPrestitiNonRestituiti() {
        return prestitoRepository.findByRestituito(false);
    }
}
