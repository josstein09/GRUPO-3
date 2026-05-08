package com.avance.avancetb.dtos;

import jakarta.persistence.Column;

public class FormularioDTO {

    private String Id_Formulario;

    private String mensaje;
    private String correo;

    public String getId_Formulario() {
        return Id_Formulario;
    }

    public void setId_Formulario(String id_Formulario) {
        Id_Formulario = id_Formulario;
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
