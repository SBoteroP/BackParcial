package com.example.demo.rest;

import com.example.demo.model.LibroEntity;
import com.example.demo.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    private final LibroService libroService;

    @Autowired
    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping
    public ResponseEntity<List<LibroEntity>> getAllLibros() {
        List<LibroEntity> libros = libroService.getAllLibros();
        return new ResponseEntity<>(libros, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibroEntity> getLibroById(@PathVariable Long id) {
        LibroEntity libro = libroService.getLibroById(id);
        return new ResponseEntity<>(libro, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LibroEntity> createLibro(@RequestBody LibroEntity libro) {
        LibroEntity createdLibro = libroService.createLibro(libro);
        return new ResponseEntity<>(createdLibro, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LibroEntity> updateLibro(@PathVariable Long id, @RequestBody LibroEntity libro) {
        LibroEntity updatedLibro = libroService.updateLibro(id, libro);
        return new ResponseEntity<>(updatedLibro, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibro(@PathVariable Long id) {
        libroService.deleteLibro(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

