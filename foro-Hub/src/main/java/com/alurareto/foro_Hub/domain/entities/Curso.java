package com.alurareto.foro_Hub.domain.entities;

import com.alurareto.foro_Hub.domain.enums.Categoria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name="cursos")
@Entity(name="Curso")
@Getter
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="curso_id")
    private Long id;

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    private String nombre;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public Curso(Long id, String nombre, Categoria categoria) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
    }

    public Curso(){

    }
}
