/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santamariaapostol.service;

import com.santamariaapostol.entity.Comunicado;
import com.santamariaapostol.entity.Profesor;
import com.santamariaapostol.entity.Seccion;
import com.santamariaapostol.persistence.ComunicadoDAO;
import com.santamariaapostol.persistence.SeccionDAO;
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

    public ComunicadoService() {
        seccionDAO = new SeccionDAOMySQLImpl();
        comunicadoDAO = new ComunicadoDAOMySQLImpl();
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
}
