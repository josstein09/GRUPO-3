package com.avance.avancetb.repositories;

import com.avance.avancetb.entities.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICitaRepository extends JpaRepository<Cita, Integer> {

    @Query(value = """
            SELECT *
            FROM cita
            WHERE id_usuario_emisor = :idUsuario
               OR id_usuario_receptor = :idUsuario
            ORDER BY fecha_cita ASC, hora_cita ASC
            LIMIT 10
            """, nativeQuery = true)
    List<Cita> listarTop10CitasProximasPorUsuario(@Param("idUsuario") int idUsuario);
}