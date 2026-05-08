package com.avance.avancetb.controllers;

import com.avance.avancetb.dtos.RolDTO;
import com.avance.avancetb.dtos.SesionDTO;
import com.avance.avancetb.dtos.SesionInformeCursoDTO;
import com.avance.avancetb.entities.Rol;
import com.avance.avancetb.entities.Sesion;
import com.avance.avancetb.servicesinterfaces.ISesionService;
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
@RequestMapping("/Sesion")
public class SesionController {

    @Autowired
    private ISesionService service;

    @GetMapping
    public ResponseEntity<List<SesionDTO>> listar() {
        ModelMapper m = new ModelMapper();
        List<SesionDTO> listaRoles = service.list()
                .stream().map(x -> m.map(x, SesionDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaRoles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Optional<Sesion> rol = service.listId(id);

        if (rol.isPresent()) {
            SesionDTO dto = m.map(rol.get(), SesionDTO.class);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Sesion no encontrada");
        }
    }

    @PostMapping("/nuevo") //revisar en postman
    public ResponseEntity<SesionDTO> registrar(@RequestBody SesionDTO dto){
        ModelMapper m = new ModelMapper();
        Sesion r = m.map(dto, Sesion.class);
        Sesion rl =service.insert(r);
        SesionDTO responseDTO = m.map(rl,SesionDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping("/actualizar") //falta ingresar los demas atributos
    public ResponseEntity<String> actualizar(@RequestBody SesionDTO dto) {

        Optional<Sesion> existente = service.listId(dto.getID_Sesion());
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Sala no encontrada");
        }


        Sesion ro = existente.get();

        ro.setID_Sesion(dto.getID_Sesion());

        service.update(ro);

        return ResponseEntity.ok("Rol actualizado correctamente");
    }


    @DeleteMapping("/Eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Optional<Sesion> sala = service.listId(id);

        if (sala.isPresent()) {
            service.delete(id);
            return ResponseEntity.ok("Sesion eliminadao correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Rol no encontrado");
        }
    }

    @GetMapping("/cursos-incompletos")
    public ResponseEntity<?> obtenerReporteCursosIncompletos() {
        List<Object[]> lista = service.obtenerInformeCursosIncompletos();
        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron cursos registrados con pocas sesiones.");
        }
        List<SesionInformeCursoDTO> respuesta = new ArrayList<>();
        for (Object[] columna : lista) {
            SesionInformeCursoDTO dto = new SesionInformeCursoDTO();

            dto.setNombreCurso(columna[0].toString());
            dto.setTipoCurso(columna[1].toString());
            dto.setTotalSesiones(((Number) columna[2]).intValue());

            respuesta.add(dto);
        }

        return ResponseEntity.ok(respuesta);
    }


}
