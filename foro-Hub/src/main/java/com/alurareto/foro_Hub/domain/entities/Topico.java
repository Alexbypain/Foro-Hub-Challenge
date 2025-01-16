package com.alurareto.foro_Hub.domain.entities;


import com.alurareto.foro_Hub.domain.dto.DatosActualizarTopico;
import com.alurareto.foro_Hub.domain.dto.DatosRegistroTopico;
import com.alurareto.foro_Hub.domain.enums.Status;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Table(name="topicos")
@Entity(name="Topico")
@EqualsAndHashCode(of="id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="topico_id")
    private Long id;

    private String titulo;
    private String mensaje;
    @Column(name="fecha_creacion")
    private LocalDateTime fechaDeCreacion;
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="usuario_id")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="curso_id")
    private Curso curso;

    @OneToMany(mappedBy = "topico",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Respuesta> respuestas;

    public Topico(Long id, String titulo, String mensaje, LocalDateTime fechaDeCreacion, Status status, Usuario usuario, Curso curso, List<Respuesta> respuestas) {
        this.id = id;
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fechaDeCreacion = fechaDeCreacion;
        this.status = status;
        this.usuario = usuario;
        this.curso = curso;
        this.respuestas = respuestas;
    }
    public Topico(){

    }

    public long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public LocalDateTime getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public Status getStatus() {
        return status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Curso getCurso() {
        return curso;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }


    public void actualizarInformaciones(DatosActualizarTopico datos) {
        this.mensaje=datos.mensaje();
        this.titulo=datos.titulo();
        this.status=datos.status();
        this.fechaDeCreacion=LocalDateTime.now();
    }
}
