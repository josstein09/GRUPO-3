package com.avance.avancetb.repositories;

import com.avance.avancetb.entities.MensajeChat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMensajeChatRepository extends JpaRepository<MensajeChat, Integer> {

    @Query(value = """
            SELECT *
            FROM mensaje_chat
            WHERE id_usuario_emisor = :idUsuario
               OR id_usuario_receptor = :idUsuario
            ORDER BY fecha_envio DESC, hora_envio DESC
            LIMIT 10
            """, nativeQuery = true)
    List<MensajeChat> listarTop10MensajesRecientesPorUsuario(@Param("idUsuario") int idUsuario);
}