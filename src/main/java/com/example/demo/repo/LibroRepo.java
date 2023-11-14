package com.example.demo.repo;

import com.example.demo.model.LibroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepo extends JpaRepository<LibroEntity, Long> {
}
