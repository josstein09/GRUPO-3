package com.avance.avancetb.servicesinterfaces;

import com.avance.avancetb.dtos.UsuarioCursoDTO;
import com.avance.avancetb.entities.UsuarioCurso;

import java.util.List;

public interface IUsuarioCursoService {
    public List<UsuarioCurso> list();
    public UsuarioCurso Listid (int id);
    public UsuarioCurso Create (UsuarioCursoDTO us);
    public UsuarioCurso Delete (int id);
    public UsuarioCurso Update (int id, UsuarioCurso uu);
}

