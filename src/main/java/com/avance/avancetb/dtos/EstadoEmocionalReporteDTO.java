package com.avance.avancetb.dtos;

public class EstadoEmocionalReporteDTO {
    private String dia;
    private double promedioBienestar;

    public EstadoEmocionalReporteDTO() {
    }

    public EstadoEmocionalReporteDTO(String dia, double promedioBienestar) {
        this.dia = dia;
        this.promedioBienestar = promedioBienestar;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public double getPromedioBienestar() {
        return promedioBienestar;
    }

    public void setPromedioBienestar(double promedioBienestar) {
        this.promedioBienestar = promedioBienestar;
    }
}
