package com.avance.avancetb.repositories;

import com.avance.avancetb.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<Usuario, Integer> {
    public Usuario findOneByUsername(String username);

}
