package com.avance.avancetb.repositories;

import com.avance.avancetb.entities.EstadoEmocional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEstadoEmocionalRepository extends JpaRepository<EstadoEmocional,Integer> {
    // US007: Buscar historial emocional de un paciente específico
    List<EstadoEmocional> findByUsuarioIdUsuarioOrderByFechaRegistroDesc(int idUsuario);

    // US004: Query para el gráfico semanal (Promedio de bienestar por día de los últimos 7 días)
    @Query(value = "SELECT TO_CHAR(fecha_registro, 'Day') as dia, AVG(nivel_bienestar) as promedio " +
            "FROM estado_emocional " +
            "WHERE id_usuario = :idUsuario " +
            "AND fecha_registro >= CURRENT_DATE - INTERVAL '7 days' " +
            "GROUP BY dia, TO_CHAR(fecha_registro, 'D') " +
            "ORDER BY TO_CHAR(fecha_registro, 'D')", nativeQuery = true)
    List<Object[]> reporteSemanalPorUsuario(@Param("idUsuario") int idUsuario);
}
