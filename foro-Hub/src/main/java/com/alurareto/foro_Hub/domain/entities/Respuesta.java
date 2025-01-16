package com.alurareto.foro_Hub.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name="respuestas")
@Entity(name="Respuesta")
@EqualsAndHashCode(of="id")
public class Respuesta {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="respuesta_id")
    private long id;

    private String mensaje;

    @ManyToOne
    @JoinColumn(name="topico_id")
    @JsonBackReference
    private Topico topico;
    @Column(name="fecha_creacion")
    private LocalDateTime fechaDeCreacion;

    private boolean solucion;

    @ManyToOne
    @JoinColumn(name="usuario_id")
    @JsonBackReference
    private Usuario usuario;

    public long getId() {
        return id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public Topico getTopico() {
        return topico;
    }

    public LocalDateTime getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public boolean isSolucion() {
        return solucion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Respuesta(){

    }

    public Respuesta(long id, String mensaje, Topico topico, LocalDateTime fechaDeCreacion, boolean solucion, Usuario usuario) {
        this.id = id;
        this.mensaje = mensaje;
        this.topico = topico;
        this.fechaDeCreacion = fechaDeCreacion;
        this.solucion = solucion;
        this.usuario = usuario;
    }
}
