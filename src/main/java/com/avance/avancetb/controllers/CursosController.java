package com.avance.avancetb.controllers;

import com.avance.avancetb.dtos.CursosDTO;
import com.avance.avancetb.dtos.ReporteAgrupadoDTO;
import com.avance.avancetb.entities.Cursos;
import com.avance.avancetb.entities.PerfilProfesional;
import com.avance.avancetb.servicesinterfaces.ICursosService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cursos")
public class CursosController {
    @Autowired
    private ICursosService curS;

    @GetMapping
    public ResponseEntity<List<CursosDTO>> listar(){
        ModelMapper m=new ModelMapper();
        List<CursosDTO> listaCursos=curS.list()
                .stream().map(x->m.map(x,CursosDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaCursos);
    }

    @PostMapping("/nuevo")
    public ResponseEntity<CursosDTO> registrar(@RequestBody CursosDTO dto){
        ModelMapper m=new ModelMapper();
        Cursos c=m.map(dto,Cursos.class);
        Cursos cR=curS.insert(c);
        CursosDTO respondeDTO=m.map(cR,CursosDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(respondeDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Optional<Cursos> curso = curS.listId(id);

        if (curso.isPresent()) {
            CursosDTO dto = m.map(curso.get(), CursosDTO.class);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Curso no encontrado");
        }
    }

    @PutMapping("/actualiza")
    public ResponseEntity<?> actualizar(@RequestBody CursosDTO dto) {
        Optional<Cursos> existente = curS.listId(dto.getIdCursos());
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede actualizar: El curso con ID " + dto.getIdCursos() + " no existe.");
        }
        try {
            ModelMapper m = new ModelMapper();
            Cursos c = m.map(dto, Cursos.class);
            PerfilProfesional perfil = new PerfilProfesional();
            perfil.setIdPerfilProfesional(dto.getIdPerfilProfesional());
            c.setPerfilProfesional(perfil);
            curS.update(c);
            return ResponseEntity.ok("Curso actualizado correctamente");
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error de integridad: El Perfil Profesional con ID " + dto.getIdPerfilProfesional() + " no existe.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Optional<Cursos> curso = curS.listId(id);

        if (curso.isPresent()) {
            curS.delete(id);
            return ResponseEntity.ok("curso eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("curso no encontrado");
        }
    }

    @GetMapping("/reporte-tipos")
    public ResponseEntity<?> reporteCursosPorTipo() {
        List<Object[]> lista = curS.reporteCursosPorTipo();
        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No hay cursos registrados para generar el reporte.");
        }
        List<ReporteAgrupadoDTO> respuesta = new ArrayList<>();
        for (Object[] fila : lista) {
            ReporteAgrupadoDTO dto = new ReporteAgrupadoDTO();
            dto.setCategoria((String) fila[0]); // El nombre del tipo de curso
            dto.setCantidad(((Number) fila[1]).intValue()); // El conteo seguro
            respuesta.add(dto);
        }
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/reporte-aporte-especialidad")
    public ResponseEntity<?> reporteCursosPorEspecialidad() {
        List<Object[]> lista = curS.reporteCursosPorEspecialidad();
        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No hay suficientes datos para generar el reporte de aportes por especialidad.");
        }
        List<ReporteAgrupadoDTO> respuesta = new ArrayList<>();
        for (Object[] fila : lista) {
            ReporteAgrupadoDTO dto = new ReporteAgrupadoDTO();
            dto.setCategoria((String) fila[0]); // El nombre de la especialidad
            dto.setCantidad(((Number) fila[1]).intValue()); // El conteo de cursos
            respuesta.add(dto);
        }
        return ResponseEntity.ok(respuesta);
    }
}
