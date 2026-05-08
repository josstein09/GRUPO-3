package com.avance.avancetb.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "Rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int idRol;

    @Column(name = "nameRol",length = 50,nullable = false)
    private String nameRol;

    @Column(name = "descriptionRol",length = 100,nullable = false)
    private String descriptionRol;

    public Rol() {
    }

    public Rol(int idRol, String descriptionRol, String nameRol) {
        this.idRol = idRol;
        this.descriptionRol = descriptionRol;
        this.nameRol = nameRol;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNameRol() {
        return nameRol;
    }

    public void setNameRol(String nameRol) {
        this.nameRol = nameRol;
    }

    public String getDescriptionRol() {
        return descriptionRol;
    }

    public void setDescriptionRol(String descriptionRol) {
        this.descriptionRol = descriptionRol;
    }
}
