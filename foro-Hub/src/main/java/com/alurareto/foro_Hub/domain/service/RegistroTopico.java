package com.alurareto.foro_Hub.domain.service;


import com.alurareto.foro_Hub.domain.ValidacionException;
import com.alurareto.foro_Hub.domain.dto.DatosActualizarTopico;
import com.alurareto.foro_Hub.domain.dto.DatosRegistroTopico;
import com.alurareto.foro_Hub.domain.dto.DatosRespuestaTopico;
import com.alurareto.foro_Hub.domain.dto.DatosRespuestaTopicoActualizado;
import com.alurareto.foro_Hub.domain.entities.Curso;
import com.alurareto.foro_Hub.domain.entities.Topico;
import com.alurareto.foro_Hub.domain.entities.Usuario;
import com.alurareto.foro_Hub.domain.repository.CursoRepository;
import com.alurareto.foro_Hub.domain.repository.TopicoRepository;
import com.alurareto.foro_Hub.domain.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RegistroTopico {
    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public DatosRespuestaTopico regitrar(DatosRegistroTopico datos){

        if(!usuarioRepository.existsById(datos.usuario_id())){
            throw new ValidacionException("No existe un usuario con el id informado");
        }

        if(topicoRepository.existsByTitulo(datos.titulo())){
            throw new ValidacionException("Ya existe un topico con ese titulo");
        }

        if(topicoRepository.existsByMensaje(datos.mensaje())){
            throw new ValidacionException("Ya existe un topico con ese mensaje");
        }

        if(!cursoRepository.existsByNombre(datos.nombreCurso())){
            throw new ValidacionException("No existe un curso con el nombre informado");
        }

        Usuario usuario=usuarioRepository.findById(datos.usuario_id()).get();
        Curso curso=cursoRepository.findByNombre(datos.nombreCurso()).get();


        Topico topico=new Topico(null,datos.titulo(),datos.mensaje(), LocalDateTime.now(),datos.status(),usuario,curso,null);

        topicoRepository.save(topico);
        return new DatosRespuestaTopico(topico);





    }

    public DatosRespuestaTopicoActualizado actualizar(DatosActualizarTopico datos, Long id) {
        if(!topicoRepository.existsById(id)){
            throw new ValidacionException("No existe un topico con el id informado");
        }

        var topico = topicoRepository.getReferenceById(id);
        topico.actualizarInformaciones(datos);

        return new DatosRespuestaTopicoActualizado(topico);





    }

    public void eliminar(Long id) {
        if(!topicoRepository.existsById(id)){
            throw new ValidacionException("No existe un topico con el id informado");
        }
        topicoRepository.deleteById(id);
    }
}
