package com.avance.avancetb.servicesinterfaces;

import com.avance.avancetb.entities.Rol;

import java.util.List;
import java.util.Optional;

public interface IRolService {
    public List<Rol> list();
    public Rol insert(Rol rr);
    public void update(Rol r);
    public Optional<Rol> listId(int id);
    public void delete(int id);
    List<Object[]> listarUsuariosPorEstado(String estado);

}
