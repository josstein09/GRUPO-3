package com.avance.avancetb.dtos;

public class PerfilProfesionalDTO {
    private int idPerfilProfesional;
    private String especialidad;
    private String biografia;
    private int idUsuario;

    public int getIdPerfilProfesional() {
        return idPerfilProfesional;
    }

    public void setIdPerfilProfesional(int idPerfilProfesional) {
        this.idPerfilProfesional = idPerfilProfesional;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
