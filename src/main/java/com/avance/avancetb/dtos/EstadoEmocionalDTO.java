package com.avance.avancetb.dtos;

import java.time.LocalDateTime;

public class EstadoEmocionalDTO {
    private int idRegEst;
    private LocalDateTime fechaRegistro;
    private int nivelBienestar;
    private String tipoEstadoEmocional;
    private String observacion;
    private int idUsuario;
    private int idPerfilProfesional;

    public int getIdRegEst() {
        return idRegEst;
    }

    public void setIdRegEst(int idRegEst) {
        this.idRegEst = idRegEst;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getNivelBienestar() {
        return nivelBienestar;
    }

    public void setNivelBienestar(int nivelBienestar) {
        this.nivelBienestar = nivelBienestar;
    }

    public String getTipoEstadoEmocional() {
        return tipoEstadoEmocional;
    }

    public void setTipoEstadoEmocional(String tipoEstadoEmocional) {
        this.tipoEstadoEmocional = tipoEstadoEmocional;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdPerfilProfesional() {
        return idPerfilProfesional;
    }

    public void setIdPerfilProfesional(int idPerfilProfesional) {
        this.idPerfilProfesional = idPerfilProfesional;
    }
}
