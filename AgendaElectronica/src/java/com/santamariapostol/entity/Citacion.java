/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santamariapostol.entity;

import java.io.Serializable;

/**
 *
 * @author alonsorn
 */
public class Citacion implements Serializable {

    private int idCitacion;
    private String titulo;
    private String cuerpo;
    private int apoderadoConfirm;
    private int profesorConfirm;
    private Apoderado apoderado;
    private Profesor profesor;

    public Citacion() {
    }

    public int getIdCitacion() {
        return idCitacion;
    }

    public void setIdCitacion(int idCitacion) {
        this.idCitacion = idCitacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public int getApoderadoConfirm() {
        return apoderadoConfirm;
    }

    public void setApoderadoConfirm(int apoderadoConfirm) {
        this.apoderadoConfirm = apoderadoConfirm;
    }

    public int getProfesorConfirm() {
        return profesorConfirm;
    }

    public void setProfesorConfirm(int profesorConfirm) {
        this.profesorConfirm = profesorConfirm;
    }

    public Apoderado getApoderado() {
        return apoderado;
    }

    public void setApoderado(Apoderado apoderado) {
        this.apoderado = apoderado;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

}
