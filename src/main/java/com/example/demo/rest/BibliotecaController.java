package com.example.demo.rest;

import com.example.demo.model.BibliotecaEntity;
import com.example.demo.service.BibliotecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bibliotecas")
public class BibliotecaController {

    @Autowired
    BibliotecaService bibliotecaService;

    @GetMapping
    public ResponseEntity<List<BibliotecaEntity>> getAllBibliotecas() {
        List<BibliotecaEntity> bibliotecas = bibliotecaService.getAllBibliotecas();
        return new ResponseEntity<>(bibliotecas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BibliotecaEntity> getBibliotecaById(@PathVariable Long id) {
        BibliotecaEntity biblioteca = bibliotecaService.getBibliotecaById(id);
        return new ResponseEntity<>(biblioteca, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BibliotecaEntity> createBiblioteca(@RequestBody BibliotecaEntity biblioteca) {
        BibliotecaEntity createdBiblioteca = bibliotecaService.createBiblioteca(biblioteca);
        return new ResponseEntity<>(createdBiblioteca, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BibliotecaEntity> updateBiblioteca(@PathVariable Long id, @RequestBody BibliotecaEntity biblioteca) {
        BibliotecaEntity updatedBiblioteca = bibliotecaService.updateBiblioteca(id, biblioteca);
        return new ResponseEntity<>(updatedBiblioteca, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBiblioteca(@PathVariable Long id) {
        bibliotecaService.deleteBiblioteca(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

