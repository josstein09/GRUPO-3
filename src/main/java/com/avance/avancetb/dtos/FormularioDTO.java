package com.avance.avancetb.dtos;

import jakarta.persistence.Column;

public class FormularioDTO {

    private int Id_Formulario;
    private String nombre;
    private String mensaje;
    private String correo;

    public int getId_Formulario() {
        return Id_Formulario;
    }

    public void setId_Formulario(int id_Formulario) {
        Id_Formulario = id_Formulario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
