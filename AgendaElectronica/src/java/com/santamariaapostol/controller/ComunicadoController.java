/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santamariaapostol.controller;

import com.santamariaapostol.entity.Alumno;
import com.santamariaapostol.entity.Apoderado;
import com.santamariaapostol.entity.Comunicado;
import com.santamariaapostol.entity.Profesor;
import com.santamariaapostol.service.ComunicadoService;
import com.santamariaapostol.util.PageHelper;
import com.santamariaapostol.util.SessionStringHelpers;
import java.io.IOException;
import java.io.PrintWriter;
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
public class ComunicadoController extends HttpServlet {

    private ComunicadoService comunicadoService;

    public ComunicadoController() {
        comunicadoService = new ComunicadoService();
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
        if (action.equals("nuevo")) {
            nuevoComunicado(request, response);
        }
    }

    private void nuevoComunicado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        Profesor profesor = (Profesor) session.getAttribute(SessionStringHelpers.USUARIO);
        Comunicado comunicado = new Comunicado();

        String titulo = request.getParameter("titulo");
        String cuerpo = request.getParameter("cuerpo");

        comunicado.setTitulo(titulo);
        comunicado.setCuerpo(cuerpo);

        comunicadoService.nuevoComunicado(profesor, comunicado);
        ultimosComunicadosEnviados(session);
        response.sendRedirect(PageHelper.DASHBOARD_PROFESOR_COMUNICADO);
    }

    private void redireccionarPorTipoUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String tipoUsuario = session.getAttribute(SessionStringHelpers.TIPO_USUARIO).toString();
        if (tipoUsuario.equals("profesor")) {
            ultimosComunicadosEnviados(session);
            response.sendRedirect(PageHelper.DASHBOARD_PROFESOR_COMUNICADO);
        } else if (tipoUsuario.equals("apoderado")) {
            ultimosComunicadosRecibidos(session);
            response.sendRedirect(PageHelper.DASHBOARD_APODERADO_COMUNICADO);
        }
    }

    private void ultimosComunicadosEnviados(HttpSession session) {
        Profesor profesor = (Profesor) session.getAttribute(SessionStringHelpers.USUARIO);
        List<Comunicado> listaComunicados = comunicadoService.ultimosComunicadosEnviados(profesor);
        session.setAttribute(SessionStringHelpers.LISTA_COMUNICADOS, listaComunicados);
    }

    private void ultimosComunicadosRecibidos(HttpSession session) {
        Apoderado apoderado = (Apoderado)session.getAttribute(SessionStringHelpers.USUARIO);
        List<Alumno> alumnos = comunicadoService.ultimosComunicadosRecibidos(apoderado);
        session.setAttribute(SessionStringHelpers.LISTA_ALUMNOS,alumnos );
    }

}
