package com.avance.avancetb.repositories;

import com.avance.avancetb.entities.TipoEstadoEmocionalEntities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoEstadoEmocionalRepositories extends JpaRepository<TipoEstadoEmocionalEntities,Integer> {

}
