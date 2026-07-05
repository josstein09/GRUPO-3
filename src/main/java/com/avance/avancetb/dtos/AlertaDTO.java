package com.avance.avancetb.dtos;

import java.time.LocalDateTime;

public class AlertaDTO {
    private int idAlerta;
    private LocalDateTime fechaHoraAlerta;
    private LocalDateTime fechaHoraAtendida;
    private String estadoAlerta;
    private String observacion;
    private String tipoAlerta;
    private int idUsuario;

    public int getIdAlerta() {
        return idAlerta;
    }

    public void setIdAlerta(int idAlerta) {
        this.idAlerta = idAlerta;
    }

    public LocalDateTime getFechaHoraAlerta() {
        return fechaHoraAlerta;
    }

    public void setFechaHoraAlerta(LocalDateTime fechaHoraAlerta) {
        this.fechaHoraAlerta = fechaHoraAlerta;
    }

    public LocalDateTime getFechaHoraAtendida() {
        return fechaHoraAtendida;
    }

    public void setFechaHoraAtendida(LocalDateTime fechaHoraAtendida) {
        this.fechaHoraAtendida = fechaHoraAtendida;
    }

    public String getEstadoAlerta() {
        return estadoAlerta;
    }

    public void setEstadoAlerta(String estadoAlerta) {
        this.estadoAlerta = estadoAlerta;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getTipoAlerta() {
        return tipoAlerta;
    }

    public void setTipoAlerta(String tipoAlerta) {
        this.tipoAlerta = tipoAlerta;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
