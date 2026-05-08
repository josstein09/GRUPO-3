package com.avance.avancetb.servicesimplements;

import com.avance.avancetb.dtos.ProgresoSesionDTO;
import com.avance.avancetb.entities.ProgresoSesion;
import com.avance.avancetb.entities.Sesion;
import com.avance.avancetb.entities.UsuarioCurso;
import com.avance.avancetb.repositories.IProgresoSesionRepository;
import com.avance.avancetb.repositories.ISesionRepository;
import com.avance.avancetb.repositories.UsuarioCursoRepository;
import com.avance.avancetb.servicesinterfaces.IProgresoSesionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgresoSesionServiceImplement implements IProgresoSesionService {

    @Autowired
    private IProgresoSesionRepository PSR;

    @Autowired
    private ISesionRepository SR;

    @Autowired
    private UsuarioCursoRepository UCR;

    @Override
    public List<ProgresoSesion> list() {
        return PSR.findAll();
    }

    @Override
    public ProgresoSesion listId(int id) {
        return PSR.findById(id).orElse(null);
    }

    @Override
    public ProgresoSesion Create(ProgresoSesionDTO ps) {
        Sesion sesion = SR.findById(ps.getIdSesion()).orElse(null);
        UsuarioCurso uc = UCR.findById(ps.getIdUsuarioCurso()).orElse(null);

        if (sesion == null) {
            throw new RuntimeException("La Sesion no existe con ID: " + ps.getIdSesion());
        }
        if (uc == null) {
            throw new RuntimeException("El registro UsuarioCurso no existe con ID: " + ps.getIdUsuarioCurso());
        }

        ProgresoSesion newEntity = new ProgresoSesion(
                ps.getIdProgresoSesion(),
                sesion,
                uc,
                ps.getProgreso(),
                ps.isCompleta(),
                ps.getFechaCompletado()
        );

        return PSR.save(newEntity);
    }

    @Override
    public ProgresoSesion Delete(int id) {
        ProgresoSesion ps = this.listId(id);
        if (ps == null) {
            throw new RuntimeException("El progreso no exdiste.");
        }
        PSR.delete(ps);
        return ps;
    }

    @Override
    public ProgresoSesion Update(int id, ProgresoSesion psActualizada) {
        ProgresoSesion psExistente = this.listId(id);

        if (psExistente == null) {
            return null;
        }

        psExistente.setProgreso(psActualizada.getProgreso());
        psExistente.setCompleta(psActualizada.isCompleta());
        psExistente.setFechaCompletado(psActualizada.getFechaCompletado());

        return PSR.save(psExistente);
    }
}