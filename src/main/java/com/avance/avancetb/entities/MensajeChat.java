package com.avance.avancetb.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Mensaje_Chat")
public class MensajeChat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mensaje")
    private int idMensaje;

    @ManyToOne
    @JoinColumn(name = "id_usuario_emisor", nullable = false)
    private Usuario usuarioEmisor;

    @ManyToOne
    @JoinColumn(name = "id_usuario_receptor", nullable = false)
    private Usuario usuarioReceptor;

    @Column(name = "contenido_mensaje", nullable = false)
    private String contenidoMensaje;

    @Column(name = "fecha_envio", nullable = false)
    private LocalDate fechaEnvio;

    @Column(name = "hora_envio", nullable = false)
    private LocalTime horaEnvio;

    @Column(nullable = false)
    private boolean activo;

    @Column(nullable = false)
    private LocalTime programado;

    public MensajeChat() {
    }

    public MensajeChat(int idMensaje, Usuario usuarioEmisor, Usuario usuarioReceptor, String contenidoMensaje, LocalDate fechaEnvio, LocalTime horaEnvio, boolean activo, LocalTime programado) {
        this.idMensaje = idMensaje;
        this.usuarioEmisor = usuarioEmisor;
        this.usuarioReceptor = usuarioReceptor;
        this.contenidoMensaje = contenidoMensaje;
        this.fechaEnvio = fechaEnvio;
        this.horaEnvio = horaEnvio;
        this.activo = activo;
        this.programado = programado;
    }

    public int getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(int idMensaje) {
        this.idMensaje = idMensaje;
    }

    public Usuario getUsuarioEmisor() {
        return usuarioEmisor;
    }

    public void setUsuarioEmisor(Usuario usuarioEmisor) {
        this.usuarioEmisor = usuarioEmisor;
    }

    public Usuario getUsuarioReceptor() {
        return usuarioReceptor;
    }

    public void setUsuarioReceptor(Usuario usuarioReceptor) {
        this.usuarioReceptor = usuarioReceptor;
    }

    public String getContenidoMensaje() {
        return contenidoMensaje;
    }

    public void setContenidoMensaje(String contenidoMensaje) {
        this.contenidoMensaje = contenidoMensaje;
    }

    public LocalDate getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalDate fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public LocalTime getHoraEnvio() {
        return horaEnvio;
    }

    public void setHoraEnvio(LocalTime horaEnvio) {
        this.horaEnvio = horaEnvio;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public LocalTime getProgramado() {
        return programado;
    }

    public void setProgramado(LocalTime programado) {
        this.programado = programado;
    }
}
