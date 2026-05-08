package com.avance.avancetb.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "TipoEstadoEmocional")
public class TipoEstadoEmocionalEntities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoEst;

    @Column(name = "nombreTipoEst",length = 50,nullable = false)
    private String nombreTipoEst;

    @Column(name = "descripcionTipoEst",length = 100,nullable = false)
    private String descripcionTipoEst;

    @Column(name = "iconoTipoEst",length = 50,nullable = false)
    private String iconoTipoEst;

    public TipoEstadoEmocionalEntities() {
    }

    public TipoEstadoEmocionalEntities(int idTipoEst, String nombreTipoEst, String descripcionTipoEst, String iconoTipoEst) {
        this.idTipoEst = idTipoEst;
        this.nombreTipoEst = nombreTipoEst;
        this.descripcionTipoEst = descripcionTipoEst;
        this.iconoTipoEst = iconoTipoEst;
    }

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
