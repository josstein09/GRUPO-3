package com.avance.avancetb.servicesimplements;

import com.avance.avancetb.entities.Formulario;
import com.avance.avancetb.repositories.IFormularioRepository;
import com.avance.avancetb.servicesinterfaces.IFormularioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormularioServiceImplement implements IFormularioService {

    @Autowired
    private IFormularioRepository repository;

    @Override
    public List<Formulario> list() {
        return repository.findAll();
    }

    @Override
    public Formulario insert(Formulario form) {
        return repository.save(form);
    }

    //@Override
    //public void uptade(Formulario formulario) {
    //    repository.save(formulario);
    //}

    @Override
    public Optional<Formulario> listId(int id) {
        return repository.findById(id);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<Object[]> obtenerReporteActividadUsuarios() {
        return repository.obtenerReporteActividadUsuarios();
    }



}
