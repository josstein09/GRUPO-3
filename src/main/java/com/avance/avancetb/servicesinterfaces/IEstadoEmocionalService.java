package com.avance.avancetb.servicesinterfaces;

import com.avance.avancetb.entities.EstadoEmocional;

import java.util.List;
import java.util.Optional;

public interface IEstadoEmocionalService {
    public List<EstadoEmocional> list();
    public EstadoEmocional insert(EstadoEmocional ee);
    public Optional<EstadoEmocional> listId(int id);
    public void update(EstadoEmocional ee);
    public void delete(int id);

    // Métodos personalizados de las HU
    public List<EstadoEmocional> buscarHistorialPorUsuario(int idUsuario);
    public List<Object[]> obtenerReporteSemanal(int idUsuario);
}
