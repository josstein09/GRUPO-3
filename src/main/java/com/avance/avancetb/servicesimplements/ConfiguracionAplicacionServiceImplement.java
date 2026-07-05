package com.avance.avancetb.servicesimplements;

import com.avance.avancetb.entities.ConfiguracionAplicacion;
import com.avance.avancetb.repositories.IConfiguracionAplicacionRepository;
import com.avance.avancetb.servicesinterfaces.IConfiguracionAplicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import java.util.List;
import java.util.Optional;

@Service
public class ConfiguracionAplicacionServiceImplement implements IConfiguracionAplicacionService {
    @Autowired
    private IConfiguracionAplicacionRepository car;

    @Override
    public List<ConfiguracionAplicacion> list() {
        return car.findAll();
    }

    @Override
    public ConfiguracionAplicacion insert(ConfiguracionAplicacion cA) {
        return car.save(cA);
    }

    @Override
    public void update(ConfiguracionAplicacion c) {
        car.save(c);
    }

    @Override
    public Optional<ConfiguracionAplicacion> listId(int id) {
        return car.findById(id);
    }

    @Override
    public void delete(int id) {
        car.deleteById(id);
    }
}
