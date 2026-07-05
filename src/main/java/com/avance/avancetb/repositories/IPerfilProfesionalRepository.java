package com.avance.avancetb.repositories;

import com.avance.avancetb.entities.PerfilProfesional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPerfilProfesionalRepository extends JpaRepository<PerfilProfesional,Integer> {
    @Query(value = "SELECT * \n" +
            "FROM perfil_profesional p \n" +
            "WHERE LOWER(p.especialidad) LIKE \n" +
            "LOWER(CONCAT('%', :palabra, '%'))",nativeQuery = true)
    List<PerfilProfesional> buscarPorEspecialidad(@Param("palabra") String palabra);

    //HU16
    @Query("SELECT p.usuario.username, c.nombreCurso, p.especialidad " +
            "FROM Cursos c " +
            "JOIN c.perfilProfesional p " +
            "WHERE p.usuario.username LIKE %:filtro% " +
            "OR c.nombreCurso LIKE %:filtro%")
    List<Object[]> buscarPacientesOCursos(@Param("filtro") String filtro);
    @Query(value = "SELECT LOWER(p.especialidad), COUNT(p.id_perfil_profesional) " +
            "FROM perfil_profesional p " +
            "GROUP BY LOWER(p.especialidad)", nativeQuery = true)
    public List<Object[]> reporteEspecialidades();
}
