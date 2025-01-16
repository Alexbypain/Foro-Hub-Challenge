package com.alurareto.foro_Hub.controller;

import com.alurareto.foro_Hub.domain.ValidacionException;
import com.alurareto.foro_Hub.domain.dto.*;
import com.alurareto.foro_Hub.domain.entities.Curso;
import com.alurareto.foro_Hub.domain.entities.Topico;
import com.alurareto.foro_Hub.domain.repository.CursoRepository;
import com.alurareto.foro_Hub.domain.repository.TopicoRepository;
import com.alurareto.foro_Hub.domain.service.RegistroTopico;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import static com.alurareto.foro_Hub.domain.enums.Status.ACTIVE;

@RestController
@RequestMapping("topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    @Autowired
    private RegistroTopico registroTopico;

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity reserver(@RequestBody @Valid DatosRegistroTopico datos){

        var detalleTopico=registroTopico.regitrar(datos);

        return ResponseEntity.ok(detalleTopico);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listadoMedicos(@PageableDefault(size = 2) Pageable paginacion) {
//        return medicoRepository.findAll(paginacion).map(DatosListadoMedico::new);
        return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(DatosListadoTopico::new));
    // return ResponseEntity.ok(topicoRepository.findAllByStatus(ACTIVE,paginacion).map(DatosListadoTopico::new));
    }


    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> retornaDatosMedico(@PathVariable Long id) {
        if(!topicoRepository.existsById(id)) {
            throw new ValidacionException("Este usuario no existe");
        }
        Topico topico = topicoRepository.getReferenceById(id);
        var datosTopico = new DatosRespuestaTopico(topico);
        return ResponseEntity.ok(datosTopico);
    }


    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DatosRespuestaTopicoActualizado> actualizar(@RequestBody @Valid DatosActualizarTopico datos, @PathVariable Long id) {
       var detalleTopico=registroTopico.actualizar(datos,id);
        return ResponseEntity.ok(detalleTopico);
    }

    @DeleteMapping("/{id}")
    @org.springframework.transaction.annotation.Transactional
    public ResponseEntity eliminar(@PathVariable Long id) {
        registroTopico.eliminar(id);
        return ResponseEntity.ok("usuario eliminado");
    }








}
