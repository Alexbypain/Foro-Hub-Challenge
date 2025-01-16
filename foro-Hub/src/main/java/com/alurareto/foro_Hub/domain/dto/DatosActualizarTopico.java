package com.alurareto.foro_Hub.domain.dto;

import com.alurareto.foro_Hub.domain.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        Status status

) {
}
