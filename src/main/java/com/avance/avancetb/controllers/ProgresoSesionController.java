package com.avance.avancetb.controllers;

import com.avance.avancetb.dtos.ProgresoSesionDTO;
import com.avance.avancetb.entities.ProgresoSesion;
import com.avance.avancetb.servicesinterfaces.IProgresoSesionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/progresoSesion")
public class ProgresoSesionController {

    @Autowired
    private IProgresoSesionService service;

    @GetMapping
    public ResponseEntity<List<ProgresoSesionDTO>> listar() {
        ModelMapper m = new ModelMapper();
        List<ProgresoSesionDTO> lista = service.list()
                .stream()
                .map(ps -> m.map(ps, ProgresoSesionDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        ProgresoSesion ps = service.listId(id);
        if (ps != null) {
            return ResponseEntity.ok(m.map(ps, ProgresoSesionDTO.class));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Progreso no encontrado con ID: " + id);
        }
    }

    @PostMapping
    public ResponseEntity<ProgresoSesionDTO> registrar(@RequestBody ProgresoSesionDTO dto) {
        ModelMapper m = new ModelMapper();
        ProgresoSesion creado = service.Create(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(m.map(creado, ProgresoSesionDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificar(@PathVariable int id, @RequestBody ProgresoSesionDTO dto) {
        ModelMapper m = new ModelMapper();
        ProgresoSesion ps = m.map(dto, ProgresoSesion.class);
        ProgresoSesion actualizado = service.Update(id, ps);

        if (actualizado != null) {
            return ResponseEntity.ok(m.map(actualizado, ProgresoSesionDTO.class));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Progreso no encontrado con ID: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable int id) {
        ProgresoSesion eliminado = service.Delete(id);
        if (eliminado != null) {
            return ResponseEntity.ok("Progreso eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Progreso no encontrado con ID: " + id);
        }
    }
}