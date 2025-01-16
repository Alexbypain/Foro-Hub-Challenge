package com.alurareto.foro_Hub.domain.repository;

import com.alurareto.foro_Hub.domain.entities.Curso;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    boolean existsByNombre(String nombre);

    Optional<Curso> findByNombre(@NotBlank String s);
}
