package com.avance.avancetb.controllers;

import com.avance.avancetb.dtos.BusquedaPerfilDTO;
import com.avance.avancetb.dtos.PacienteOCursoDTOQuery;
import com.avance.avancetb.dtos.PerfilProfesionalDTO;
import com.avance.avancetb.dtos.ReporteAgrupadoDTO;
import com.avance.avancetb.entities.PerfilProfesional;
import com.avance.avancetb.servicesinterfaces.IPerfilProfesionalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/perfilProfesional")
public class PerfilProfesionalController {
    @Autowired
    private IPerfilProfesionalService pSer;

    @GetMapping
    public ResponseEntity<List<PerfilProfesionalDTO>> listar(){
        ModelMapper m=new ModelMapper();
        List<PerfilProfesionalDTO> listaPerfilesProfesionales=pSer.list()
                .stream().map(x->m.map(x,PerfilProfesionalDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaPerfilesProfesionales);
    }

    @PostMapping("/nuevo")
    public ResponseEntity<PerfilProfesionalDTO> registrar(@RequestBody PerfilProfesionalDTO dto){
        ModelMapper m=new ModelMapper();
        PerfilProfesional p=m.map(dto,PerfilProfesional.class);
        PerfilProfesional pP=pSer.insert(p);
        PerfilProfesionalDTO respondeDTO=m.map(pP,PerfilProfesionalDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(respondeDTO);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Optional<PerfilProfesional> perfil = pSer.listId(id);

        if (perfil.isPresent()) {
            PerfilProfesionalDTO dto = m.map(perfil.get(), PerfilProfesionalDTO.class);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Perfil no encontrada");
        }
    }
    @PutMapping("/actualiza")
    public ResponseEntity<String> actualizar(@RequestBody PerfilProfesionalDTO dto) {
        Optional<PerfilProfesional> existente = pSer.listId(dto.getIdPerfilProfesional());
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("perfil no encontrado");
        }
        PerfilProfesional pPer = existente.get();
        pPer.setEspecialidad(dto.getEspecialidad());
        pPer.setBiografia(dto.getBiografia());
        pSer.update(pPer);
        return ResponseEntity.ok("perfil se actualizo correctamente");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Optional<PerfilProfesional> perfil = pSer.listId(id);
        if (perfil.isPresent()) {
            pSer.delete(id);
            return ResponseEntity.ok("perfil eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("perfil no encontrado");
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<?> buscarPorEspecialidad(@RequestParam String especialidad) {
        List<PerfilProfesional> listaPerfiles = pSer.buscarPorEspecialidad(especialidad);
        if (listaPerfiles.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron perfiles con la especialidad o palabra clave: " + especialidad);
        }
        List<BusquedaPerfilDTO> respuesta = listaPerfiles.stream().map(p -> {
            BusquedaPerfilDTO dto = new BusquedaPerfilDTO();
            dto.setEspecialidad(p.getEspecialidad());
            dto.setBiografia(p.getBiografia());
            if(p.getUsuario() != null) {
                dto.setDni(p.getUsuario().getDni());
                dto.setApellidos(p.getUsuario().getApellidoPaterno() + " " + p.getUsuario().getApellidoMaterno());
            }
            return dto;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/Query02")
    public ResponseEntity<?> buscarInformacion(@RequestParam String filtro) {

        List<Object[]> lista = pSer.buscarPacientesOCursos(filtro);


        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron pacientes o cursos que coincidan con: " + filtro);
        }

        // 3. Mapeo manual al DTO (Estilo Object[])
        List<PacienteOCursoDTOQuery> respuesta = new ArrayList<>();
        for (Object[] columna : lista) {
            PacienteOCursoDTOQuery dto = new PacienteOCursoDTOQuery();

            dto.setNombrePaciente(columna[0].toString());
            dto.setNombreCurso(columna[1].toString());
            dto.setEspecialidadRelacionada(columna[2].toString());
            respuesta.add(dto);
        }

        return ResponseEntity.ok(respuesta);
    }


    @GetMapping("/reporte-especialidades")
    public ResponseEntity<?> reporteEspecialidades() {
        List<Object[]> lista = pSer.reporteEspecialidades();
        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No hay perfiles registrados para generar el reporte de especialidades.");
        }
        List<ReporteAgrupadoDTO> respuesta = new ArrayList<>();
        for (Object[] fila : lista) {
            ReporteAgrupadoDTO dto = new ReporteAgrupadoDTO();
            dto.setCategoria((String) fila[0]); // El nombre de la especialidad
            dto.setCantidad(((Number) fila[1]).intValue()); // El conteo de profesionales
            respuesta.add(dto);
        }
        return ResponseEntity.ok(respuesta);
    }
}
