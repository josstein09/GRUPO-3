package com.avance.avancetb.servicesimplements;

import com.avance.avancetb.entities.Cita;
import com.avance.avancetb.repositories.ICitaRepository;
import com.avance.avancetb.servicesinterfaces.ICitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitaServiceImplement implements ICitaService {

    @Autowired
    private ICitaRepository cR;

    @Override
    public List<Cita> list() {
        return cR.findAll();
    }

    @Override
    public Cita insert(Cita c) {
        return cR.save(c);
    }

    @Override
    public Optional<Cita> listId(int id) {
        return cR.findById(id);
    }

    @Override
    public void update(Cita c) {
        cR.save(c);
    }

    @Override
    public void delete(int id) {
        cR.deleteById(id);
    }

    @Override
    public List<Cita> listarTop10CitasProximasPorUsuario(int idUsuario) {
        return cR.listarTop10CitasProximasPorUsuario(idUsuario);
    }
}