package com.alurareto.foro_Hub.domain.repository;

import com.alurareto.foro_Hub.domain.entities.Topico;
import com.alurareto.foro_Hub.domain.enums.Status;
import io.micrometer.observation.ObservationFilter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicoRepository extends JpaRepository<Topico, Long> {


   

    boolean existsByTitulo(String titulo);


    boolean existsByMensaje(String mensaje);


    Page<Topico> findAllByStatus(Status status, Pageable paginacion);
}
