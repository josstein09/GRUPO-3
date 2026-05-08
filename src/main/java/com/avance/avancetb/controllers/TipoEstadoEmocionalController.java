package com.avance.avancetb.controllers;

import com.avance.avancetb.dtos.TipoEstadoEmocionalDTO;
import com.avance.avancetb.entities.TipoEstadoEmocionalEntities;
import com.avance.avancetb.servicesinterfaces.TipoEstadoEmocionalServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tipos_emocionales")
public class TipoEstadoEmocionalController {
    @Autowired
    private TipoEstadoEmocionalServices tS;

    @GetMapping
    public ResponseEntity<List<TipoEstadoEmocionalDTO>>listar() {
        ModelMapper m = new ModelMapper();
        List<TipoEstadoEmocionalDTO> listaDto=tS.list()
            .stream().map(x->m.map(x,TipoEstadoEmocionalDTO.class))
                    .collect(Collectors.toList());
            return ResponseEntity.ok(listaDto);
    }
    @PostMapping("/nuevo")
    public ResponseEntity<TipoEstadoEmocionalDTO> registrar(@RequestBody TipoEstadoEmocionalDTO dto){
        ModelMapper m = new ModelMapper();
        TipoEstadoEmocionalEntities t=m.map(dto, TipoEstadoEmocionalEntities.class);
        TipoEstadoEmocionalEntities tip=tS.insert(t);
        TipoEstadoEmocionalDTO responseDTO=m.map(tip,TipoEstadoEmocionalDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Optional<TipoEstadoEmocionalEntities> tipoEmocion = tS.listId(id);

        if (tipoEmocion.isPresent()) {
            TipoEstadoEmocionalDTO dto = m.map(tipoEmocion.get(), TipoEstadoEmocionalDTO.class);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Tipo de Emocion no encontrada");
        }
    }

    @PutMapping("/actualiza")
    public ResponseEntity<String> actualizar(@RequestBody TipoEstadoEmocionalDTO dto) {

        Optional<TipoEstadoEmocionalEntities> existente = tS.listId(dto.getIdTipoEst());
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Tipo de Emocion no encontrada");
        }


        TipoEstadoEmocionalEntities ti = existente.get();

        ti.setNombreTipoEst(dto.getNombreTipoEst());
        ti.setDescripcionTipoEst(dto.getDescripcionTipoEst());
        ti.setIconoTipoEst(dto.getIconoTipoEst());
        tS.update(ti);

        return ResponseEntity.ok("Tipo de Emocion actualizada correctamente");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Optional<TipoEstadoEmocionalEntities> tipoEmocion = tS.listId(id);

        if (tipoEmocion.isPresent()) {
            tS.delete(id);
            return ResponseEntity.ok("Tipo de Emocion eliminada correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Tipo de Emocion no encontrada");
        }
    }
}
