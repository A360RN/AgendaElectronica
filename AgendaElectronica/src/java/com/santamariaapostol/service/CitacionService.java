/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santamariaapostol.service;

import com.santamariaapostol.entity.Alumno;
import com.santamariaapostol.entity.Apoderado;
import com.santamariaapostol.entity.Citacion;
import com.santamariaapostol.entity.Profesor;
import com.santamariaapostol.persistence.AlumnoDAO;
import com.santamariaapostol.persistence.ApoderadoDAO;
import com.santamariaapostol.persistence.CitacionDAO;
import com.santamariaapostol.persistence.mysql_impl.AlumnoDAOMySQLImpl;
import com.santamariaapostol.persistence.mysql_impl.ApoderadoDAOMySQLImpl;
import com.santamariaapostol.persistence.mysql_impl.CitacionDAOMySQLImpl;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alonsorn
 */
public class CitacionService {
    
    private final CitacionDAO citacionDAO;
    private final AlumnoDAO alumnoDAO;
    private final ApoderadoDAO apoderadoDAO;

    public CitacionService() {
        citacionDAO = new CitacionDAOMySQLImpl();
        alumnoDAO = new AlumnoDAOMySQLImpl();
        apoderadoDAO = new ApoderadoDAOMySQLImpl();
    }
    
    public List<Alumno> listaDeAlumnos(Profesor profesor){
        int idProfesor = profesor.getIdProfesor();
        List<Alumno> alumnos = alumnoDAO.buscarPorProfesor(idProfesor);
        
        return alumnos;
    }
    
    public void nuevaCitacion(Citacion citacion, Profesor profesor, Alumno alumno){
        int idAlumno = alumno.getIdAlumno();       
        Apoderado apoderado = apoderadoDAO.buscarPorAlumno(idAlumno);
        
        citacion.setApoderado(apoderado);
        citacion.setProfesor(profesor);
        
        citacionDAO.crear(citacion);
    }
}
