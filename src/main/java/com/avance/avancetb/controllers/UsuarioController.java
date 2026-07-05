package com.avance.avancetb.controllers;

import com.avance.avancetb.dtos.UsuarioDTO;
import com.avance.avancetb.entities.Rol;
import com.avance.avancetb.entities.Usuario;
import com.avance.avancetb.servicesinterfaces.IUsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private IUsuarioService uSer;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listar(){
        ModelMapper m=new ModelMapper();
        List<UsuarioDTO> listaUsuarios=uSer.list()
                .stream().map(x->m.map(x,UsuarioDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaUsuarios);
    }

    @PostMapping("/usuario/nuevo")
    public ResponseEntity<?> registrar(@RequestBody UsuarioDTO dto) {
        try {
            ModelMapper m = new ModelMapper();
            Usuario u = m.map(dto, Usuario.class);
            Rol r = new Rol();
            r.setIdRol(dto.getIdRol());
            u.setRol(r);
            uSer.insert(u);
            return ResponseEntity.status(HttpStatus.CREATED).body(dto);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error: El idRol (" + dto.getIdRol() + ") no existe en la base de datos.");
        }
    }
    @GetMapping("/usuario/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Optional<Usuario> usuarios = uSer.listId(id);

        if (usuarios.isPresent()) {
            UsuarioDTO dto = m.map(usuarios.get(), UsuarioDTO.class);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuario no encontrado");
        }
    }

    @PutMapping("/usuario/actualiza")
    public ResponseEntity<String> actualizar(@RequestBody UsuarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Optional<Usuario> existente = uSer.listId(dto.getIdUsuario());
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuario no encontrado con ID: " + dto.getIdUsuario());
        }

        Usuario us = m.map(dto, Usuario.class);
        Rol r = new Rol();
        r.setIdRol(dto.getIdRol());
        us.setRol(r);
        uSer.update(us);

        return ResponseEntity.ok("Usuario actualizado correctamente");
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Optional<Usuario> usuarios = uSer.listId(id);

        if (usuarios.isPresent()) {
            uSer.delete(id);
            return ResponseEntity.ok("Usuario eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuario no encontrado");
        }
    }
}
