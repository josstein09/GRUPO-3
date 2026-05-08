package com.avance.avancetb.dtos;

public class PacienteOCursoDTOQuery {
    private String nombrePaciente;
    private String nombreCurso;
    private String especialidadRelacionada;


    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getEspecialidadRelacionada() {
        return especialidadRelacionada;
    }

    public void setEspecialidadRelacionada(String especialidadRelacionada) {
        this.especialidadRelacionada = especialidadRelacionada;
    }
}
