package com.avance.avancetb.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Alerta")
public class Alerta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAlerta;

    @Column(name = "fechaHoraAlerta", nullable = false)
    private LocalDateTime fechaHoraAlerta;

    @Column(name = "fechaHoraAtendida")
    private LocalDateTime fechaHoraAtendida;

    @Column(name = "estadoAlerta", length = 50, nullable = false)
    private String estadoAlerta;

    @Column(name = "observacion", columnDefinition = "TEXT", nullable = false)
    private String observacion;

    @Column(name = "tipoAlerta", length = 50)
    private String tipoAlerta;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    public Alerta() {
    }

    public Alerta(int idAlerta, LocalDateTime fechaHoraAlerta, LocalDateTime fechaHoraAtendida, String estadoAlerta, String observacion, String tipoAlerta, Usuario usuario) {
        this.idAlerta = idAlerta;
        this.fechaHoraAlerta = fechaHoraAlerta;
        this.fechaHoraAtendida = fechaHoraAtendida;
        this.estadoAlerta = estadoAlerta;
        this.observacion = observacion;
        this.tipoAlerta = tipoAlerta;
        this.usuario = usuario;
    }

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
