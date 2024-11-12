package com.apuliadigitalmaker.biblioteca_progetto.service;

import com.apuliadigitalmaker.biblioteca_progetto.model.Prenotazione;
import com.apuliadigitalmaker.biblioteca_progetto.repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrenotazioneService {

    private final PrenotazioneRepository prenotazioneRepository;

    @Autowired
    public PrenotazioneService(PrenotazioneRepository prenotazioneRepository) {
        this.prenotazioneRepository = prenotazioneRepository;
    }

    // Metodo per ottenere tutte le prenotazioni
    public List<Prenotazione> trovaTutteLePrenotazioni() {
        return prenotazioneRepository.findAll();
    }

    // Metodo per trovare una prenotazione per ID
    public Optional<Prenotazione> trovaPrenotazionePerId(Long id) {
        return prenotazioneRepository.findById(id);
    }

    // Metodo per creare una nuova prenotazione
    public Prenotazione creaPrenotazione(Prenotazione prenotazione) {
        prenotazione.setAttiva(true); // Assumiamo che la prenotazione sia attiva all'inizio
        return prenotazioneRepository.save(prenotazione);
    }

    // Metodo per aggiornare una prenotazione esistente
    public Prenotazione aggiornaPrenotazione(Long id, Prenotazione prenotazione) {
        Optional<Prenotazione> prenotazioneEsistente = prenotazioneRepository.findById(id);
        if (prenotazioneEsistente.isPresent()) {
            Prenotazione aggiornata = prenotazioneEsistente.get();
            aggiornata.setLibro(prenotazione.getLibro());
            aggiornata.setUtente(prenotazione.getUtente());
            aggiornata.setDataPrenotazione(prenotazione.getDataPrenotazione());
            aggiornata.setAttiva(prenotazione.isAttiva());
            return prenotazioneRepository.save(aggiornata);
        }
        return null;
    }

    // Metodo per eliminare una prenotazione
    public boolean eliminaPrenotazione(Long id) {
        Optional<Prenotazione> prenotazione = prenotazioneRepository.findById(id);
        if (prenotazione.isPresent()) {
            prenotazioneRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Metodo per trovare prenotazioni per ID utente
    public List<Prenotazione> trovaPrenotazioniPerUtenteId(Long utenteId) {
        return prenotazioneRepository.findByUtenteId(utenteId);
    }

    // Metodo per trovare prenotazioni per ID libro
    public List<Prenotazione> trovaPrenotazioniPerLibroId(Long libroId) {
        return prenotazioneRepository.findByLibroId(libroId);
    }

    // Metodo per trovare prenotazioni attive
    public List<Prenotazione> trovaPrenotazioniAttive() {
        return prenotazioneRepository.findByAttiva(true);
    }
}

