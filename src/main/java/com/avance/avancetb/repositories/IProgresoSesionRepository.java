package com.avance.avancetb.repositories;

import com.avance.avancetb.entities.ProgresoSesion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProgresoSesionRepository extends JpaRepository<ProgresoSesion, Integer> {

}
