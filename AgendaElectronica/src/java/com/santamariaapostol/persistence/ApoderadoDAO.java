/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santamariaapostol.persistence;

import com.santamariaapostol.entity.Apoderado;

/**
 *
 * @author alonsorn
 */
public interface ApoderadoDAO extends GenericDAO<Apoderado>{
    
    public Apoderado buscarPorUsuario(String username);
}
