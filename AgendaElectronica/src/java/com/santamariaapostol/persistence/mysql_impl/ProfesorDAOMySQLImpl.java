/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santamariaapostol.persistence.mysql_impl;

import com.santamariaapostol.persistence.ProfesorDAO;
import com.santamariaapostol.entity.Profesor;
import com.santamariaapostol.util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author alonsorn
 */
public class ProfesorDAOMySQLImpl implements ProfesorDAO {

    Connection cn = null;
    String sql = "";
    ResultSet rs = null;
    PreparedStatement ps = null;
    
    @Override
    public void crear(Profesor obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(Profesor obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Profesor buscarPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Profesor> buscarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Profesor buscarPorUsuario(String username) {
        Profesor profesor = null;
        try {
            cn = Conexion.ini();
            sql = "select from APODERADO where usuario = ?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, username);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                profesor = new Profesor();
                profesor.setIdProfesor(rs.getInt("idApoderado"));
                profesor.setPrimerNombre(rs.getString("primer_nombre"));
                profesor.setSegundoNombre(rs.getString("segundo_nombre"));
                profesor.setApellidoPaterno(rs.getString("apellido"));
                profesor.setApellidoMaterno(rs.getString("last_name2"));
                profesor.setDni(rs.getString("dni"));
                profesor.setUsuario(rs.getString("usuario"));
                profesor.setPassword(rs.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return profesor;
    }

}
