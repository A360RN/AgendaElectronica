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
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            request.getSession(true).setAttribute("usuario", profesor);
            request.getSession().setAttribute("tipo_usuario", "profesor");
            response.sendRedirect(PageHelper.INDEX_PAGE);
        }else if(loginService.validarApoderado(apoderado)!= null){
            apoderado = loginService.validarApoderado(apoderado);
            request.getSession(true).setAttribute("usuario", apoderado);
            request.getSession().setAttribute("tipo_usuario", "apoderado");
            response.sendRedirect(PageHelper.INDEX_PAGE);
        }else{
            response.sendRedirect(PageHelper.LOGIN_PAGE);
        }
        
    }

}
