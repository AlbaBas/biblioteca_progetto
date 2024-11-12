package com.apuliadigitalmaker.biblioteca_progetto.controller;

import com.apuliadigitalmaker.biblioteca_progetto.model.Prenotazione;
import com.apuliadigitalmaker.biblioteca_progetto.service.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/prenotazioni")
public class PrenotazioneController {

    private final PrenotazioneService prenotazioneService;

    @Autowired
    public PrenotazioneController(PrenotazioneService prenotazioneService) {
        this.prenotazioneService = prenotazioneService;
    }

    // Endpoint per ottenere tutte le prenotazioni
    @GetMapping
    public ResponseEntity<List<Prenotazione>> getAllPrenotazioni() {
        List<Prenotazione> prenotazioni = prenotazioneService.trovaTutteLePrenotazioni();
        return new ResponseEntity<>(prenotazioni, HttpStatus.OK);
    }

    // Endpoint per ottenere una prenotazione per ID
    @GetMapping("/{id}")
    public ResponseEntity<Prenotazione> getPrenotazioneById(@PathVariable Long id) {
        Optional<Prenotazione> prenotazione = prenotazioneService.trovaPrenotazionePerId(id);
        return prenotazione
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint per creare una nuova prenotazione
    @PostMapping
    public ResponseEntity<Prenotazione> createPrenotazione(@RequestBody Prenotazione prenotazione) {
        Prenotazione nuovaPrenotazione = prenotazioneService.creaPrenotazione(prenotazione);
        return new ResponseEntity<>(nuovaPrenotazione, HttpStatus.CREATED);
    }

    // Endpoint per aggiornare una prenotazione esistente
    @PutMapping("/{id}")
    public ResponseEntity<Prenotazione> updatePrenotazione(@PathVariable Long id, @RequestBody Prenotazione prenotazione) {
        Optional<Prenotazione> prenotazioneEsistente = prenotazioneService.trovaPrenotazionePerId(id);

        if (prenotazioneEsistente.isPresent()) {
            Prenotazione aggiornata = prenotazioneService.aggiornaPrenotazione(id, prenotazione);
            return new ResponseEntity<>(aggiornata, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint per eliminare una prenotazione per ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrenotazione(@PathVariable Long id) {
        if (prenotazioneService.eliminaPrenotazione(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint per trovare prenotazioni per utente ID
    @GetMapping("/utente/{utenteId}")
    public ResponseEntity<List<Prenotazione>> getPrenotazioniByUtenteId(@PathVariable Long utenteId) {
        List<Prenotazione> prenotazioni = prenotazioneService.trovaPrenotazioniPerUtenteId(utenteId);
        return new ResponseEntity<>(prenotazioni, HttpStatus.OK);
    }

    // Endpoint per trovare prenotazioni attive
    @GetMapping("/attive")
    public ResponseEntity<List<Prenotazione>> getPrenotazioniAttive() {
        List<Prenotazione> prenotazioniAttive = prenotazioneService.trovaPrenotazioniAttive();
        return new ResponseEntity<>(prenotazioniAttive, HttpStatus.OK);
    }
}
