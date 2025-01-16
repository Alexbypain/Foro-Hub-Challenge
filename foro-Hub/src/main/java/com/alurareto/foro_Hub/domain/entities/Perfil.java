package com.alurareto.foro_Hub.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;

@Table(name="perfiles")
@Entity(name="Perfil")
@EqualsAndHashCode(of="id")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="perfil_id")
    private long id;
    private String nombre;


    @ManyToMany
    @JoinTable(
            name="usuarios_perfil",
            joinColumns = @JoinColumn(name="usuario_id"),
            inverseJoinColumns = @JoinColumn(name="perfil_id")
    )
    @JsonBackReference
    private List<Usuario> usuarios;

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public Perfil(long id, String nombre, List<Usuario> usuarios) {
        this.id = id;
        this.nombre = nombre;
        this.usuarios = usuarios;
    }

    public Perfil(){

    }
}
