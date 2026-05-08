package com.avance.avancetb.dtos;

import java.time.LocalDateTime;

public class ValoracionCursoDTO {

    private int idValoracion;
    private int idUsuarioCurso; // ID de la relación Usuario-Curso (primitivo, como en tu UsuarioCursoDTO)
    private LocalDateTime fechaValoracion;
    private int calificacion;
    private String comentario;

    public ValoracionCursoDTO() {
    }

    public ValoracionCursoDTO(int idValoracion, int idUsuarioCurso, LocalDateTime fechaValoracion, int calificacion, String comentario) {
        this.idValoracion = idValoracion;
        this.idUsuarioCurso = idUsuarioCurso;
        this.fechaValoracion = fechaValoracion;
        this.calificacion = calificacion;
        this.comentario = comentario;
    }

    // Getters y Setters
    public int getIdValoracion() {
        return idValoracion;
    }

    public void setIdValoracion(int idValoracion) {
        this.idValoracion = idValoracion;
    }

    public int getIdUsuarioCurso() {
        return idUsuarioCurso;
    }

    public void setIdUsuarioCurso(int idUsuarioCurso) {
        this.idUsuarioCurso = idUsuarioCurso;
    }

    public LocalDateTime getFechaValoracion() {
        return fechaValoracion;
    }

    public void setFechaValoracion(LocalDateTime fechaValoracion) {
        this.fechaValoracion = fechaValoracion;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}