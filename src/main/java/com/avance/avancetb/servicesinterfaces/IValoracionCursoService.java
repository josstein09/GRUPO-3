package com.avance.avancetb.servicesinterfaces;

import com.avance.avancetb.dtos.ValoracionCursoDTO;
import com.avance.avancetb.entities.ValoracionCurso;

import java.util.List;

public interface IValoracionCursoService {
    public List<ValoracionCurso> list();
    public ValoracionCurso listId(int id);
    public ValoracionCurso Create(ValoracionCursoDTO vc);
    public ValoracionCurso Delete(int id);
    public ValoracionCurso Update(int id, ValoracionCurso vc);
}