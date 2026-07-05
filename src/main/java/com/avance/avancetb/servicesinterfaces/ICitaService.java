package com.avance.avancetb.servicesinterfaces;

import com.avance.avancetb.entities.Cita;

import java.util.List;
import java.util.Optional;

public interface ICitaService {
    public List<Cita> list();
    public Cita insert(Cita c);
    public Optional<Cita> listId(int id);
    public void update(Cita c);
    public void delete(int id);

    public List<Cita> listarTop10CitasProximasPorUsuario(int idUsuario);
}
