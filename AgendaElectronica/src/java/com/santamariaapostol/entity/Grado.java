/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santamariaapostol.entity;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author alonsorn
 */
public class Grado implements Serializable {

    private int idGrado;
    private int nroGrado;
    private List<Seccion> secciones;

    public Grado() {
    }

    public int getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(int idGrado) {
        this.idGrado = idGrado;
    }

    public int getNroGrado() {
        return nroGrado;
    }

    public void setNroGrado(int nroGrado) {
        this.nroGrado = nroGrado;
    }

    public List<Seccion> getSecciones() {
        return secciones;
    }

    public void setSecciones(List<Seccion> secciones) {
        this.secciones = secciones;
    }

}
