package com.avance.avancetb.servicesimplements;


import com.avance.avancetb.entities.Rol;
import com.avance.avancetb.repositories.IRolRepository;
import com.avance.avancetb.servicesinterfaces.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImplement implements IRolService {
    @Autowired
    private IRolRepository rR;

    @Override
    public List<Rol> list() {
            return rR.findAll();
    }

    @Override
    public Rol insert(Rol rr) {
        return rR.save(rr);
    }

    @Override
    public void update(Rol r) {
        rR.save(r);
    }

    @Override
    public Optional<Rol> listId(int id) {
        return rR.findById(id);
    }

    @Override
    public void delete(int id) {
        rR.deleteById(id);
    }

    @Override
    public List<Object[]> listarUsuariosPorEstado(String estado) {
        return rR.listarUsuariosPorEstado(estado);
    }
}
