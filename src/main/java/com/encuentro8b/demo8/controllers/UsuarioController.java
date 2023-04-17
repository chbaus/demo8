/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.encuentro8b.demo8.controllers;

import com.encuentro8b.demo8.models.Usuario;
import com.encuentro8b.demo8.services.IUsuarioService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<?> traerUsuarios() {
        return ResponseEntity.ok(usuarioService.getUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> traerUsuarioId(@PathVariable Long id) {

        Optional<Usuario> oUsuario = usuarioService.getUser(id);
        if (oUsuario.isPresent()) {
            return ResponseEntity.ok(oUsuario);
        }
        return ResponseEntity.notFound().build();

    }

    @PostMapping
    public ResponseEntity<?> postUsuario(@RequestBody Usuario user) {

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.addUser(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable Long id) {
        Optional<Usuario> oUsuario = usuarioService.getUser(id);
        if (oUsuario.isPresent()) {
            usuarioService.deleteUser(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.notFound().build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificarUsuario(@PathVariable Long id, @RequestBody Usuario user) {

        Optional<Usuario> oUsuario = usuarioService.getUser(id);
        if (oUsuario.isPresent()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(usuarioService.addUser(user));
        }
        return ResponseEntity.notFound().build();

    }

}
