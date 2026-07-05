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
@Table(name = "Usuario_Curso")
public class UsuarioCurso {
  
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int idUsuarioCurso;
    @Column(name = "fecha_ultimo_accesso")
    private LocalDateTime fechaUltimoAccesso;
    @Column(name = "fecha_asignacion")
    private LocalDateTime fechaAsignacion;
     
    @ManyToOne
    @JoinColumn(name = "ID_Cursos", nullable = false)
    private Cursos curso;

    @ManyToOne
    @JoinColumn(name = "ID_Usuario", nullable = false)
    private Usuario usuario;

    public UsuarioCurso() {
    }
    
    public UsuarioCurso(int idUsuarioCurso, Usuario usuario, Cursos curso, LocalDateTime fechaUltimoAccesso,
            LocalDateTime fechaAsignacion) {
        this.idUsuarioCurso = idUsuarioCurso;
        this.usuario = usuario;
        this.curso = curso;
        this.fechaUltimoAccesso = fechaUltimoAccesso;
        this.fechaAsignacion = fechaAsignacion;
    }


    public int getIdUsuarioCurso() {
        return idUsuarioCurso;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public Cursos getCurso() {
        return curso;
    }

    public LocalDateTime getFechaUltimoAccesso() {
        return fechaUltimoAccesso;
    }

    public LocalDateTime getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setIdUsuarioCurso(int idUsuarioCurso) {
        this.idUsuarioCurso = idUsuarioCurso;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }      

    public void setCurso(Cursos curso) {
        this.curso = curso;
    }

    public void setFechaUltimoAccesso(LocalDateTime fechaUltimoAccesso) {
        this.fechaUltimoAccesso = fechaUltimoAccesso;
    }   

    public void setFechaAsignacion(LocalDateTime fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

}
