package br.com.imfit.controllers;

import br.com.imfit.entities.Usuario;
import br.com.imfit.services.UsuarioService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // ADMIN
    @GetMapping
    public List<Usuario> getAllUsuario() {
        return usuarioService.findAll();
    }

    // USER | UTILIZAR 'DTO' PARA NÃO ENVIAR SENHA DO USUARIO EVITANDO BRECHA DE SEGURANÇA
    @GetMapping("/{usuarioId}")
    public Usuario getUsuario(@PathVariable int usuarioId) {
        return usuarioService.findById(usuarioId);
    }

    // ADMIN
    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody Usuario usuario) {
        System.out.println(usuario);
        usuarioService.save(usuario);
        return new ResponseEntity<>(usuario.getUsername(), HttpStatus.CREATED);
    }

}
