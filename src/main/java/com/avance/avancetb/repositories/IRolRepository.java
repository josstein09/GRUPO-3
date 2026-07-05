package com.avance.avancetb.repositories;

import com.avance.avancetb.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer> {
    @Query(value = "SELECT r.name_rol, r.description_rol, u.username, u.estado_cuenta " +
            "FROM rol r " +
            "INNER JOIN usuario u ON r.id_rol = u.id_rol " +
            "WHERE u.estado_cuenta = :estado " +
            "ORDER BY r.name_rol ASC", nativeQuery = true)
    List<Object[]> listarUsuariosPorEstado(@Param("estado") String estado);

}
