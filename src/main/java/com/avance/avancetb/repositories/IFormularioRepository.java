package com.avance.avancetb.repositories;

import com.avance.avancetb.entities.Formulario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface IFormularioRepository extends JpaRepository<Formulario, Integer> {

    @Query("SELECT f.usuario.username, f.usuario.estadoCuenta, COUNT(f) " +
            "FROM Formulario f " +
            "GROUP BY f.usuario.username, f.usuario.estadoCuenta " +
            "ORDER BY COUNT(f) DESC")
    List<Object[]> obtenerReporteActividadUsuarios();

}
