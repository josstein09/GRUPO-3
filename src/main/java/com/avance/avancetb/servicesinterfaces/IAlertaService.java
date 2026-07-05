package com.avance.avancetb.servicesinterfaces;

import com.avance.avancetb.entities.Alerta;

import java.util.List;
import java.util.Optional;

public interface IAlertaService {
    public List<Alerta> list();
    public Alerta insert(Alerta a);
    public Optional<Alerta> listId(int id);
    public void update(Alerta a);
    public void delete(int id);

    // Métodos personalizados de las HU
    public List<Alerta> listarPendientesPorProfesional(int idProf);
    public List<Alerta> buscarPorTipo(String tipo);
}
