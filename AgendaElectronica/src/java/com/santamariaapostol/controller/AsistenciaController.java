/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santamariaapostol.controller;

import com.santamariaapostol.entity.Alumno;
import com.santamariaapostol.entity.Apoderado;
import com.santamariaapostol.entity.Profesor;
import com.santamariaapostol.service.AsistenciaService;
import com.santamariaapostol.util.PageHelper;
import com.santamariaapostol.util.SessionStringHelpers;
import java.io.IOException;
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
public class AsistenciaController extends HttpServlet {

    private final AsistenciaService asistenciaService;

    public AsistenciaController() {
        asistenciaService = new AsistenciaService();
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
        if (action.equals("guardar_lista")) {
            guardarAsistencia(request, response);
        }
    }

    private void redireccionarPorTipoUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String tipoUsuario = session.getAttribute(SessionStringHelpers.TIPO_USUARIO).toString();
        if (tipoUsuario.equals("profesor")) {
            listarAsistencia(session);
            response.sendRedirect(PageHelper.LISTADO_ASISTENCIA);
        } else if (tipoUsuario.equals("apoderado")) {
            miAsistencia(session);
            response.sendRedirect(PageHelper.DASHBOARD_APODERADO_ASISTENCIA);
        }
    }

    private void miAsistencia(HttpSession session) {
        Apoderado apoderado = (Apoderado)session.getAttribute(SessionStringHelpers.USUARIO);
        List<Alumno> alumnos = asistenciaService.buscarAsistenciaDeHoyApoderado(apoderado);
        session.setAttribute(SessionStringHelpers.LISTA_ALUMNOS, alumnos);
    }

    private void listarAsistencia(HttpSession session)
            throws ServletException, IOException {
        Profesor profesor = (Profesor) session.getAttribute(SessionStringHelpers.USUARIO);
        List<Alumno> alumnos = asistenciaService.buscarAsistenciaDeHoyProfesor(profesor);
        session.setAttribute(SessionStringHelpers.LISTA_ALUMNOS, alumnos);
    }

    private void guardarAsistencia(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        List<Alumno> alumnos = (List<Alumno>) session.getAttribute(SessionStringHelpers.LISTA_ALUMNOS);
        for (Alumno a : alumnos) {
            String estadoAsistencia = request.getParameter("btn" + a.getIdAlumno());
            a.getMatriculas().get(0).getAsistencias().get(0).setEstado(estadoAsistencia);
        }
        asistenciaService.guardarAsistenciaDeHoy(alumnos);
        session.setAttribute(SessionStringHelpers.MESSAGE, SessionStringHelpers.ASISTENCIA_GUARDADA_MENSAJE);
        response.sendRedirect(PageHelper.DASHBOARD);
    }

}
