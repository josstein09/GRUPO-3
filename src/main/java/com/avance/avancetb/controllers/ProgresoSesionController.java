package com.avance.avancetb.controllers;

import com.avance.avancetb.dtos.ProgresoSesionDTO;
import com.avance.avancetb.entities.ProgresoSesion;
import com.avance.avancetb.entities.Sesion;
import com.avance.avancetb.entities.UsuarioCurso;
import com.avance.avancetb.servicesinterfaces.IProgresoSesionService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/progresoSesion")
public class ProgresoSesionController {
    @Autowired
    private IProgresoSesionService proS;

    @GetMapping
    public ResponseEntity<List<ProgresoSesionDTO>> listar() {
        ModelMapper m = new ModelMapper();
        m.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<ProgresoSesionDTO> lista = proS.list()
                .stream().map(x -> {
                    ProgresoSesionDTO dto = m.map(x, ProgresoSesionDTO.class);
                    // EXTRACCIÓN MANUAL DE LAS 2 LLAVES FORÁNEAS
                    if (x.getSesion() != null) dto.setIdSesion(x.getSesion().getID_Sesion());
                    if (x.getUsuarioCurso() != null) dto.setIdUsuarioCurso(x.getUsuarioCurso().getIdUsuarioCurso());
                    return dto;
                }).collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        m.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Optional<ProgresoSesion> progreso = proS.listId(id);
        if (progreso.isPresent()) {
            ProgresoSesionDTO dto = m.map(progreso.get(), ProgresoSesionDTO.class);
            if (progreso.get().getSesion() != null) dto.setIdSesion(progreso.get().getSesion().getID_Sesion());
            if (progreso.get().getUsuarioCurso() != null) dto.setIdUsuarioCurso(progreso.get().getUsuarioCurso().getIdUsuarioCurso());
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Progreso no encontrado");
        }
    }

    @PostMapping("/nuevo")
    public ResponseEntity<ProgresoSesionDTO> registrar(@RequestBody ProgresoSesionDTO dto) {
        ModelMapper m = new ModelMapper();
        m.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        ProgresoSesion ps = m.map(dto, ProgresoSesion.class);
        Sesion sesion = new Sesion();
        sesion.setID_Sesion(dto.getIdSesion());
        ps.setSesion(sesion);
        UsuarioCurso uc = new UsuarioCurso();
        uc.setIdUsuarioCurso(dto.getIdUsuarioCurso());
        ps.setUsuarioCurso(uc);
        ProgresoSesion psR = proS.insert(ps);
        ProgresoSesionDTO respondeDTO = m.map(psR, ProgresoSesionDTO.class);
        if (psR.getSesion() != null) respondeDTO.setIdSesion(psR.getSesion().getID_Sesion());
        if (psR.getUsuarioCurso() != null) respondeDTO.setIdUsuarioCurso(psR.getUsuarioCurso().getIdUsuarioCurso());

        return ResponseEntity.status(HttpStatus.CREATED).body(respondeDTO);
    }

    @PutMapping("/actualiza")
    public ResponseEntity<?> actualizar(@RequestBody ProgresoSesionDTO dto) {
        Optional<ProgresoSesion> existente = proS.listId(dto.getIdProgresoSesion());
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede actualizar: El registro con ID " + dto.getIdProgresoSesion() + " no existe.");
        }
        try {
            ModelMapper m = new ModelMapper();
            m.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            ProgresoSesion ps = m.map(dto, ProgresoSesion.class);
            Sesion sesion = new Sesion();
            sesion.setID_Sesion(dto.getIdSesion());
            ps.setSesion(sesion);
            UsuarioCurso uc = new UsuarioCurso();
            uc.setIdUsuarioCurso(dto.getIdUsuarioCurso());
            ps.setUsuarioCurso(uc);
            proS.update(ps);
            return ResponseEntity.ok("Progreso actualizado correctamente");
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error de integridad: Revisa que el ID de la Sesión y el ID de UsuarioCurso existan en la base de datos.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Optional<ProgresoSesion> progreso = proS.listId(id);
        if (progreso.isPresent()) {
            proS.delete(id);
            return ResponseEntity.ok("Progreso eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Progreso no encontrado");
        }
    }
}