package com.alurareto.foro_Hub.controller;

import com.alurareto.foro_Hub.domain.dto.DatosAutenticacionUsuario;
import com.alurareto.foro_Hub.domain.dto.DatosListadoTopico;
import com.alurareto.foro_Hub.domain.entities.Usuario;
import com.alurareto.foro_Hub.domain.enums.Status;
import com.alurareto.foro_Hub.domain.repository.TopicoRepository;
import com.alurareto.foro_Hub.infra.security.DatosJWTToken;
import com.alurareto.foro_Hub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import static com.alurareto.foro_Hub.domain.enums.Status.ACTIVE;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;



    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosAutenticacionUsuario datosAutenticacionUsuario) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.email(),
                datosAutenticacionUsuario.password());
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosJWTToken(JWTtoken));
    }








}
