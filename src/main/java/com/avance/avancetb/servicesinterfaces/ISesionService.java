package com.avance.avancetb.servicesinterfaces;

import com.avance.avancetb.entities.Rol;
import com.avance.avancetb.entities.Sesion;

import java.util.List;
import java.util.Optional;

public interface ISesionService {

    public List<Sesion> list();
    public Sesion insert(Sesion rr);
    public void update(Sesion r);
    public Optional<Sesion> listId(int id);
    public void delete(int id);
    List<Object[]> obtenerInformeCursosIncompletos ();


}
