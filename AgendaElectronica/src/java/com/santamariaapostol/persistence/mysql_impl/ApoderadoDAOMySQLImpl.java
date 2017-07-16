/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santamariaapostol.persistence.mysql_impl;

import com.santamariaapostol.persistence.ApoderadoDAO;
import com.santamariaapostol.entity.Apoderado;
import com.santamariaapostol.util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author alonsorn
 */
public class ApoderadoDAOMySQLImpl implements ApoderadoDAO{
    Connection cn = null;
    String sql = "";
    ResultSet rs = null;
    PreparedStatement ps = null;

    @Override
    public void crear(Apoderado obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(Apoderado obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Apoderado buscarPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Apoderado> buscarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Apoderado buscarPorUsuario(String username) {
        Apoderado apoderado = null;
        try {
            cn = Conexion.ini();
            sql = "select * from APODERADO where usuario = ?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, username);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                apoderado = new Apoderado();
                apoderado.setIdApoderado(rs.getInt("idApoderado"));
                apoderado.setPrimerNombre(rs.getString("primer_nombre"));
                apoderado.setSegundoNombre(rs.getString("segundo_nombre"));
                apoderado.setApellidoPaterno(rs.getString("apellido"));
                apoderado.setApellidoMaterno(rs.getString("apellido2"));
                apoderado.setDni(rs.getString("dni"));
                apoderado.setUsuario(rs.getString("usuario"));
                apoderado.setPassword(rs.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return apoderado;
    }
    
}
