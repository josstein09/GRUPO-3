package com.avance.avancetb.servicesimplements;

import com.avance.avancetb.entities.Notificacion;
import com.avance.avancetb.repositories.INotificacionRepository;
import com.avance.avancetb.servicesinterfaces.INotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificacionServiceImplement implements INotificacionService {
    @Autowired
    private INotificacionRepository nR;

    @Override
    public List<Notificacion> list() {
        return nR.findAll();
    }

    @Override
    public Notificacion insert(Notificacion n) {
        return nR.save(n);
    }

    @Override
    public Optional<Notificacion> listId(int id) {
        return nR.findById(id);
    }

    @Override
    public void update(Notificacion n) {
        nR.save(n);
    }

    @Override
    public void delete(int id) {
        nR.deleteById(id);
    }

    @Override
    public List<Notificacion> listarActivasPorUsuario(int idUsuario) {
        return nR.findByUsuarioIdUsuarioAndLeidoFalseAndActivoTrueOrderByFechaNotificacionDesc(idUsuario);
    }

    @Override
    public void marcarComoLeidas(int idUsuario) {
        nR.marcarTodoComoLeido(idUsuario);
    }
}
