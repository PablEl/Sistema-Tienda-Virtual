package com.mx.usuarioService.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mx.usuarioService.VO.UsuarioRequestVO;
import com.mx.usuarioService.VO.UsuarioResponseVO;
import com.mx.usuarioService.dao.Usuarios;
import com.mx.usuarioService.service.UsuariosAppImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;







@RestController
@RequestMapping(path = "/ApiUsuarios")
@CrossOrigin
public class UsuariosController {

    @Autowired
    private UsuariosAppImpl service;

    @GetMapping
    public ResponseEntity<Object> mostrar() {
        List<Usuarios> response = service.mostrarTodos();
        if (response == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(response);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> buscar(@PathVariable("id") Integer id) {
        UsuarioResponseVO response = service.buscar(id);
        if (response == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<Object> alta(@RequestBody UsuarioRequestVO usuario) {
        Integer response = service.alta(usuario);
        if (response instanceof Integer) return ResponseEntity.created(null).body(response);
        return ResponseEntity.unprocessableEntity().build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Object> actualizacion(@PathVariable Integer id, @RequestBody Usuarios usuario) {
        Usuarios response = service.actualizacion(id,usuario);
        if (response == null) return ResponseEntity.unprocessableEntity().build();
        return ResponseEntity.accepted().body(response);
    }
    

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
        boolean response = service.eliminacion(id);
        if (!response) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(response);
    }
}
