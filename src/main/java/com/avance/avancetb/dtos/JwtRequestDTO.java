package com.avance.avancetb.dtos;

public class JwtRequestDTO {
    private String username;
    private String contrasena;
    public JwtRequestDTO() {
        super();
        // TODO Auto-generated constructor stub
    }

    public JwtRequestDTO(String username, String contrasena) {
        super();
        this.username = username;
        this.contrasena = contrasena;
    }
    public String getUsername() {
        return username;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
