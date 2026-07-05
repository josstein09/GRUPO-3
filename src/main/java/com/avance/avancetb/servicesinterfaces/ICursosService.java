package com.avance.avancetb.servicesinterfaces;

import com.avance.avancetb.entities.Cursos;

import java.util.List;
import java.util.Optional;

public interface ICursosService {
    public List<Cursos> list();
    public Cursos insert(Cursos cU);
    public void update(Cursos c);
    public Optional<Cursos> listId(int id);
    public void delete(int id);
    public List<Object[]> reporteCursosPorTipo();
    public List<Object[]> reporteCursosPorEspecialidad();

}
