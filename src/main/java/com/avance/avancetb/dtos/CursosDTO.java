package com.avance.avancetb.dtos;

public class CursosDTO {
    private int idCursos;
    private String tipoCurso;
    private String nombreCurso;
    private String descripcion;
    private String objetivos;
    private int idPerfilProfesional;

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

    public int getIdPerfilProfesional() {
        return idPerfilProfesional;
    }

    public void setIdPerfilProfesional(int idPerfilProfesional) {
        this.idPerfilProfesional = idPerfilProfesional;
    }
}
