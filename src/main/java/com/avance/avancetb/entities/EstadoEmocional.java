package com.avance.avancetb.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "EstadoEmocional")
public class EstadoEmocional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEstadoEmocional;

    @Column(name = "fechaRegistro", nullable = false)
    private LocalDateTime fechaRegistro;

    @Column(name = "nivelBienestar", nullable = false)
    private int nivelBienestar;

    @Column(name = "tipoEstadoEmocional", length = 30)
    private String tipoEstadoEmocional;

    @Column(name = "observacion", length = 200, nullable = false)
    private String observacion;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idPerfilProfesional", nullable = false)
    private PerfilProfesional perfilProfesional;

    public EstadoEmocional() {
    }

    public EstadoEmocional(int idEstadoEmocional, LocalDateTime fechaRegistro, int nivelBienestar, String tipoEstadoEmocional, String observacion, Usuario usuario, PerfilProfesional perfilProfesional) {
        this.idEstadoEmocional = idEstadoEmocional;
        this.fechaRegistro = fechaRegistro;
        this.nivelBienestar = nivelBienestar;
        this.tipoEstadoEmocional = tipoEstadoEmocional;
        this.observacion = observacion;
        this.usuario = usuario;
        this.perfilProfesional = perfilProfesional;
    }

    public int getIdEstadoEmocional() {
        return idEstadoEmocional;
    }

    public void setIdEstadoEmocional(int idEstadoEmocional) {
        this.idEstadoEmocional = idEstadoEmocional;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public PerfilProfesional getPerfilProfesional() {
        return perfilProfesional;
    }

    public void setPerfilProfesional(PerfilProfesional perfilProfesional) {
        this.perfilProfesional = perfilProfesional;
    }
}
