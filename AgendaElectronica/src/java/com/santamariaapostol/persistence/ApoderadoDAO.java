/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santamariaapostol.persistence;

import com.santamariaapostol.entity.Apoderado;
import java.util.List;

/**
 *
 * @author alonsorn
 */
public interface ApoderadoDAO extends GenericDAO<Apoderado>{
    
    public Apoderado buscarPorUsuario(String username);
    
    public Apoderado buscarPorAlumno(int idAlumno);
    
    public List<Apoderado> buscarPorProfesor(int idProfesor);
}
