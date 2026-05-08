package com.avance.avancetb.servicesinterfaces;

import com.avance.avancetb.entities.TipoEstadoEmocionalEntities;

import java.util.List;
import java.util.Optional;

public interface TipoEstadoEmocionalServices {
    public List<TipoEstadoEmocionalEntities> list();
    public TipoEstadoEmocionalEntities insert(TipoEstadoEmocionalEntities tE);
    public void update(TipoEstadoEmocionalEntities te);
    public Optional<TipoEstadoEmocionalEntities> listId(int id);
    public void delete(int id);
}
