package com.avance.avancetb.entities;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "Cursos")
public class Cursos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCursos;

    @Column(name = "tipoCurso", nullable = false, length = 100)
    private String tipoCurso;

    @Column(name = "nombreCurso", nullable = false, length = 150)
    private String nombreCurso;

    @Column(name = "descripcion", nullable = false, columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "objetivos", nullable = false, columnDefinition = "TEXT")
    private String objetivos;

    @ManyToOne
    @JoinColumn(name = "idPerfilProfesional", nullable = false)
    private PerfilProfesional perfilProfesional;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UsuarioCurso> usuarioCurso;

    public Cursos() {}

    public Cursos(int idCursos, String tipoCurso, String nombreCurso, String descripcion, String objetivos, PerfilProfesional perfilProfesional) {
        this.idCursos = idCursos;
        this.tipoCurso = tipoCurso;
        this.nombreCurso = nombreCurso;
        this.descripcion = descripcion;
        this.objetivos = objetivos;
        this.perfilProfesional = perfilProfesional;
    }

    public int getIdCursos() {
        return idCursos;
    }

    public void setIdCursos(int idCursos) {
        this.idCursos = idCursos;
    }

    public String getTipoCurso() {
        return tipoCurso;
    }

    public void setTipoCurso(String tipoCurso) {
        this.tipoCurso = tipoCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
    }

    public PerfilProfesional getPerfilProfesional() {
        return perfilProfesional;
    }

    public void setPerfilProfesional(PerfilProfesional perfilProfesional) {
        this.perfilProfesional = perfilProfesional;
    }
}
