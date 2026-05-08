package com.avance.avancetb.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Usuario") 
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @Column(name = "tokenUnico", length = 255, nullable = false)
    private String tokenUnico;

    @Column(name = "username", length = 150, nullable = false)
    private String username;

    @Column(name = "dni", nullable = false)
    private String dni;

    @Column(name = "apellidoPaterno", length = 150, nullable = false)
    private String apellidoPaterno;

    @Column(name = "apellidoMaterno", length = 150, nullable = false)
    private String apellidoMaterno;

    @Column(name = "autorizacionFamiliar")
    private Boolean autorizacionFamiliar;

    @Column(name = "fechaNacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(name = "contrasena", length = 150, nullable = false)
    private String contrasena;

    @Column(name = "estadoCuenta", length = 150, nullable = false)
    private String estadoCuenta;

    @Column(name = "fechaPrimerAcceso", nullable = false)
    private LocalDate fechaPrimerAcceso;

    @Column(name = "tutorialCompletado", nullable = false)
    private boolean tutorialCompletado;

    @Column(name = "fotoPerfil", length = 255, nullable = false)
    private String fotoPerfil;

    @ManyToOne
    @JoinColumn(name = "idRol", nullable = false)
    private Rol rol;

    @OneToMany(mappedBy = "usuario")
    private List<UsuarioCurso> usuarioCurso;
 
    public Usuario() {}

    public Usuario(int idUsuario, String tokenUnico, String username, String dni, String apellidoPaterno, String apellidoMaterno, Boolean autorizacionFamiliar, LocalDate fechaNacimiento, String contrasena, String estadoCuenta, LocalDate fechaPrimerAcceso, boolean tutorialCompletado, String fotoPerfil, Rol rol) {
        this.idUsuario = idUsuario;
        this.tokenUnico = tokenUnico;
        this.username = username;
        this.dni = dni;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.autorizacionFamiliar = autorizacionFamiliar;
        this.fechaNacimiento = fechaNacimiento;
        this.contrasena = contrasena;
        this.estadoCuenta = estadoCuenta;
        this.fechaPrimerAcceso = fechaPrimerAcceso;
        this.tutorialCompletado = tutorialCompletado;
        this.fotoPerfil = fotoPerfil;
        this.rol = rol;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTokenUnico() {
        return tokenUnico;
    }

    public void setTokenUnico(String tokenUnico) {
        this.tokenUnico = tokenUnico;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Boolean getAutorizacionFamiliar() {
        return autorizacionFamiliar;
    }

    public void setAutorizacionFamiliar(Boolean autorizacionFamiliar) {
        this.autorizacionFamiliar = autorizacionFamiliar;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEstadoCuenta() {
        return estadoCuenta;
    }

    public void setEstadoCuenta(String estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }

    public LocalDate getFechaPrimerAcceso() {
        return fechaPrimerAcceso;
    }

    public void setFechaPrimerAcceso(LocalDate fechaPrimerAcceso) {
        this.fechaPrimerAcceso = fechaPrimerAcceso;
    }

    public boolean isTutorialCompletado() {
        return tutorialCompletado;
    }

    public void setTutorialCompletado(boolean tutorialCompletado) {
        this.tutorialCompletado = tutorialCompletado;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}


