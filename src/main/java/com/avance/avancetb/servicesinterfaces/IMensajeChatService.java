package com.avance.avancetb.servicesinterfaces;

import com.avance.avancetb.entities.MensajeChat;

import java.util.List;
import java.util.Optional;

public interface IMensajeChatService {
    public List<MensajeChat> list();
    public MensajeChat insert(MensajeChat m);
    public Optional<MensajeChat> listId(int id);
    public void update(MensajeChat m);
    public void delete(int id);

    public List<MensajeChat> listarTop10MensajesRecientesPorUsuario(int idUsuario);
}
