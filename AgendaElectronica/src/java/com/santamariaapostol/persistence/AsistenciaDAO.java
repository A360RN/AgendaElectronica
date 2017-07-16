/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santamariaapostol.persistence;

import com.santamariaapostol.entity.Asistencia;

/**
 *
 * @author alonsorn
 */
public interface AsistenciaDAO extends GenericDAO<Asistencia>{
    
    public Asistencia asistenciaHoyAlumno(int idAlumno);
}
