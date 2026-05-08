package com.avance.avancetb.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "PerfilProfesional")
public class PerfilProfesional {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPerfilProfesional;

    @Column(name = "especialidad",length = 50,nullable = false)
    private String especialidad;

    @Column(name = "biografia",length = 150,nullable = false)
    private String biografia;

    @OneToOne
    @JoinColumn(name = "idUsuario", nullable = false) // Ahora es una FK normal
    private Usuario usuario;

    public PerfilProfesional() {}

    public PerfilProfesional(int idPerfilProfesional, String especialidad, String biografia, Usuario usuario) {
        this.idPerfilProfesional = idPerfilProfesional;
        this.especialidad = especialidad;
        this.biografia = biografia;
        this.usuario = usuario;
    }

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
