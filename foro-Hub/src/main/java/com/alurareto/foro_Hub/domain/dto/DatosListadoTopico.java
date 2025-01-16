package com.alurareto.foro_Hub.domain.dto;

import com.alurareto.foro_Hub.domain.entities.Topico;

public record DatosListadoTopico(
        Long id,
        String titulo,
        String mensaje,
        String fechaCreacion) {

    public DatosListadoTopico(Topico topico) {
        this(topico.getId(),topico.getTitulo(), topico.getMensaje(), String.valueOf(topico.getFechaDeCreacion()));

    }
}
