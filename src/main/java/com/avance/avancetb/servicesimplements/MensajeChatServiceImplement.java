package com.avance.avancetb.servicesimplements;

import com.avance.avancetb.entities.MensajeChat;
import com.avance.avancetb.repositories.IMensajeChatRepository;
import com.avance.avancetb.servicesinterfaces.IMensajeChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MensajeChatServiceImplement implements IMensajeChatService {

    @Autowired
    private IMensajeChatRepository mR;

    @Override
    public List<MensajeChat> list() {
        return mR.findAll();
    }

    @Override
    public MensajeChat insert(MensajeChat m) {
        return mR.save(m);
    }

    @Override
    public Optional<MensajeChat> listId(int id) {
        return mR.findById(id);
    }

    @Override
    public void update(MensajeChat m) {
        mR.save(m);
    }

    @Override
    public void delete(int id) {
        mR.deleteById(id);
    }

    @Override
    public List<MensajeChat> listarTop10MensajesRecientesPorUsuario(int idUsuario) {
        return mR.listarTop10MensajesRecientesPorUsuario(idUsuario);
    }
}