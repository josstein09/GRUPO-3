package com.avance.avancetb.servicesimplements;

import com.avance.avancetb.entities.Cursos;
import com.avance.avancetb.repositories.ICursosRepository;
import com.avance.avancetb.servicesinterfaces.ICursosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursosServiceImplement implements ICursosService {
    @Autowired
    private ICursosRepository curR;

    @Override
    public List<Cursos> list() {
        return curR.findAll();
    }

    @Override
    public Cursos insert(Cursos cU) {
        return curR.save(cU);
    }

    @Override
    public void update(Cursos c) {
        curR.save(c);
    }

    @Override
    public Optional<Cursos> listId(int id) {
        return curR.findById(id);
    }

    @Override
    public void delete(int id) {
        curR.deleteById(id);
    }

    @Override
    public List<Object[]> reporteCursosPorTipo() {
        return curR.reporteCursosPorTipo();
    }

    @Override
    public List<Object[]> reporteCursosPorEspecialidad() {
        return curR.reporteCursosPorEspecialidad();
    }
}

