package com.alurareto.foro_Hub.domain.dto;

import com.alurareto.foro_Hub.domain.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        Status status,
        @NotNull
        Long usuario_id,
        @NotBlank
        String nombreCurso

) {
}
