package com.avance.avancetb.dtos;

public class ConfiguracionAplicacionDTO {
    private int idConfigAcces;
    private int tamanoTexto;
    private boolean lecturaAutomatica;
    private int contraste;
    private boolean modoOscuro;
    private String canalDeNotiPref;
    private int idUsuario;

    public int getIdConfigAcces() {
        return idConfigAcces;
    }

    public void setIdConfigAcces(int idConfigAcces) {
        this.idConfigAcces = idConfigAcces;
    }

    public int getTamanoTexto() {
        return tamanoTexto;
    }

    public void setTamanoTexto(int tamanoTexto) {
        this.tamanoTexto = tamanoTexto;
    }

    public boolean isLecturaAutomatica() {
        return lecturaAutomatica;
    }

    public void setLecturaAutomatica(boolean lecturaAutomatica) {
        this.lecturaAutomatica = lecturaAutomatica;
    }

    public int getContraste() {
        return contraste;
    }

    public void setContraste(int contraste) {
        this.contraste = contraste;
    }

    public boolean isModoOscuro() {
        return modoOscuro;
    }

    public void setModoOscuro(boolean modoOscuro) {
        this.modoOscuro = modoOscuro;
    }

    public String getCanalDeNotiPref() {
        return canalDeNotiPref;
    }

    public void setCanalDeNotiPref(String canalDeNotiPref) {
        this.canalDeNotiPref = canalDeNotiPref;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
