package com.avance.avancetb.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Sesion")
public class Sesion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_Sesion;

    @Column(name = "orden_curso", nullable = false)
    private int orden_curso;

    @Column(name = "descripcion_Sesion", nullable = false, length = 250)
    private String descripcion_Sesion;

    @Column(name = "titulo_sesion", nullable = false, length = 250)
    private String titulo_sesion;


    @ManyToOne
    @JoinColumn(name = "idCursos", nullable = false)
    private Cursos cursos;

    public Sesion(int ID_Sesion, int orden_curso, String descripcion_Sesion, String titulo_sesion, Cursos cursos) {
        this.ID_Sesion = ID_Sesion;
        this.orden_curso = orden_curso;
        this.descripcion_Sesion = descripcion_Sesion;
        this.titulo_sesion = titulo_sesion;
        this.cursos = cursos;
    }

    public Sesion() {

    }

    public Cursos getCursos() {
        return cursos;
    }

    public void setCursos(Cursos cursos) {
        this.cursos = cursos;
    }

    public int getID_Sesion() {
        return ID_Sesion;
    }

    public void setID_Sesion(int ID_Sesion) {
        this.ID_Sesion = ID_Sesion;
    }

    public int getOrden_curso() {
        return orden_curso;
    }

    public void setOrden_curso(int orden_curso) {
        this.orden_curso = orden_curso;
    }

    public String getDescripcion_Sesion() {
        return descripcion_Sesion;
    }

    public void setDescripcion_Sesion(String descripcion_Sesion) {
        this.descripcion_Sesion = descripcion_Sesion;
    }

    public String getTitulo_sesion() {
        return titulo_sesion;
    }

    public void setTitulo_sesion(String titulo_sesion) {
        this.titulo_sesion = titulo_sesion;
    }
}
