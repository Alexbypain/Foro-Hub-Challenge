package com.alurareto.foro_Hub.domain.dto;

import com.alurareto.foro_Hub.domain.entities.Topico;

public record DatosRespuestaTopico(
        Long id,
        String titulo,
        String mensaje,
        String fechaCreacion,
        String nombreUsuario,
        String nombreCurso) {

    public DatosRespuestaTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), String.valueOf(topico.getFechaDeCreacion()),topico.getUsuario().getNombre(),topico.getCurso().getNombre());
    }
}
