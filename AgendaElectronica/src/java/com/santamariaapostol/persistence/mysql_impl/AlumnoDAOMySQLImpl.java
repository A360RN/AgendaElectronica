/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santamariaapostol.persistence.mysql_impl;

import com.santamariaapostol.persistence.AlumnoDAO;
import com.santamariaapostol.entity.Alumno;
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
public class AlumnoDAOMySQLImpl implements AlumnoDAO {

    Connection cn = null;
    String sql = "";
    ResultSet rs = null;
    PreparedStatement ps = null;

    @Override
    public void crear(Alumno obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(Alumno obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Alumno buscarPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Alumno> buscarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Alumno> buscarPorApoderado(int idApoderado) {
        List<Alumno> alumnos = new ArrayList<>();
        try {
            cn = Conexion.ini();
            sql = "select * from ALUMNO where idApoderado = ?";
            ps = cn.prepareStatement(sql);
            ps.setInt(1, idApoderado);
            rs = ps.executeQuery();

            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setPrimerNombre(rs.getString("primer_nombre"));
                alumno.setSegundoNombre(rs.getString("segundo_nombre"));
                alumno.setApellidoPaterno(rs.getString("apellido"));
                alumno.setApellidoMaterno(rs.getString("apellido2"));
                alumno.setFechaNacimiento(rs.getString("fecha_nacimiento"));

                alumnos.add(alumno);
            }

        } catch (Exception e) {
        }
        return alumnos;
    }

    @Override
    public List<Alumno> buscarPorProfesor(int idProfesor) {
        List<Alumno> alumnos = new ArrayList<>();
        try {
            cn = Conexion.ini();
            sql = "select * from seccion s join matricula m on s.idSeccion = m.idSeccion"
                    + " join alumno a on a.idAlumno = m.idAlumno"
                    + " where s.idProfesor = ?";

            ps = cn.prepareStatement(sql);
            ps.setInt(1, idProfesor);
            
            rs = ps.executeQuery();
            while (rs.next()) {
                Alumno a = new Alumno();
                a.setIdAlumno(rs.getInt("idAlumno"));
                a.setPrimerNombre(rs.getString("primer_nombre"));
                a.setSegundoNombre(rs.getString("segundo_nombre"));
                a.setApellidoPaterno(rs.getString("apellido"));
                a.setApellidoMaterno(rs.getString("apellido2"));
                a.setFechaNacimiento(rs.getString("fecha_nacimiento"));
                Matricula matricula = new Matricula();
                matricula.setIdMatricula(rs.getInt("idMatricula"));
                List<Matricula> matriculas = new ArrayList<>();
                matriculas.add(matricula);
                a.setMatriculas(matriculas);

                alumnos.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return alumnos;
    }

}
