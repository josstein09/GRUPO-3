package com.avance.avancetb.servicesinterfaces;

import com.avance.avancetb.entities.ValoracionCurso;

import java.util.List;
import java.util.Optional;

public interface IValoracionCursoService {
    public List<ValoracionCurso>list();
    public ValoracionCurso insert(ValoracionCurso vC);
    public Optional<ValoracionCurso> listId(int id);
    public void update(ValoracionCurso v);
    public void delete(int id);
}