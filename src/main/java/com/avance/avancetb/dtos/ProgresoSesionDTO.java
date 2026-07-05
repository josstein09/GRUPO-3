package com.avance.avancetb.dtos;

import java.time.LocalDateTime;

public class ProgresoSesionDTO {

    private int idProgresoSesion;
    private int idSesion;
    private int idUsuarioCurso;
    private int progreso;
    private boolean completa;
    private LocalDateTime fechaCompletado;

    public int getIdProgresoSesion() {
        return idProgresoSesion;
    }

    public void setIdProgresoSesion(int idProgresoSesion) {
        this.idProgresoSesion = idProgresoSesion;
    }

    public int getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(int idSesion) {
        this.idSesion = idSesion;
    }

    public int getIdUsuarioCurso() {
        return idUsuarioCurso;
    }

    public void setIdUsuarioCurso(int idUsuarioCurso) {
        this.idUsuarioCurso = idUsuarioCurso;
    }

    public int getProgreso() {
        return progreso;
    }

    public void setProgreso(int progreso) {
        this.progreso = progreso;
    }

    public boolean isCompleta() {
        return completa;
    }

    public void setCompleta(boolean completa) {
        this.completa = completa;
    }

    public LocalDateTime getFechaCompletado() {
        return fechaCompletado;
    }

    public void setFechaCompletado(LocalDateTime fechaCompletado) {
        this.fechaCompletado = fechaCompletado;
    }
}