package com.avance.avancetb.controllers;

import com.avance.avancetb.dtos.ValoracionCursoDTO;
import com.avance.avancetb.entities.ValoracionCurso;
import com.avance.avancetb.servicesinterfaces.IValoracionCursoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/valoracionCurso")
public class ValoracionCursoController {

    @Autowired
    private IValoracionCursoService service;


    @GetMapping
    public ResponseEntity<List<ValoracionCursoDTO>> listar() {
        ModelMapper m = new ModelMapper();
        List<ValoracionCursoDTO> lista = service.list()
                .stream()
                .map(vc -> m.map(vc, ValoracionCursoDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        ValoracionCurso vc = service.listId(id);
        if (vc != null) {
            return ResponseEntity.ok(m.map(vc, ValoracionCursoDTO.class));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Valoracion no encontrada con ID: " + id);
        }
    }

    @PostMapping
    public ResponseEntity<ValoracionCursoDTO> registrar(@RequestBody ValoracionCursoDTO dto) {
        ModelMapper m = new ModelMapper();
        ValoracionCurso creada = service.Create(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(m.map(creada, ValoracionCursoDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificar(@PathVariable int id, @RequestBody ValoracionCursoDTO dto) {
        ModelMapper m = new ModelMapper();
        ValoracionCurso vc = m.map(dto, ValoracionCurso.class);
        ValoracionCurso actualizada = service.Update(id, vc);
        if (actualizada != null) {
            return ResponseEntity.ok(m.map(actualizada, ValoracionCursoDTO.class));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Valoracion no encontrada con ID: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable int id) {
        ValoracionCurso eliminada = service.Delete(id);
        if (eliminada != null) {
            return ResponseEntity.ok("Valoracion eliminada correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Valoracion no encontrada con ID: " + id);
        }
    }
}