/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santamariaapostol.service;

import com.santamariaapostol.entity.Alumno;
import com.santamariaapostol.entity.Asistencia;
import com.santamariaapostol.entity.Profesor;
import com.santamariaapostol.persistence.AlumnoDAO;
import com.santamariaapostol.persistence.AsistenciaDAO;
import com.santamariaapostol.persistence.mysql_impl.AlumnoDAOMySQLImpl;
import com.santamariaapostol.persistence.mysql_impl.AsistenciaDAOMySQLImpl;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alonsorn
 */
public class AsistenciaService {
    
    private AlumnoDAO alumnoDAO;
    private AsistenciaDAO asistenciaDAO;

    public AsistenciaService() {
        asistenciaDAO = new AsistenciaDAOMySQLImpl();
        alumnoDAO = new AlumnoDAOMySQLImpl();
    }
    
    public List<Alumno> asistenciaDeHoy(Profesor profesor){
        int idProfesor = profesor.getIdProfesor();
        List<Alumno> alumnos = alumnoDAO.buscarPorProfesor(idProfesor);
        
        for(Alumno a : alumnos){
            Asistencia hoy = asistenciaDAO.asistenciaHoyAlumno(a.getIdAlumno());
            if(hoy==null){
                LocalDateTime now = LocalDateTime.now();
                int day = now.getDayOfMonth();
                int month = now.getMonthValue();
                int year = now.getYear();
                String date = year + " " + month + " " + day;
                
                hoy = new Asistencia();
                hoy.setMatricula(a.getMatriculas().get(0));
                hoy.setFecha(date);
                
                asistenciaDAO.crear(hoy);
            }
            List<Asistencia> asistencias = new ArrayList<>();
            asistencias.add(hoy);
            a.getMatriculas().get(0).setAsistencias(asistencias);
        }
        
        return alumnos;
    }
    
}
