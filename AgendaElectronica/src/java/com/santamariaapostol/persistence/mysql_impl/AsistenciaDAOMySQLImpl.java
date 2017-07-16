/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santamariaapostol.persistence.mysql_impl;

import com.santamariaapostol.persistence.AsistenciaDAO;
import com.santamariaapostol.entity.Asistencia;
import com.santamariaapostol.util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author alonsorn
 */
public class AsistenciaDAOMySQLImpl implements AsistenciaDAO {

    Connection cn = null;
    String sql = "";
    ResultSet rs = null;
    PreparedStatement ps = null;

    @Override
    public void crear(Asistencia obj) {
        try {
            cn = Conexion.ini();
            sql = "insert into ASISTENCIA(fecha, estado, idMatricula) values (str_to_date(?,'%Y %m %d'),?,?)";
            ps = cn.prepareStatement(sql);
            ps.setString(1, obj.getFecha());
            ps.setString(2, "INASISTENCIA");
            ps.setInt(3, obj.getMatricula().getIdMatricula());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(Asistencia obj) {
        try {
            cn = Conexion.ini();
            sql = "update ASISTENCIA set estado = ? WHERE idAsistencia = ?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, obj.getEstado());
            ps.setInt(2, obj.getIdAsistencia());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Asistencia buscarPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Asistencia> buscarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Asistencia asistenciaHoyAlumno(int idAlumno) {
        Asistencia asistencia = null;
        try {
            cn = Conexion.ini();
            sql = "select * from ASISTENCIA a join MATRICULA m on"
                    + " m.idMatricula = a.idMatricula where"
                    + " idAlumno = ? and a.fecha = str_to_date(?,'%Y %m %d')";

            ps = cn.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            LocalDateTime now = LocalDateTime.now();
            int year = now.getYear();
            int month = now.getMonthValue();
            int day = now.getDayOfMonth();
            String date = year + " " + month + " " + day;
            ps.setString(2, date);

            rs = ps.executeQuery();
            if (rs.next()) {
                asistencia = new Asistencia();
                asistencia.setIdAsistencia(rs.getInt("idAsistencia"));
                asistencia.setFecha(rs.getString("fecha"));
                asistencia.setEstado(rs.getString("estado"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return asistencia;
    }

}
