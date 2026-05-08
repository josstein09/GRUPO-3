package com.avance.avancetb.servicesimplements;

import com.avance.avancetb.entities.Alerta;
import com.avance.avancetb.repositories.IAlertaRepository;
import com.avance.avancetb.servicesinterfaces.IAlertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlertaServiceImplement implements IAlertaService {
    @Autowired
    private IAlertaRepository aR;

    @Override
    public List<Alerta> list() {
        return aR.findAll();
    }

    @Override
    public Alerta insert(Alerta a) {
        return aR.save(a);
    }

    @Override
    public Optional<Alerta> listId(int id) {
        return aR.findById(id);
    }

    @Override
    public void update(Alerta a) {
        aR.save(a);
    }

    @Override
    public void delete(int id) {
        aR.deleteById(id);
    }

    @Override
    public List<Alerta> listarPendientesPorProfesional(int idProf) {
        return aR.buscarAlertasPendientesPorProfesional(idProf);
    }

    @Override
    public List<Alerta> buscarPorTipo(String tipo) {
        return aR.findByTipoAlertaContainingIgnoreCase(tipo);
    }
}
