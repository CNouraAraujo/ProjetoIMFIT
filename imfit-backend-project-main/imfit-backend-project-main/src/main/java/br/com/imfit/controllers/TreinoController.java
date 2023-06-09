package br.com.imfit.controllers;

import br.com.imfit.entities.Treino;
import br.com.imfit.services.TreinoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/treinos")
public class TreinoController {

    private final TreinoService treinoService;

    @Autowired
    public TreinoController(TreinoService treinoService) {
        this.treinoService = treinoService;
    }

    // ADMIN
    @GetMapping
    public List<Treino> getAllTreinos() {
        return treinoService.findAllTreinos();
    }

    // USER
    @GetMapping("/{treinoId}")
    public Treino getTreino(@PathVariable int treinoId) {
        return treinoService.findById(treinoId);
    }

    // ADMIN
    @PostMapping
    public ResponseEntity<Integer> saveTreino(@RequestBody Treino treino) {
        treinoService.saveTreino(treino);
        return new ResponseEntity<>(treino.getId(), HttpStatus.CREATED);
    }

    // ADMIN
    @PutMapping("/{treinoId}/{exercicioId}")
    public Treino exerciciosEmTreino(@PathVariable int treinoId, @PathVariable int exercicioId) {
        return treinoService.exerciciosEmTreino(treinoId, exercicioId);
    }

}
