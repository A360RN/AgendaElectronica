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
public class Bimestre implements Serializable {

    private int idBimestre;
    private int nroBimestre;
    private Periodo periodo;
    private List<Evaluacion> evaluaciones;

    public Bimestre() {
    }

    public int getIdBimestre() {
        return idBimestre;
    }

    public void setIdBimestre(int idBimestre) {
        this.idBimestre = idBimestre;
    }

    public int getNroBimestre() {
        return nroBimestre;
    }

    public void setNroBimestre(int nroBimestre) {
        this.nroBimestre = nroBimestre;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public List<Evaluacion> getEvaluaciones() {
        return evaluaciones;
    }

    public void setEvaluaciones(List<Evaluacion> evaluaciones) {
        this.evaluaciones = evaluaciones;
    }

}
