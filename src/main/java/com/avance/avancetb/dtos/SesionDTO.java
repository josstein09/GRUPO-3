package com.avance.avancetb.dtos;

public class SesionDTO {

    private int ID_Sesion;


    private int orden_curso;


    private String descripcion_Sesion;


    private String titulo_sesion;

    private String idCursos;


    public String getIdCursos() {
        return idCursos;
    }

    public void setIdCursos(String idCursos) {
        this.idCursos = idCursos;
    }

    public int getID_Sesion() {
        return ID_Sesion;
    }

    public void setID_Sesion(int ID_Sesion) {
        this.ID_Sesion = ID_Sesion;
    }

    public int getOrden_curso() {
        return orden_curso;
    }

    public void setOrden_curso(int orden_curso) {
        this.orden_curso = orden_curso;
    }

    public String getDescripcion_Sesion() {
        return descripcion_Sesion;
    }

    public void setDescripcion_Sesion(String descripcion_Sesion) {
        this.descripcion_Sesion = descripcion_Sesion;
    }

    public String getTitulo_sesion() {
        return titulo_sesion;
    }

    public void setTitulo_sesion(String titulo_sesion) {
        this.titulo_sesion = titulo_sesion;
    }
}
