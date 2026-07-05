package com.avance.avancetb.repositories;

import com.avance.avancetb.entities.ValoracionCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IValoracionCursoRepository extends JpaRepository<ValoracionCurso, Integer> {

}

