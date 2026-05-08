package com.avance.avancetb.servicesinterfaces;

import com.avance.avancetb.entities.PerfilProfesional;

import java.util.List;
import java.util.Optional;

public interface IPerfilProfesionalService {
    public List<PerfilProfesional> list();
    public PerfilProfesional insert(PerfilProfesional pP);
    public void update(PerfilProfesional p);
    public Optional<PerfilProfesional> listId(int id);
    public void delete(int id);
    List<PerfilProfesional> buscarPorEspecialidad(String palabra);
    List<Object[]> buscarPacientesOCursos (String filtro);
    public List<Object[]> reporteEspecialidades();
}
