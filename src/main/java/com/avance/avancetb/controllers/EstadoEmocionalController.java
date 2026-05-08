package com.avance.avancetb.controllers;

import com.avance.avancetb.dtos.EstadoEmocionalDTO;
import com.avance.avancetb.dtos.EstadoEmocionalReporteDTO;
import com.avance.avancetb.entities.EstadoEmocional;
import com.avance.avancetb.servicesinterfaces.IEstadoEmocionalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/estados-emocionales")
public class EstadoEmocionalController {
    @Autowired
    private IEstadoEmocionalService eeS;

    @GetMapping("/listar")
    public List<EstadoEmocionalDTO> listar() {
        ModelMapper m = new ModelMapper();
        return eeS.list().stream().map(y -> m.map(y, EstadoEmocionalDTO.class))
                .collect(Collectors.toList());
    }

    @PostMapping("/nuevo")
    public void registrar(@RequestBody EstadoEmocionalDTO dto) {
        ModelMapper m = new ModelMapper();
        EstadoEmocional ee = m.map(dto, EstadoEmocional.class);
        eeS.insert(ee);
    }

    @PutMapping("/actualizar")
    public void modificar(@RequestBody EstadoEmocionalDTO dto) {
        ModelMapper m = new ModelMapper();
        EstadoEmocional ee = m.map(dto, EstadoEmocional.class);
        eeS.update(ee);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        eeS.delete(id);
    }

    @GetMapping("/{id}")
    public EstadoEmocionalDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        return eeS.listId(id).map(y -> m.map(y, EstadoEmocionalDTO.class)).orElse(new EstadoEmocionalDTO());
    }

    // US007: Historial por Paciente
    @GetMapping("/paciente/{id}")
    public List<EstadoEmocionalDTO> buscarHistorial(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        return eeS.buscarHistorialPorUsuario(id).stream()
                .map(y -> m.map(y, EstadoEmocionalDTO.class))
                .collect(Collectors.toList());
    }

    // US004: Datos para Gráfico Semanal
    @GetMapping("/reporte-semanal/{id}")
    public List<EstadoEmocionalReporteDTO> reporteSemanal(@PathVariable("id") Integer id) {
        List<Object[]> lista = eeS.obtenerReporteSemanal(id);
        List<EstadoEmocionalReporteDTO> listaDTO = new ArrayList<>();
        for (Object[] columna : lista) {
            EstadoEmocionalReporteDTO dto = new EstadoEmocionalReporteDTO();
            dto.setDia(String.valueOf(columna[0]));
            dto.setPromedioBienestar(((Number) columna[1]).doubleValue());
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
