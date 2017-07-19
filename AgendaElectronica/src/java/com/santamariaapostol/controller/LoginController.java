/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santamariaapostol.controller;

import com.santamariaapostol.entity.Apoderado;
import com.santamariaapostol.entity.Profesor;
import com.santamariaapostol.service.LoginService;
import com.santamariaapostol.util.PageHelper;
import com.santamariaapostol.util.SessionStringHelpers;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author alonsorn
 */
public class LoginController extends HttpServlet {

    private LoginService loginService;

    public LoginController() {
        loginService = new LoginService();
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        if(action.equals("logout")){
            logout(request, response);
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
        if (action.equals("login")) {
            validarLogin(request, response);
        }
    }

    /*
        Valida el usuario, si lo encuentra
        determina si es un profesor o apoderado y lo
        coloca en el objeto session
    */
    private void validarLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario = request.getParameter("username");
        String passwordPosible = request.getParameter("password");
        Profesor profesor = new Profesor();
        Apoderado apoderado = new Apoderado();
        
        profesor.setUsuario(usuario);
        profesor.setPassword(passwordPosible);
        
        apoderado.setUsuario(usuario);
        apoderado.setPassword(passwordPosible);
        
        if(loginService.validarProfesor(profesor)!= null){
            profesor = loginService.validarProfesor(profesor);
            request.getSession(true).setAttribute(SessionStringHelpers.USUARIO, profesor);
            request.getSession().setAttribute(SessionStringHelpers.TIPO_USUARIO, "profesor");
            response.sendRedirect(PageHelper.DASHBOARD);
        }else if(loginService.validarApoderado(apoderado)!= null){
            apoderado = loginService.validarApoderado(apoderado);
            request.getSession(true).setAttribute(SessionStringHelpers.USUARIO, apoderado);
            request.getSession().setAttribute(SessionStringHelpers.TIPO_USUARIO, "apoderado");
            response.sendRedirect(PageHelper.DASHBOARD);
        }else{
            response.sendRedirect(PageHelper.LOGIN_PAGE);
        }
        
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect(PageHelper.INDEX_PAGE);
    }

}
