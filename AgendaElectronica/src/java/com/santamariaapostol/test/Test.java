/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santamariaapostol.test;

import com.santamariaapostol.entity.Alumno;
import com.santamariaapostol.entity.Profesor;
import com.santamariaapostol.persistence.AlumnoDAO;
import com.santamariaapostol.persistence.mysql_impl.AlumnoDAOMySQLImpl;
import com.santamariaapostol.service.AsistenciaService;
import java.util.List;

/**
 *
 * @author alonsorn
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AlumnoDAO alumnoDAO = new AlumnoDAOMySQLImpl();
        AsistenciaService asistenciaService = new AsistenciaService();
        Profesor profesor = new Profesor();
        profesor.setIdProfesor(5);
        List<Alumno> listaAlumnos = asistenciaService.buscarAsistenciaDeHoyProfesor(profesor);
    }
    
}
