/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santamariaapostol.persistence.mysql_impl;

import com.santamariaapostol.persistence.CitacionDAO;
import com.santamariaapostol.entity.Citacion;
import com.santamariaapostol.util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author alonsorn
 */
public class CitacionDAOMySQLImpl implements CitacionDAO{
    
    Connection cn = null;
    String sql = "";
    ResultSet rs = null;
    PreparedStatement ps = null;

    @Override
    public void crear(Citacion obj) {
        try {
            cn = Conexion.ini();
            sql = "insert into CITACION(titulo, cuerpo,profesorConfirm,idApoderado,idProfesor) values (?,?,?,?,?)";
            ps = cn.prepareStatement(sql);
            ps.setString(1, obj.getTitulo());
            ps.setString(2, obj.getCuerpo());
            ps.setInt(3, 1);
            ps.setInt(4, obj.getApoderado().getIdApoderado());
            ps.setInt(5, obj.getProfesor().getIdProfesor());
            
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(Citacion obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Citacion buscarPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Citacion> buscarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
