package com.avance.avancetb.dtos;

import java.time.LocalDateTime;

public class ProgresoSesionDTO {

    private int idProgresoSesion;
    private int idSesion;
    private int idUsuarioCurso;
    private int progreso;
    private boolean completa;
    private LocalDateTime fechaCompletado;

    public ProgresoSesionDTO() {
    }

    public ProgresoSesionDTO(int idProgresoSesion, int idSesion, int idUsuarioCurso, int progreso, boolean completa, LocalDateTime fechaCompletado) {
        this.idProgresoSesion = idProgresoSesion;
        this.idSesion = idSesion;
        this.idUsuarioCurso = idUsuarioCurso;
        this.progreso = progreso;
        this.completa = completa;
        this.fechaCompletado = fechaCompletado;
    }

    // Getters y Setters
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