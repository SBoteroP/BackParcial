package com.example.demo.service;

import com.example.demo.model.BibliotecaEntity;
import com.example.demo.repo.BibliotecaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BibliotecaService {

    @Autowired
    BibliotecaRepo bibliotecaRepo;

    public List<BibliotecaEntity> getAllBibliotecas() {
        return bibliotecaRepo.findAll();
    }

    public BibliotecaEntity getBibliotecaById(Long id) {
        Optional<BibliotecaEntity> optionalBiblioteca = bibliotecaRepo.findById(id);
        return optionalBiblioteca.orElse(null);
    }

    public BibliotecaEntity createBiblioteca(BibliotecaEntity biblioteca) {
        return bibliotecaRepo.save(biblioteca);
    }

    public BibliotecaEntity updateBiblioteca(Long id, BibliotecaEntity biblioteca) {
        if (bibliotecaRepo.existsById(id)) {
            biblioteca.setId(id);
            return bibliotecaRepo.save(biblioteca);
        }
        return null;
    }

    public void deleteBiblioteca(Long id) {
        bibliotecaRepo.deleteById(id);
    }
}
