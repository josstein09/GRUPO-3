package com.avance.avancetb.servicesinterfaces;

import com.avance.avancetb.entities.UsuarioCurso;

import java.util.List;
import java.util.Optional;

public interface IUsuarioCursoService {
    public List<UsuarioCurso>list();
    public UsuarioCurso insert(UsuarioCurso uC);
    public Optional<UsuarioCurso> listId(int id);
    public void update(UsuarioCurso u);
    public void delete(int id);
}

