package com.avance.avancetb.dtos;

import com.avance.avancetb.entities.Cursos;
import com.avance.avancetb.entities.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class UsuarioCursoDTO {
    private int idUsuarioCurso;
    private LocalDateTime fechaUltimoAccesso;
    private LocalDateTime fechaAsignacion;
    private int idCursos;
    private int idUsuario;

    public int getIdUsuarioCurso() {
        return idUsuarioCurso;
    }

    public void setIdUsuarioCurso(int idUsuarioCurso) {
        this.idUsuarioCurso = idUsuarioCurso;
    }

    public LocalDateTime getFechaUltimoAccesso() {
        return fechaUltimoAccesso;
    }

    public void setFechaUltimoAccesso(LocalDateTime fechaUltimoAccesso) {
        this.fechaUltimoAccesso = fechaUltimoAccesso;
    }

    public LocalDateTime getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(LocalDateTime fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public int getIdCursos() {
        return idCursos;
    }

    public void setIdCursos(int idCursos) {
        this.idCursos = idCursos;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}

