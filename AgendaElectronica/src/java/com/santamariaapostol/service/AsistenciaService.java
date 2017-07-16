/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santamariaapostol.service;

import com.santamariaapostol.entity.Alumno;
import com.santamariaapostol.entity.Apoderado;
import com.santamariaapostol.entity.Asistencia;
import com.santamariaapostol.entity.Matricula;
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
    
    public List<Alumno> buscarAsistenciaDeHoyProfesor(Profesor profesor){
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
    
    public List<Alumno> buscarAsistenciaDeHoyApoderado(Apoderado apoderado){
        int idApoderado = apoderado.getIdApoderado();
        List<Alumno> alumnos = alumnoDAO.buscarPorApoderado(idApoderado);
        for(Alumno a: alumnos){
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
            List<Matricula> matriculas = new ArrayList<>();
            Matricula matricula = new Matricula();
            matriculas.add(matricula);
            a.setMatriculas(matriculas);
            a.getMatriculas().get(0).setAsistencias(asistencias);
        }
        return alumnos;
    }
    
    public void guardarAsistenciaDeHoy(List<Alumno> alumnos){
        Asistencia asistenciaHoy;
        for(Alumno a: alumnos){
            asistenciaHoy = a.getMatriculas().get(0).getAsistencias().get(0);
            asistenciaDAO.actualizar(asistenciaHoy);
        }
    }
    
    
}
