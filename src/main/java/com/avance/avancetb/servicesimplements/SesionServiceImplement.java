package com.avance.avancetb.servicesimplements;

import com.avance.avancetb.entities.Rol;
import com.avance.avancetb.entities.Sesion;
import com.avance.avancetb.repositories.ISesionRepository;
import com.avance.avancetb.servicesinterfaces.ISesionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SesionServiceImplement implements ISesionService {

    @Autowired
    private ISesionRepository repository;

    @Override
    public List<Sesion> list() {
        return repository.findAll();
    }

    @Override
    public Sesion insert(Sesion rr) {
        return repository.save(rr);
    }


    @Override
    public void update(Sesion r) {
        repository.save(r);
    }

    @Override
    public Optional<Sesion> listId(int id) {
        return repository.findById(id);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<Object[]> obtenerInformeCursosIncompletos() {
        return repository.obtenerInformeCursosIncompletos();
    }
}
