package com.avance.avancetb.servicesinterfaces;

import com.avance.avancetb.entities.ProgresoSesion;

import java.util.List;
import java.util.Optional;

public interface IProgresoSesionService {
    public List<ProgresoSesion>list();
    public ProgresoSesion insert(ProgresoSesion pS);
    public Optional<ProgresoSesion> listId(int id);
    public void update(ProgresoSesion p);
    public void delete(int id);
}