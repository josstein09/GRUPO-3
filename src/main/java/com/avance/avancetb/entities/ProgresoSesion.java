package com.avance.avancetb.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Progreso_Sesion")
public class ProgresoSesion {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "ID_Progreso_Sesion")
    private int idProgresoSesion;

    @Column(name = "Progreso")
    private int progreso;

    @Column(name = "Completa")
    private boolean completa;

    @Column(name = "Fecha_Completado")
    private LocalDateTime fechaCompletado;

    @ManyToOne
    @JoinColumn(name = "ID_Sesion", nullable = false)
    private Sesion sesion;

    @ManyToOne
    @JoinColumn(name = "ID_Usuario_Curso", nullable = false)
    private UsuarioCurso usuarioCurso;

    public ProgresoSesion() {
    }

    public ProgresoSesion(int idProgresoSesion, Sesion sesion, UsuarioCurso usuarioCurso, int progreso, boolean completa, LocalDateTime fechaCompletado) {
        this.idProgresoSesion = idProgresoSesion;
        this.sesion = sesion;
        this.usuarioCurso = usuarioCurso;
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

    public Sesion getSesion() {
        return sesion;
    }

    public void setSesion(Sesion sesion) {
        this.sesion = sesion;
    }

    public UsuarioCurso getUsuarioCurso() {
        return usuarioCurso;
    }

    public void setUsuarioCurso(UsuarioCurso usuarioCurso) {
        this.usuarioCurso = usuarioCurso;
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