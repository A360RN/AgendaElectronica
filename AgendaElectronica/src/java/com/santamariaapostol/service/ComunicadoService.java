/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santamariaapostol.service;

import com.santamariaapostol.entity.Alumno;
import com.santamariaapostol.entity.Apoderado;
import com.santamariaapostol.entity.Comunicado;
import com.santamariaapostol.entity.Matricula;
import com.santamariaapostol.entity.Profesor;
import com.santamariaapostol.entity.Seccion;
import com.santamariaapostol.persistence.AlumnoDAO;
import com.santamariaapostol.persistence.ComunicadoDAO;
import com.santamariaapostol.persistence.SeccionDAO;
import com.santamariaapostol.persistence.mysql_impl.AlumnoDAOMySQLImpl;
import com.santamariaapostol.persistence.mysql_impl.ComunicadoDAOMySQLImpl;
import com.santamariaapostol.persistence.mysql_impl.SeccionDAOMySQLImpl;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alonsorn
 */
public class ComunicadoService {

    private SeccionDAO seccionDAO;
    private ComunicadoDAO comunicadoDAO;
    private AlumnoDAO alumnoDAO;

    public ComunicadoService() {
        seccionDAO = new SeccionDAOMySQLImpl();
        comunicadoDAO = new ComunicadoDAOMySQLImpl();
        alumnoDAO = new AlumnoDAOMySQLImpl();
    }

    public void nuevoComunicado(Profesor profesor, Comunicado comunicado) {
        int idProfesor = profesor.getIdProfesor();

        Seccion seccion = seccionDAO.buscarPorProfesor(idProfesor);

        if (seccion != null) {
            comunicado.setSeccion(seccion);
            comunicadoDAO.crear(comunicado);
        }
    }

    public List<Comunicado> ultimosComunicadosEnviados(Profesor profesor) {
        List<Comunicado> listaComunicados = new ArrayList<>();
        int idProfesor = profesor.getIdProfesor();

        Seccion seccion = seccionDAO.buscarPorProfesor(idProfesor);

        if (seccion != null) {
            listaComunicados = comunicadoDAO.ultimosComunicadosEnviados(seccion.getIdSeccion());
        }
        return listaComunicados;

    }
    
    public List<Alumno> ultimosComunicadosRecibidos(Apoderado apoderado){
        int idApoderado = apoderado.getIdApoderado();
        List<Alumno> alumnos = alumnoDAO.buscarPorApoderado(idApoderado);
        
        for(Alumno a : alumnos){
            List<Comunicado> comunicados = comunicadoDAO.comunicadosPorAlumno(a.getIdAlumno());
            List<Matricula> matriculas = new ArrayList<>();
            Matricula matriculaActual = new Matricula();
            Seccion seccionActual = new Seccion();
            seccionActual.setComunicados(comunicados);
            matriculaActual.setSeccion(seccionActual);
            matriculas.add(matriculaActual);
            a.setMatriculas(matriculas);
        }
        return alumnos;
    }
}
