package com.avance.avancetb.repositories;

import com.avance.avancetb.entities.UsuarioCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUsuarioCursoRepository extends JpaRepository<UsuarioCurso, Integer> {
    @Query("SELECT uc.curso.nombreCurso, COUNT(uc) FROM UsuarioCurso uc GROUP BY uc.curso.nombreCurso")
    List<Object[]> contarInscritosPorCurso();
}

