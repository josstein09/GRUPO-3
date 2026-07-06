package com.avance.avancetb.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Formulario")
public class Formulario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFormulario;




    @Column(name = "mensaje", length = 100, nullable = false)
    private String mensaje;

    @Column(name = "correo", length = 100, nullable = false)
    private String correo;

    @ManyToOne
    @JoinColumn(name = "Id_Usuario")
    private Usuario usuario;





    public Formulario() {

    }

    public Formulario(int idFormulario, String mensaje, String correo, Usuario usuario) {
        this.idFormulario = idFormulario;
        this.mensaje = mensaje;
        this.correo = correo;
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getIdFormulario() {
        return idFormulario;
    }

    public void setIdFormulario(int idFormulario) {
        this.idFormulario = idFormulario;
    }
}
