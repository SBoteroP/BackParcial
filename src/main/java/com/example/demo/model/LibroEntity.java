package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "LibroSBP")  // Specify the table name
public class LibroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Autor")
    private String autor;

    @OneToOne
    @JoinColumn(name = "BibliotecaId")
    private BibliotecaEntity biblioteca;


    // constructores, getters y setters

    public LibroEntity(String nombre, String autor, BibliotecaEntity biblioteca) {
        this.nombre = nombre;
        this.autor = autor;
        this.biblioteca = biblioteca;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public BibliotecaEntity getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(BibliotecaEntity biblioteca) {
        this.biblioteca = biblioteca;
    }
}
