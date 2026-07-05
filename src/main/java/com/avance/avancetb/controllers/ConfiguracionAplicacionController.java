package com.avance.avancetb.controllers;
import com.avance.avancetb.dtos.ConfiguracionAplicacionDTO;
import com.avance.avancetb.entities.ConfiguracionAplicacion;
import com.avance.avancetb.entities.Usuario;
import com.avance.avancetb.servicesinterfaces.IConfiguracionAplicacionService;
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
@RequestMapping("/configuracion")
public class ConfiguracionAplicacionController {
    @Autowired
    private IConfiguracionAplicacionService cas;

    @GetMapping
    public ResponseEntity<List<ConfiguracionAplicacionDTO>> listar(){
        ModelMapper m=new ModelMapper();
        List<ConfiguracionAplicacionDTO> listaPerfilesProfesionales=cas.list()
                .stream().map(x->m.map(x,ConfiguracionAplicacionDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaPerfilesProfesionales);
    }

    @PostMapping("/nuevo")
    public ResponseEntity<?> registrar(@RequestBody ConfiguracionAplicacionDTO dto) {
        try {
            ModelMapper m = new ModelMapper();
            ConfiguracionAplicacion c = m.map(dto, ConfiguracionAplicacion.class);
            ConfiguracionAplicacion cA = cas.insert(c);
            ConfiguracionAplicacionDTO respondeDTO = m.map(cA, ConfiguracionAplicacionDTO.class);
            return ResponseEntity.status(HttpStatus.CREATED).body(respondeDTO);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error: El usuario con ID " + dto.getIdUsuario() + " no existe en la base de datos o ya tiene una configuración asignada.");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Optional<ConfiguracionAplicacion> conf = cas.listId(id);

        if (conf.isPresent()) {
            ConfiguracionAplicacionDTO dto = m.map(conf.get(), ConfiguracionAplicacionDTO.class);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Configuracion no encontrada");
        }
    }

    @PutMapping("/actualiza")
    public ResponseEntity<?> actualizar(@RequestBody ConfiguracionAplicacionDTO dto) {
        Optional<ConfiguracionAplicacion> existente = cas.listId(dto.getIdConfigAcces());
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede actualizar: La configuración con ID " + dto.getIdConfigAcces() + " no existe.");
        }
        try {
            ModelMapper m = new ModelMapper();
            ConfiguracionAplicacion c = m.map(dto, ConfiguracionAplicacion.class);
            Usuario u = new Usuario();
            u.setIdUsuario(dto.getIdUsuario());
            c.setUsuario(u);
            cas.update(c);
            return ResponseEntity.ok("Configuración actualizada correctamente");
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error de integridad: El usuario con ID " + dto.getIdUsuario() + " no existe o ya tiene otra configuración asignada.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Optional<ConfiguracionAplicacion> config = cas.listId(id);

        if (config.isPresent()) {
            cas.delete(id);
            return ResponseEntity.ok("Configuración eliminada correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Configuración no encontrada");
        }
    }
}
