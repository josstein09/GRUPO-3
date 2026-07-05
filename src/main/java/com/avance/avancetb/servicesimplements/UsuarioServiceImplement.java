package com.avance.avancetb.servicesimplements;

import com.avance.avancetb.entities.Rol;
import com.avance.avancetb.entities.Usuario;
import com.avance.avancetb.repositories.IUsuarioRepository;
import com.avance.avancetb.servicesinterfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.time.LocalDate;
import java.util.UUID;

@Service
public class UsuarioServiceImplement implements IUsuarioService {
    @Autowired
        private IUsuarioRepository repository;
    @Autowired
    private PasswordEncoder passwordEncode;

    @Override
        public List<Usuario>list(){
        return repository.findAll();
    }

    @Override
    @Transactional
    public Usuario insert(Usuario u) {
        u.setContrasena(passwordEncode.encode(u.getContrasena()));
        u.setTokenUnico(UUID.randomUUID().toString());
        u.setFechaPrimerAcceso(LocalDate.now());
        u.setTutorialCompletado(false);
        u.setEstadoCuenta("Activo");
        if (u.getFotoPerfil() == null || u.getFotoPerfil().isEmpty()) {
            u.setFotoPerfil("no");
        }
        Rol rol = new Rol();
        rol.setIdRol(2);
        u.setRol(rol);
        return repository.save(u);
    }

    @Override
    @Transactional
    public void update(Usuario u) {
        Optional<Usuario> usuarioExistente = repository.findById(u.getIdUsuario());
        if (usuarioExistente.isPresent()) {
            Usuario userToUpdate = usuarioExistente.get();
            userToUpdate.setUsername(u.getUsername());
            userToUpdate.setApellidoPaterno(u.getApellidoPaterno());
            userToUpdate.setApellidoMaterno(u.getApellidoMaterno());
            userToUpdate.setDni(u.getDni());
            userToUpdate.setFotoPerfil(u.getFotoPerfil());
            repository.save(userToUpdate);
        }
    }

    @Override
    public Optional<Usuario> listId(int id) {
        return repository.findById(id);    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
