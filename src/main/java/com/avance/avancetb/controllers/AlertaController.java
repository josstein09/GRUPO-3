package com.avance.avancetb.controllers;

import com.avance.avancetb.dtos.AlertaDTO;
import com.avance.avancetb.entities.Alerta;
import com.avance.avancetb.servicesinterfaces.IAlertaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alertas")
public class AlertaController {
    @Autowired
    private IAlertaService aS;

    @GetMapping("/listar")
    public List<AlertaDTO> listar() {
        ModelMapper m = new ModelMapper();
        return aS.list().stream().map(y -> m.map(y, AlertaDTO.class))
                .collect(Collectors.toList());
    }

    @PostMapping("/nuevo")
    public void registrar(@RequestBody AlertaDTO dto) {
        ModelMapper m = new ModelMapper();
        Alerta a = m.map(dto, Alerta.class);
        aS.insert(a);
    }

    @PutMapping("/actualizar")
    public void modificar(@RequestBody AlertaDTO dto) {
        ModelMapper m = new ModelMapper();
        Alerta a = m.map(dto, Alerta.class);
        aS.update(a);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        aS.delete(id);
    }

    // US008: Panel del profesional (Alertas Pendientes)
    @GetMapping("/pendientes-profesional/{idProf}")
    public List<AlertaDTO> listarPendientes(@PathVariable("idProf") Integer idProf) {
        ModelMapper m = new ModelMapper();
        return aS.listarPendientesPorProfesional(idProf).stream()
                .map(y -> m.map(y, AlertaDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/buscar-tipo")
    public List<AlertaDTO> buscarPorTipo(@RequestParam String tipo) {
        ModelMapper m = new ModelMapper();
        return aS.buscarPorTipo(tipo).stream()
                .map(y -> m.map(y, AlertaDTO.class))
                .collect(Collectors.toList());
    }
}
