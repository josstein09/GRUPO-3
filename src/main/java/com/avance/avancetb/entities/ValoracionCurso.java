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
@Table(name = "Valoracion_Curso")
public class ValoracionCurso {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int idValoracion;

    @Column(name = "fecha_valoracion")
    private LocalDateTime fechaValoracion;

    @Column(name = "calificacion")
    private int calificacion;

    @Column(name = "comentario", columnDefinition = "TEXT")
    private String comentario;

    @ManyToOne
    @JoinColumn(name = "ID_Usuario_Curso", nullable = false)
    private UsuarioCurso usuarioCurso;

    public ValoracionCurso() {
    }

    public ValoracionCurso(int idValoracion, UsuarioCurso usuarioCurso, LocalDateTime fechaValoracion, int calificacion, String comentario) {
        this.idValoracion = idValoracion;
        this.usuarioCurso = usuarioCurso;
        this.fechaValoracion = fechaValoracion;
        this.calificacion = calificacion;
        this.comentario = comentario;
    }

    public int getIdValoracion() {
        return idValoracion;
    }

    public UsuarioCurso getUsuarioCurso() {
        return usuarioCurso;
    }

    public LocalDateTime getFechaValoracion() {
        return fechaValoracion;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setIdValoracion(int idValoracion) {
        this.idValoracion = idValoracion;
    }

    public void setUsuarioCurso(UsuarioCurso usuarioCurso) {
        this.usuarioCurso = usuarioCurso;
    }

    public void setFechaValoracion(LocalDateTime fechaValoracion) {
        this.fechaValoracion = fechaValoracion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}