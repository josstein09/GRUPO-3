package com.avance.avancetb.servicesimplements;

import com.avance.avancetb.entities.Alerta;
import com.avance.avancetb.entities.EstadoEmocional;
import com.avance.avancetb.repositories.IAlertaRepository;
import com.avance.avancetb.repositories.IEstadoEmocionalRepository;
import com.avance.avancetb.servicesinterfaces.IEstadoEmocionalService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EstadoEmocionalServiceImplement implements IEstadoEmocionalService {
    @Autowired
    private IEstadoEmocionalRepository eeR;
    @Autowired
    private IAlertaRepository aR; // Para disparar la alerta automática

    @Override
    public List<EstadoEmocional> list() {
        return eeR.findAll();
    }

    @Override
    @Transactional
    public EstadoEmocional insert(EstadoEmocional ee) {
        // Lógica US008: Disparar alerta si el nivel es crítico (1 o 2)
        if (ee.getNivelBienestar() <= 2) {
            Alerta nuevaAlerta = new Alerta();
            nuevaAlerta.setFechaHoraAlerta(LocalDateTime.now());
            nuevaAlerta.setEstadoAlerta("PENDIENTE");
            nuevaAlerta.setTipoAlerta("CRITICA");
            nuevaAlerta.setObservacion("Generada automáticamente por bienestar bajo: " + ee.getObservacion());
            nuevaAlerta.setUsuario(ee.getUsuario());
            aR.save(nuevaAlerta);
        }
        return eeR.save(ee);
    }

    @Override
    public Optional<EstadoEmocional> listId(int id) {
        return eeR.findById(id);
    }

    @Override
    public void update(EstadoEmocional ee) {
        eeR.save(ee);
    }

    @Override
    public void delete(int id) {
        eeR.deleteById(id);
    }

    @Override
    public List<EstadoEmocional> buscarHistorialPorUsuario(int idUsuario) {
        return eeR.findByUsuarioIdUsuarioOrderByFechaRegistroDesc(idUsuario);
    }

    @Override
    public List<Object[]> obtenerReporteSemanal(int idUsuario) {
        return eeR.reporteSemanalPorUsuario(idUsuario);
    }
}
