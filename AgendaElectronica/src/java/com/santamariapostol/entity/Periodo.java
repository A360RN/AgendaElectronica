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
public class Periodo implements Serializable{

    private int idPeriodo;
    private int anio;
    private String estado;
    private List<Bimestre> bimestres;
    private List<Matricula> matriculas;

    public Periodo() {
    }

    public int getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(int idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Bimestre> getBimestres() {
        return bimestres;
    }

    public void setBimestres(List<Bimestre> bimestres) {
        this.bimestres = bimestres;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

}
