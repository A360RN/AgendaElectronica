/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santamariapostol.entity;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author alonsorn
 */
public class Seccion implements Serializable {

    private int idSeccion;
    private String letraSeccion;
    private Grado grado;
    private Profesor profesor;
    private List<Comunicado> comunicados;
    private List<Matricula> matriculas;

    public Seccion() {
    }

    public int getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(int idSeccion) {
        this.idSeccion = idSeccion;
    }

    public String getLetraSeccion() {
        return letraSeccion;
    }

    public void setLetraSeccion(String letraSeccion) {
        this.letraSeccion = letraSeccion;
    }

    public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public List<Comunicado> getComunicados() {
        return comunicados;
    }

    public void setComunicados(List<Comunicado> comunicados) {
        this.comunicados = comunicados;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

}
