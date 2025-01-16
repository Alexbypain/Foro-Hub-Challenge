package com.alurareto.foro_Hub.domain.dto;

import com.alurareto.foro_Hub.domain.entities.Topico;

public record DatosRespuestaTopicoActualizado(
    Long id,
    String titulo,
    String mensaje,
    String fechaCreacion,
    String Status) {
    public DatosRespuestaTopicoActualizado(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), String.valueOf(topico.getFechaDeCreacion()),String.valueOf(topico.getStatus()));

    }


}
