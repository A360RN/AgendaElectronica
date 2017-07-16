/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santamariaapostol.persistence.mysql_impl;

import com.santamariaapostol.persistence.ComunicadoDAO;
import com.santamariaapostol.entity.Comunicado;
import com.santamariaapostol.util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alonsorn
 */
public class ComunicadoDAOMySQLImpl implements ComunicadoDAO{

    Connection cn = null;
    String sql = "";
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    @Override
    public void crear(Comunicado obj) {
        try {
            cn = Conexion.ini();
            sql = "insert into COMUNICADO(titulo, cuerpo, idSeccion) values(?,?,?)";
            ps = cn.prepareStatement(sql);
            ps.setString(1, obj.getTitulo());
            ps.setString(2, obj.getCuerpo());
            ps.setInt(3, obj.getSeccion().getIdSeccion());
            
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(Comunicado obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Comunicado buscarPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Comunicado> buscarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Comunicado> ultimosComunicadosEnviados(int idSeccion) {
        List<Comunicado> listaComunicados = new ArrayList<>();
        try {
            cn = Conexion.ini();
            sql = "select * from COMUNICADO where idSeccion = ? limit 3";
            ps = cn.prepareStatement(sql);
            ps.setInt(1, idSeccion);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                Comunicado comunicado = new Comunicado();
                comunicado.setIdComunicado(rs.getInt("idComunicado"));
                comunicado.setTitulo(rs.getString("titulo"));
                comunicado.setCuerpo(rs.getString("cuerpo"));
                
                listaComunicados.add(comunicado);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaComunicados;
    }
    
}
