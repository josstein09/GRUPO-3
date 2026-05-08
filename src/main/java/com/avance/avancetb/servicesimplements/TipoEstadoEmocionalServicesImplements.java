package com.avance.avancetb.servicesimplements;

import com.avance.avancetb.entities.TipoEstadoEmocionalEntities;
import com.avance.avancetb.repositories.ITipoEstadoEmocionalRepositories;
import com.avance.avancetb.servicesinterfaces.TipoEstadoEmocionalServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoEstadoEmocionalServicesImplements implements TipoEstadoEmocionalServices {
    @Autowired
    private ITipoEstadoEmocionalRepositories tR;
    @Override
    public List<TipoEstadoEmocionalEntities> list()
    {
        return tR.findAll();
    }

    @Override
    public TipoEstadoEmocionalEntities insert(TipoEstadoEmocionalEntities tE) {
        return tR.save(tE);    }

    @Override
    public void update(TipoEstadoEmocionalEntities te) {
        tR.save(te);
    }

    @Override
    public Optional<TipoEstadoEmocionalEntities> listId(int id) {
        return tR.findById(id) ;
    }

    @Override
    public void delete(int id) {
        tR.deleteById(id);
    }
}
