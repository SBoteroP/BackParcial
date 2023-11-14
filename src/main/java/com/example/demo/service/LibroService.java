package com.example.demo.service;

import com.example.demo.model.LibroEntity;
import com.example.demo.repo.LibroRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    @Autowired
    LibroRepo libroRepo;


    public List<LibroEntity> getAllLibros() {
        return libroRepo.findAll();
    }

    public LibroEntity getLibroById(Long id) {
        Optional<LibroEntity> optionalLibro = libroRepo.findById(id);
        return optionalLibro.orElse(null);
    }

    public LibroEntity createLibro(LibroEntity libro) {
        return libroRepo.save(libro);
    }

    public LibroEntity updateLibro(Long id, LibroEntity libro) {
        if (libroRepo.existsById(id)) {
            libro.setId(id);
            return libroRepo.save(libro);
        }
        return null;
    }

    public void deleteLibro(Long id) {
        libroRepo.deleteById(id);
    }
}
