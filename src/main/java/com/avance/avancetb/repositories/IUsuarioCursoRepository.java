package com.avance.avancetb.repositories;

import com.avance.avancetb.entities.UsuarioCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioCursoRepository extends JpaRepository<UsuarioCurso, Integer> {

}

