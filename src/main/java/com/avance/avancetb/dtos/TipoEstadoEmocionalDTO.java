package com.avance.avancetb.dtos;


public class TipoEstadoEmocionalDTO {
    private int idTipoEst;
    private String nombreTipoEst;
    private String descripcionTipoEst;
    private String iconoTipoEst;

    public int getIdTipoEst() {
        return idTipoEst;
    }

    public void setIdTipoEst(int idTipoEst) {
        this.idTipoEst = idTipoEst;
    }

    public String getNombreTipoEst() {
        return nombreTipoEst;
    }

    public void setNombreTipoEst(String nombreTipoEst) {
        this.nombreTipoEst = nombreTipoEst;
    }

    public String getDescripcionTipoEst() {
        return descripcionTipoEst;
    }

    public void setDescripcionTipoEst(String descripcionTipoEst) {
        this.descripcionTipoEst = descripcionTipoEst;
    }

    public String getIconoTipoEst() {
        return iconoTipoEst;
    }

    public void setIconoTipoEst(String iconoTipoEst) {
        this.iconoTipoEst = iconoTipoEst;
    }
}
