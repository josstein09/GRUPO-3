package com.avance.avancetb.controllers;

import com.avance.avancetb.dtos.UsuarioCursoDTO;
import com.avance.avancetb.entities.UsuarioCurso;
import com.avance.avancetb.servicesinterfaces.IUsuarioCursoService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarioCurso")
public class UsuarioCursoController {

    @Autowired
    private IUsuarioCursoService US;

    @GetMapping
    public ResponseEntity<List<UsuarioCursoDTO>> listar() {

        ModelMapper m = new ModelMapper();

        List<UsuarioCursoDTO> listaUsuarioCurso = US.list()
                .stream()
                .map(usuarioCurso -> m.map(usuarioCurso, UsuarioCursoDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(listaUsuarioCurso);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {

        ModelMapper m = new ModelMapper();

        UsuarioCurso usuarioCurso = US.Listid(id);

        if (usuarioCurso != null) {

            UsuarioCursoDTO dto =
                    m.map(usuarioCurso, UsuarioCursoDTO.class);

            return ResponseEntity.ok(dto);

        } else {

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("UsuarioCurso no encontrado");
        }
    }

    @PostMapping
    public ResponseEntity<UsuarioCursoDTO> registrar(
            @RequestBody UsuarioCursoDTO dto) {

        ModelMapper m = new ModelMapper();

        UsuarioCurso creado = US.Create(dto);

        UsuarioCursoDTO responseDTO =
                m.map(creado, UsuarioCursoDTO.class);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(responseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificar(
            @PathVariable int id,
            @RequestBody UsuarioCursoDTO dto) {

        ModelMapper m = new ModelMapper();

        UsuarioCurso u =
                m.map(dto, UsuarioCurso.class);

        UsuarioCurso actualizado = US.Update(id, u);

        if (actualizado != null) {

            UsuarioCursoDTO responseDTO =
                    m.map(actualizado, UsuarioCursoDTO.class);

            return ResponseEntity.ok(responseDTO);

        } else {

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("UsuarioCurso no encontrado");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable int id) {

        UsuarioCurso eliminado = US.Delete(id);

        if (eliminado != null) {

            return ResponseEntity.ok("UsuarioCurso eliminado correctamente");

        } else {

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("UsuarioCurso no encontrado");
        }
    }
}