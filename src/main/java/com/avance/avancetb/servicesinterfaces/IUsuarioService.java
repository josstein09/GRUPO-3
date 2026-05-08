package com.avance.avancetb.servicesinterfaces;

import com.avance.avancetb.entities.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {

    public List<Usuario> list();
    public Usuario insert(Usuario uU);
    public void update(Usuario u);
    public Optional<Usuario> listId(int id);
    public void delete(int id);
}
