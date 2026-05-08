package com.avance.avancetb.repositories;

import com.avance.avancetb.entities.Sesion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISesionRepository extends JpaRepository<Sesion, Integer> {

    //hu31
    @Query("SELECT c.nombreCurso, c.tipoCurso, COUNT(s.ID_Sesion) as totalSesiones " +
            "FROM Cursos c " +
            "LEFT JOIN Sesion s ON c.idCursos = s.cursos.idCursos " +
            "GROUP BY c.nombreCurso, c.tipoCurso " +
            "HAVING COUNT(s.ID_Sesion) < 3 " +
            "ORDER BY totalSesiones ASC")
    List<Object[]> obtenerInformeCursosIncompletos();



   // @Query("SELECT s.cursos.nombreCurso, s.cursos.tipoCurso, COUNT(s.ID_Sesion) " +
   //         "FROM Sesion s " +
   //         "GROUP BY s.cursos.nombreCurso, s.cursos.tipoCurso " +
   //         "HAVING COUNT(s.ID_Sesion) < 3 " +
   //         "ORDER BY COUNT(s.ID_Sesion) DESC")
   // List<Object[]> obtenerResumenActividadesPorTema();
}
