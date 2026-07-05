package com.avance.avancetb.repositories;

import com.avance.avancetb.entities.Cursos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICursosRepository extends JpaRepository<Cursos,Integer> {
    @Query(value = "SELECT LOWER(tipo_curso), COUNT(id_cursos) \n" +
            "FROM cursos \n" +
            "GROUP BY LOWER(tipo_curso)", nativeQuery = true)
    public List<Object[]> reporteCursosPorTipo();

    @Query(value = "SELECT LOWER(p.especialidad), COUNT(c.id_cursos)\n" +
            "FROM cursos c\n" +
            "JOIN perfil_profesional p ON c.id_perfil_profesional = p.id_perfil_profesional\n" +
            "GROUP BY LOWER(p.especialidad)", nativeQuery = true)
    public List<Object[]> reporteCursosPorEspecialidad();
}
