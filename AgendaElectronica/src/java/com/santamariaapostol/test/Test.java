/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santamariaapostol.test;

import com.santamariaapostol.entity.Alumno;
import com.santamariaapostol.entity.Apoderado;
import com.santamariaapostol.entity.Profesor;
import com.santamariaapostol.persistence.AlumnoDAO;
import com.santamariaapostol.persistence.ApoderadoDAO;
import com.santamariaapostol.persistence.mysql_impl.AlumnoDAOMySQLImpl;
import com.santamariaapostol.persistence.mysql_impl.ApoderadoDAOMySQLImpl;
import com.santamariaapostol.service.AsistenciaService;
import java.util.ArrayList;
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
        ApoderadoDAO apoderadoDAO = new ApoderadoDAOMySQLImpl();
        Apoderado apoderado = new Apoderado();
        
        apoderado = apoderadoDAO.buscarPorAlumno(1);
        
        System.out.println(apoderado.getIdApoderado());
    }
    
}
