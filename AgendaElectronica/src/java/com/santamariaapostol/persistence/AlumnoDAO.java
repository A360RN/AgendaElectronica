/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santamariaapostol.persistence;

import com.santamariaapostol.entity.Alumno;
import java.util.List;

/**
 *
 * @author alonsorn
 */
public interface AlumnoDAO extends GenericDAO<Alumno>{
    
    public List<Alumno> buscarPorApoderado(int idApoderado);
    
    public List<Alumno> buscarPorProfesor(int idProfesor);
}
