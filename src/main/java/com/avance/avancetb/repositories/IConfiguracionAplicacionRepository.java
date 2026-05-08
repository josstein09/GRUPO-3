package com.avance.avancetb.repositories;

import com.avance.avancetb.entities.ConfiguracionAplicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.*;

@Repository
public interface IConfiguracionAplicacionRepository extends JpaRepository<ConfiguracionAplicacion,Integer> {
}
