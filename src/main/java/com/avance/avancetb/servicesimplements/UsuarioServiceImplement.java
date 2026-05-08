package com.avance.avancetb.servicesimplements;

import com.avance.avancetb.entities.Usuario;
import com.avance.avancetb.repositories.IUsuarioRepository;
import com.avance.avancetb.servicesinterfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImplement implements IUsuarioService {
    @Autowired
        private IUsuarioRepository repository;

    @Override
        public List<Usuario>list(){
        return repository.findAll();
    }

    @Override
    public Usuario insert(Usuario uU) {
         return repository.save(uU);
    }

    @Override
    public void update(Usuario u) { repository.save(u);}

    @Override
    public Optional<Usuario> listId(int id) {
        return repository.findById(id);    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
