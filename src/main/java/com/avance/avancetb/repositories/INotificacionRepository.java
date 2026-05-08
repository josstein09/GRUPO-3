package com.avance.avancetb.repositories;

import com.avance.avancetb.entities.Notificacion;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface INotificacionRepository extends JpaRepository<Notificacion, Integer> {
    // US010/US011: Listar notificaciones activas y no leídas de un usuario
    List<Notificacion> findByUsuarioIdUsuarioAndLeidoFalseAndActivoTrueOrderByFechaNotificacionDesc(int idUsuario);

    // US010: Método para marcar todas como leídas (Uso de @Modifying como enseñó la profesora)
    @Transactional
    @Modifying
    @Query("UPDATE Notificacion n SET n.leido = true WHERE n.usuario.idUsuario = :idUsuario")
    void marcarTodoComoLeido(@Param("idUsuario") int idUsuario);
}
