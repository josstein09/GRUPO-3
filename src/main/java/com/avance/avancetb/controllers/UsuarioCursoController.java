package com.avance.avancetb.controllers;

import com.avance.avancetb.dtos.UsuarioCursoDTO;
import com.avance.avancetb.entities.Cursos;
import com.avance.avancetb.entities.Usuario;
import com.avance.avancetb.entities.UsuarioCurso;
import com.avance.avancetb.servicesinterfaces.IUsuarioCursoService;

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
@RequestMapping("/usuarioCurso")
public class UsuarioCursoController {
    @Autowired
    private IUsuarioCursoService ucS;

    @GetMapping
    public ResponseEntity<List<UsuarioCursoDTO>> listar() {
        ModelMapper m = new ModelMapper();
        m.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<UsuarioCursoDTO> lista = ucS.list()
                .stream().map(x -> {
                    UsuarioCursoDTO dto = m.map(x, UsuarioCursoDTO.class);
                    // EXTRACCIÓN MANUAL DE LAS 2 LLAVES FORÁNEAS
                    if (x.getCurso() != null) dto.setIdCursos(x.getCurso().getIdCursos());
                    if (x.getUsuario() != null) dto.setIdUsuario(x.getUsuario().getIdUsuario());
                    return dto;
                }).collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        m.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Optional<UsuarioCurso> usuarioCurso = ucS.listId(id);
        if (usuarioCurso.isPresent()) {
            UsuarioCursoDTO dto = m.map(usuarioCurso.get(), UsuarioCursoDTO.class);
            if (usuarioCurso.get().getCurso() != null) dto.setIdCursos(usuarioCurso.get().getCurso().getIdCursos());
            if (usuarioCurso.get().getUsuario() != null) dto.setIdUsuario(usuarioCurso.get().getUsuario().getIdUsuario());
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Registro no encontrado");
        }
    }

    @PostMapping("/nuevo")
    public ResponseEntity<UsuarioCursoDTO> registrar(@RequestBody UsuarioCursoDTO dto) {
        ModelMapper m = new ModelMapper();
        m.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UsuarioCurso uc = m.map(dto, UsuarioCurso.class);
        Cursos curso = new Cursos();
        curso.setIdCursos(dto.getIdCursos());
        uc.setCurso(curso);
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(dto.getIdUsuario());
        uc.setUsuario(usuario);
        UsuarioCurso ucR = ucS.insert(uc);
        UsuarioCursoDTO respondeDTO = m.map(ucR, UsuarioCursoDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(respondeDTO);
    }

    @PutMapping("/actualiza")
    public ResponseEntity<?> actualizar(@RequestBody UsuarioCursoDTO dto) {
        Optional<UsuarioCurso> existente = ucS.listId(dto.getIdUsuarioCurso());
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede actualizar: El registro con ID " + dto.getIdUsuarioCurso() + " no existe.");
        }
        try {
            ModelMapper m = new ModelMapper();
            m.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            UsuarioCurso uc = m.map(dto, UsuarioCurso.class);
            Cursos curso = new Cursos();
            curso.setIdCursos(dto.getIdCursos());
            uc.setCurso(curso);
            Usuario usuario = new Usuario();
            usuario.setIdUsuario(dto.getIdUsuario());
            uc.setUsuario(usuario);
            ucS.update(uc);
            return ResponseEntity.ok("Registro actualizado correctamente");
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error de integridad: Revisa que el ID del Curso y el ID del Usuario existan en la base de datos.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Optional<UsuarioCurso> usuarioCurso = ucS.listId(id);
        if (usuarioCurso.isPresent()) {
            ucS.delete(id);
            return ResponseEntity.ok("Registro eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Registro no encontrado");
        }
    }
}