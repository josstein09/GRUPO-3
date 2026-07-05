package com.avance.avancetb.servicesimplements;

import com.avance.avancetb.dtos.UsuarioCursoDTO;
import com.avance.avancetb.entities.Cursos;
import com.avance.avancetb.entities.Usuario;
import com.avance.avancetb.entities.UsuarioCurso;
import com.avance.avancetb.repositories.ICursosRepository;
import com.avance.avancetb.repositories.IUsuarioRepository;
import com.avance.avancetb.repositories.IUsuarioCursoRepository;
import com.avance.avancetb.servicesinterfaces.IUsuarioCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioCursoServiceImplement implements IUsuarioCursoService {

    @Autowired
    private IUsuarioCursoRepository UR;


    @Override
    public List<UsuarioCurso> list() {
        return UR.findAll();
    }

    @Override
    public UsuarioCurso insert(UsuarioCurso uC) {
        return UR.save(uC);
    }

    @Override
    public Optional<UsuarioCurso> listId(int id) {
        return UR.findById(id);
    }

    @Override
    public void update(UsuarioCurso u) {
        UR.save(u);
    }

    @Override
    public void delete(int id) {
        UR.deleteById(id);
    }
}
