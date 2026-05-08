package com.avance.avancetb.controllers;

import com.avance.avancetb.dtos.NotificacionDTO;
import com.avance.avancetb.entities.Notificacion;
import com.avance.avancetb.servicesinterfaces.INotificacionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notificaciones")
public class NotificacionController {
    @Autowired
    private INotificacionService nS;

    @GetMapping("/listar")
    public List<NotificacionDTO> listar() {
        ModelMapper m = new ModelMapper();
        return nS.list().stream().map(y -> m.map(y, NotificacionDTO.class))
                .collect(Collectors.toList());
    }

    @PostMapping("/nuevo")
    public void registrar(@RequestBody NotificacionDTO dto) {
        ModelMapper m = new ModelMapper();
        Notificacion n = m.map(dto, Notificacion.class);
        nS.insert(n);
    }

    @PutMapping("/Modificar")
    public void modificar(@RequestBody NotificacionDTO dto) {
        ModelMapper m = new ModelMapper();
        Notificacion n = m.map(dto, Notificacion.class);
        nS.update(n);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        nS.delete(id);
    }

    // US010/US011: Notificaciones activas por usuario (Campana de avisos)
    @GetMapping("/usuario/{id}")
    public List<NotificacionDTO> listarActivas(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        return nS.listarActivasPorUsuario(id).stream()
                .map(y -> m.map(y, NotificacionDTO.class))
                .collect(Collectors.toList());
    }

    // US010: Botón de "Marcar todas como leídas"
    @PutMapping("/leer-todo/{idUsuario}")
    public void leerTodo(@PathVariable("idUsuario") Integer idUsuario) {
        nS.marcarComoLeidas(idUsuario);
    }
}
