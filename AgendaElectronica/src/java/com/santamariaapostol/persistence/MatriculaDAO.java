/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santamariaapostol.persistence;

import com.santamariaapostol.entity.Matricula;
import java.util.List;

/**
 *
 * @author alonsorn
 */
public interface MatriculaDAO extends GenericDAO<Matricula>{
    
    public List<Matricula> buscarUltimaMatriculaAlumno(int idAlumno);
}
