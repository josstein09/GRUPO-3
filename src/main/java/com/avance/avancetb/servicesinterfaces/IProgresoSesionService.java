package com.avance.avancetb.servicesinterfaces;

import com.avance.avancetb.dtos.ProgresoSesionDTO;
import com.avance.avancetb.entities.ProgresoSesion;

import java.util.List;

public interface IProgresoSesionService {
    public List<ProgresoSesion> list();
    public ProgresoSesion listId(int id);
    public ProgresoSesion Create(ProgresoSesionDTO ps);
    public ProgresoSesion Delete(int id);
    public ProgresoSesion Update(int id, ProgresoSesion ps);
}