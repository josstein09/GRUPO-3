package com.avance.avancetb.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "ConfiguracionAplicacion")
public class ConfiguracionAplicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idConfigAcces;

    @Column(name = "tamanoTexto", nullable = false)
    private int tamanoTexto;

    @Column(name = "lecturaAutomatica", nullable = false)
    private boolean lecturaAutomatica;

    @Column(name = "contraste", nullable = false)
    private int contraste;

    @Column(name = "modoOscuro", nullable = false)
    private boolean modoOscuro;

    @Column(name = "canalDeNotiPref", length = 150)
    private String canalDeNotiPref;

    @OneToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    public ConfiguracionAplicacion() {}

    public ConfiguracionAplicacion(int idConfigAcces, int tamanoTexto, boolean lecturaAutomatica, int contraste, boolean modoOscuro, String canalDeNotiPref, Usuario usuario) {
        this.idConfigAcces = idConfigAcces;
        this.tamanoTexto = tamanoTexto;
        this.lecturaAutomatica = lecturaAutomatica;
        this.contraste = contraste;
        this.modoOscuro = modoOscuro;
        this.canalDeNotiPref = canalDeNotiPref;
        this.usuario = usuario;
    }

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
