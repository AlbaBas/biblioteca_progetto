package com.apuliadigitalmaker.biblioteca_progetto.controller;

import com.apuliadigitalmaker.biblioteca_progetto.model.Prestito;
import com.apuliadigitalmaker.biblioteca_progetto.service.PrestitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prestiti")
public class PrestitoController {

    private final PrestitoService prestitoService;

    @Autowired
    public PrestitoController(PrestitoService prestitoService) {
        this.prestitoService = prestitoService;
    }

    @PostMapping
    public Prestito creaPrestito(@RequestBody Prestito prestito) {
        return prestitoService.creaPrestito(prestito);
    }

    @PutMapping("/{id}/restituisci")
    public Prestito restituisciLibro(@PathVariable Long id) {
        return prestitoService.restituisciLibro(id);
    }

    @GetMapping
    public List<Prestito> trovaTuttiIPrestiti() {
        return prestitoService.trovaTuttiIPrestiti();
    }
}
