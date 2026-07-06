package com.avance.avancetb.servicesimplements;

import com.avance.avancetb.dtos.ValoracionCursoDTO;
import com.avance.avancetb.entities.UsuarioCurso;
import com.avance.avancetb.entities.ValoracionCurso;
import com.avance.avancetb.repositories.IValoracionCursoRepository;
import com.avance.avancetb.repositories.IUsuarioCursoRepository;
import com.avance.avancetb.servicesinterfaces.IValoracionCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ValoracionCursoServiceImplement implements IValoracionCursoService {

    @Autowired
    private IValoracionCursoRepository VCR;


    @Override
    public List<ValoracionCurso> list() {
        return VCR.findAll();
    }

    @Override
    public ValoracionCurso insert(ValoracionCurso vC) {
        return VCR.save(vC);
    }

    @Override
    public Optional<ValoracionCurso> listId(int id) {
        return VCR.findById(id);
    }

    @Override
    public void update(ValoracionCurso v) {
        VCR.save(v);
    }

    @Override
    public void delete(int id) {
        VCR.deleteById(id);
    }
}