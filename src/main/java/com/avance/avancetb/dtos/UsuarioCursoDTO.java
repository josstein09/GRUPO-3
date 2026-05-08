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
    private int cursoid;
    private int usuarioid;

    public UsuarioCursoDTO() {
    }

    public UsuarioCursoDTO(int idUsuarioCurso, int usuario, int curso, LocalDateTime fechaUltimoAccesso,
                        LocalDateTime fechaAsignacion) {
        this.idUsuarioCurso = idUsuarioCurso;
        this.usuarioid = usuario;
        this.cursoid = curso;
        this.fechaUltimoAccesso = fechaUltimoAccesso;
        this.fechaAsignacion = fechaAsignacion;
    }


    public int getIdUsuarioCurso() {
        return idUsuarioCurso;
    }

    public int getUsuario() {
        return usuarioid;
    }

    public int getCurso() {
        return cursoid;
    }

    public LocalDateTime getFechaUltimoAccesso() {
        return fechaUltimoAccesso;
    }

    public LocalDateTime getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setIdUsuarioCurso(int idUsuarioCurso) {
        this.idUsuarioCurso = idUsuarioCurso;
    }

    public void setUsuario(int usuario) {
        this.usuarioid = usuario;
    }

    public void setCurso(int curso) {
        this.cursoid = curso;
    }

    public void setFechaUltimoAccesso(LocalDateTime fechaUltimoAccesso) {
        this.fechaUltimoAccesso = fechaUltimoAccesso;
    }

    public void setFechaAsignacion(LocalDateTime fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

}

