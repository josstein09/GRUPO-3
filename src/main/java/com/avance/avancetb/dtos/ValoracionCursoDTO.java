package com.avance.avancetb.dtos;

import java.time.LocalDateTime;

public class ValoracionCursoDTO {

    private int idValoracion;
    private int idUsuarioCurso;
    private LocalDateTime fechaValoracion;
    private int calificacion;
    private String comentario;


    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public LocalDateTime getFechaValoracion() {
        return fechaValoracion;
    }

    public void setFechaValoracion(LocalDateTime fechaValoracion) {
        this.fechaValoracion = fechaValoracion;
    }

    public int getIdUsuarioCurso() {
        return idUsuarioCurso;
    }

    public void setIdUsuarioCurso(int idUsuarioCurso) {
        this.idUsuarioCurso = idUsuarioCurso;
    }

    public int getIdValoracion() {
        return idValoracion;
    }

    public void setIdValoracion(int idValoracion) {
        this.idValoracion = idValoracion;
    }
}