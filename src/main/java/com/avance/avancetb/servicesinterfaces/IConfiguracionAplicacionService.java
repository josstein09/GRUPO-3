package com.avance.avancetb.servicesinterfaces;

import com.avance.avancetb.entities.ConfiguracionAplicacion;

import java.util.List;
import java.util.Optional;

public interface IConfiguracionAplicacionService {
    public List<ConfiguracionAplicacion> list();
    public ConfiguracionAplicacion insert(ConfiguracionAplicacion cA);
    public void update(ConfiguracionAplicacion c);
    public Optional<ConfiguracionAplicacion> listId(int id);
    public void delete(int id);
}
