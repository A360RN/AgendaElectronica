/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santamariaapostol.service;

import com.santamariaapostol.entity.Apoderado;
import com.santamariaapostol.entity.Profesor;
import com.santamariaapostol.persistence.ApoderadoDAO;
import com.santamariaapostol.persistence.ProfesorDAO;
import com.santamariaapostol.persistence.mysql_impl.ApoderadoDAOMySQLImpl;
import com.santamariaapostol.persistence.mysql_impl.ProfesorDAOMySQLImpl;

/**
 *
 * @author alonsorn
 */
public class LoginService {

    private ProfesorDAO profesorDAO;
    private ApoderadoDAO apoderadoDAO;

    public LoginService() {
        profesorDAO = new ProfesorDAOMySQLImpl();
        apoderadoDAO = new ApoderadoDAOMySQLImpl();
    }

    public Profesor validarProfesor(Profesor profesor) {
        String usuario = profesor.getUsuario();
        String passwordPosible = profesor.getPassword();

        Profesor profesorObtenido = profesorDAO.buscarPorUsuario(usuario);

        if (profesorObtenido != null ) {
            String passwordReal = profesorObtenido.getPassword();
            if(passwordReal.equals(passwordPosible)){
                return profesorObtenido;
            }
        }
        return null;
    }

    public Apoderado validarApoderado(Apoderado apoderado) {
        String usuario = apoderado.getUsuario();
        String passwordPosible = apoderado.getPassword();

        Apoderado apoderadoObtenido = apoderadoDAO.buscarPorUsuario(usuario);

        if (apoderadoObtenido != null) {
            String passwordReal = apoderadoObtenido.getPassword();
            if(passwordReal.equals(passwordPosible)){
                return apoderadoObtenido;
            }
        }
        return null;
    }
}
