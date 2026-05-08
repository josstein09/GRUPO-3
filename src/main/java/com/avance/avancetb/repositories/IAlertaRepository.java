package com.avance.avancetb.repositories;

import com.avance.avancetb.entities.Alerta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAlertaRepository extends JpaRepository<Alerta, Integer> {
    // US008: Listar alertas pendientes de un profesional específico
    @Query("SELECT a FROM Alerta a WHERE a.estadoAlerta = 'PENDIENTE' " +
            "AND a.usuario.idUsuario IN (SELECT ee.usuario.idUsuario FROM EstadoEmocional ee WHERE ee.perfilProfesional.idPerfilProfesional = :idProf)")
    List<Alerta> buscarAlertasPendientesPorProfesional(@Param("idProf") int idProf);

    // US008: Buscar alertas por tipo (ej. 'CRITICA' o 'EMERGENCIA')
    List<Alerta> findByTipoAlertaContainingIgnoreCase(String tipo);
}
