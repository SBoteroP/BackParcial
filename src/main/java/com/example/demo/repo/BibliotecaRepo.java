package com.example.demo.repo;

import com.example.demo.model.BibliotecaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BibliotecaRepo extends JpaRepository<BibliotecaEntity, Long> {
}
