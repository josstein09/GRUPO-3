package com.avance.avancetb.controllers;

import com.avance.avancetb.dtos.CitaDTO;
import com.avance.avancetb.entities.Cita;
import com.avance.avancetb.entities.Usuario;
import com.avance.avancetb.servicesinterfaces.ICitaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/citas")
public class CitaController {

    @Autowired
    private ICitaService cS;

    @GetMapping
    public ResponseEntity<List<CitaDTO>> listar() {
        ModelMapper m = new ModelMapper();
        List<CitaDTO> lista = cS.list().stream()
                .map(x -> m.map(x, CitaDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/nuevo")
    public ResponseEntity<CitaDTO> registrar(@RequestBody CitaDTO dto) {
        ModelMapper m = new ModelMapper();
        Cita c = m.map(dto, Cita.class);

        Usuario emisor = new Usuario();
        emisor.setIdUsuario(dto.getIdUsuarioEmisor());
        c.setUsuarioEmisor(emisor);

        Usuario receptor = new Usuario();
        receptor.setIdUsuario(dto.getIdUsuarioReceptor());
        c.setUsuarioReceptor(receptor);

        Cita nueva = cS.insert(c);
        CitaDTO responseDTO = m.map(nueva, CitaDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Optional<Cita> cita = cS.listId(id);

        if (cita.isPresent()) {
            CitaDTO dto = m.map(cita.get(), CitaDTO.class);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cita no encontrada");
        }
    }

    @PutMapping("/actualiza")
    public ResponseEntity<?> actualizar(@RequestBody CitaDTO dto) {
        Optional<Cita> existente = cS.listId(dto.getIdCita());

        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede actualizar: la cita no existe.");
        }

        ModelMapper m = new ModelMapper();
        Cita c = m.map(dto, Cita.class);

        Usuario emisor = new Usuario();
        emisor.setIdUsuario(dto.getIdUsuarioEmisor());
        c.setUsuarioEmisor(emisor);

        Usuario receptor = new Usuario();
        receptor.setIdUsuario(dto.getIdUsuarioReceptor());
        c.setUsuarioReceptor(receptor);

        cS.update(c);
        return ResponseEntity.ok("Cita actualizada correctamente");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Optional<Cita> cita = cS.listId(id);

        if (cita.isPresent()) {
            cS.delete(id);
            return ResponseEntity.ok("Cita eliminada correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cita no encontrada");
        }
    }

    @GetMapping("/top10/usuario/{idUsuario}")
    public ResponseEntity<List<CitaDTO>> listarTop10PorUsuario(@PathVariable int idUsuario) {
        ModelMapper m = new ModelMapper();
        List<CitaDTO> lista = cS.listarTop10CitasProximasPorUsuario(idUsuario)
                .stream().map(x -> m.map(x, CitaDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(lista);
    }
}