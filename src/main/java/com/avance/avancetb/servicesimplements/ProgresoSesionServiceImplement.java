package com.avance.avancetb.servicesimplements;

import com.avance.avancetb.dtos.ProgresoSesionDTO;
import com.avance.avancetb.entities.ProgresoSesion;
import com.avance.avancetb.entities.Sesion;
import com.avance.avancetb.entities.UsuarioCurso;
import com.avance.avancetb.repositories.IProgresoSesionRepository;
import com.avance.avancetb.repositories.ISesionRepository;
import com.avance.avancetb.repositories.IUsuarioCursoRepository;
import com.avance.avancetb.servicesinterfaces.IProgresoSesionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgresoSesionServiceImplement implements IProgresoSesionService {

    @Autowired
    private IProgresoSesionRepository PSR;


    @Override
    public List<ProgresoSesion> list() {
        return List.of();
    }

    @Override
    public ProgresoSesion insert(ProgresoSesion pS) {
        return PSR.save(pS);
    }

    @Override
    public Optional<ProgresoSesion> listId(int id) {
        return PSR.findById(id);
    }

    @Override
    public void update(ProgresoSesion p) {
        PSR.save(p);
    }

    @Override
    public void delete(int id) {
        PSR.deleteById(id);
    }
}