package com.avance.avancetb.servicesinterfaces;


import com.avance.avancetb.entities.Formulario;

import java.text.Normalizer;
import java.util.List;
import java.util.Optional;

public interface IFormularioService {
    public List<Formulario> list();
    public Formulario insert(Formulario form);
    //public void uptade(Formulario formulario);
    public Optional<Formulario> listId(int id);
    public void delete(int id);

    public List<Object[]>obtenerReporteActividadUsuarios();


}
