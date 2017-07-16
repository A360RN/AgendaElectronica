/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santamariaapostol.persistence.mysql_impl;

import com.santamariaapostol.persistence.SeccionDAO;
import com.santamariaapostol.entity.Seccion;
import com.santamariaapostol.util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author alonsorn
 */
public class SeccionDAOMySQLImpl implements SeccionDAO {

    Connection cn = null;
    String sql = "";
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    @Override
    public void crear(Seccion obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(Seccion obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Seccion buscarPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Seccion> buscarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Seccion buscarPorProfesor(int idProfesor) {
        Seccion seccion = null;
        try {
            cn = Conexion.ini();
            sql = "select * from SECCION s JOIN PROFESOR p ON"
                    + " s.idProfesor = p.idProfesor WHERE"
                    + " p.idProfesor = ?";
            
            ps = cn.prepareStatement(sql);
            ps.setInt(1, idProfesor);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                seccion = new Seccion();
                seccion.setIdSeccion(rs.getInt("idSeccion"));
                seccion.setLetraSeccion(rs.getString("letraSeccion"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return seccion;
    }
    

}
