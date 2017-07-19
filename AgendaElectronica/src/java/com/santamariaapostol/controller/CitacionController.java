/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santamariaapostol.controller;

import com.santamariaapostol.entity.Alumno;
import com.santamariaapostol.entity.Citacion;
import com.santamariaapostol.entity.Profesor;
import com.santamariaapostol.service.CitacionService;
import com.santamariaapostol.util.PageHelper;
import com.santamariaapostol.util.SessionStringHelpers;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author alonsorn
 */
public class CitacionController extends HttpServlet {

    private final CitacionService citacionService;

    public CitacionController() {
        citacionService = new CitacionService();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("decide")) {
            redireccionarPorTipoUsuario(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("identificar_alumno")) {
            solicitarNuevaCitacion(request, response);
        } else if (action.equals("nuevo")) {
            nuevaCitacion(request, response);
        }

    }

    private void mostrarListaAlumnos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Profesor profesor = (Profesor) session.getAttribute(SessionStringHelpers.USUARIO);

        List<Alumno> alumnos = citacionService.listaDeAlumnos(profesor);
        session.setAttribute(SessionStringHelpers.LISTA_ALUMNOS, alumnos);
        response.sendRedirect(PageHelper.LISTADO_ALUMNOS_CITACION);
    }

    private void solicitarNuevaCitacion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int idAlumno = Integer.parseInt(request.getParameter("idAlumno"));
        session.setAttribute(SessionStringHelpers.ID_ALUMNO, idAlumno);
        response.sendRedirect(PageHelper.NUEVA_CITACION);
    }

    private void nuevaCitacion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int idAlumno = Integer.parseInt(session.getAttribute(SessionStringHelpers.ID_ALUMNO).toString());
        String titulo = request.getParameter("titulo");
        String cuerpo = request.getParameter("cuerpo");

        Alumno alumno = new Alumno();
        alumno.setIdAlumno(idAlumno);

        Profesor profesor = (Profesor) session.getAttribute(SessionStringHelpers.USUARIO);

        Citacion citacion = new Citacion();
        citacion.setTitulo(titulo);
        citacion.setCuerpo(cuerpo);

        citacionService.nuevaCitacion(citacion, profesor, alumno);
        session.setAttribute(SessionStringHelpers.MESSAGE, SessionStringHelpers.CITACION_ENVIADA_MENSAJE);
        response.sendRedirect(PageHelper.LISTADO_ALUMNOS_CITACION);

    }

    private void redireccionarPorTipoUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String tipoUsuario = session.getAttribute(SessionStringHelpers.TIPO_USUARIO).toString();
        if (tipoUsuario.equals("profesor")) {
            mostrarListaAlumnos(request, response);
            response.sendRedirect(PageHelper.LISTADO_ASISTENCIA);
        } else if (tipoUsuario.equals("apoderado")) {
            response.sendRedirect(PageHelper.DASHBOARD);
        }
    }

}
