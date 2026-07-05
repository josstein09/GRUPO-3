package com.avance.avancetb.servicesinterfaces;

import com.avance.avancetb.entities.Notificacion;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface INotificacionService {
    public List<Notificacion> list();
    public Notificacion insert(Notificacion n);
    public Optional<Notificacion> listId(int id);
    public void update(Notificacion n);
    public void delete(int id);

    // Métodos personalizados de las HU
    public List<Notificacion> listarActivasPorUsuario(int idUsuario);
    public void marcarComoLeidas(int idUsuario);
}
