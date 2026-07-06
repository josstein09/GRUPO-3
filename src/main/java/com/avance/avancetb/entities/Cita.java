package com.avance.avancetb.entities;


import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Cita")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private int idCita;

    @Column(name = "fecha_cita", nullable = false)
    private LocalDate fechaCita;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String motivo;

    @Column(name = "hora_cita", nullable = false)
    private LocalTime horaCita;

    @Column(name = "estado_cita", nullable = false)
    private String estadoCita;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;


    public Cita() {
    }

    public Cita(int idCita, Usuario usuarioEmisor, Usuario usuarioReceptor, LocalDate fechaCita, String motivo, LocalTime horaCita, String estadoCita) {
        this.idCita = idCita;
        this.fechaCita = fechaCita;
        this.motivo = motivo;
        this.horaCita = horaCita;
        this.estadoCita = estadoCita;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public LocalDate getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(LocalDate fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public LocalTime getHoraCita() {
        return horaCita;
    }

    public void setHoraCita(LocalTime horaCita) {
        this.horaCita = horaCita;
    }

    public String getEstadoCita() {
        return estadoCita;
    }

    public void setEstadoCita(String estadoCita) {
        this.estadoCita = estadoCita;
    }
}