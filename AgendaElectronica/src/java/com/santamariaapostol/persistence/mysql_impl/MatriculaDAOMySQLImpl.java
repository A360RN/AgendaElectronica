/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santamariaapostol.persistence.mysql_impl;

import com.santamariaapostol.persistence.MatriculaDAO;
import com.santamariaapostol.entity.Matricula;
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
public class MatriculaDAOMySQLImpl implements MatriculaDAO{

    Connection cn = null;
    String sql = "";
    ResultSet rs = null;
    PreparedStatement ps = null;
    
    @Override
    public void crear(Matricula obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(Matricula obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Matricula buscarPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Matricula> buscarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Matricula> buscarUltimaMatriculaAlumno(int idAlumno) {
        List<Matricula> matriculas = new ArrayList<>();
        try {
            cn = Conexion.ini();
            sql = "select * from MATRICULA where idAlumno = ?";
            ps = cn.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                Matricula matricula = new Matricula();
                matricula.setIdMatricula(rs.getInt("idMatricula"));
                
                matriculas.add(matricula);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return matriculas;    
    }
    
}
