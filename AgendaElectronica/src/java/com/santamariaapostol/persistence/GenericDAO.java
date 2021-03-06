/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santamariaapostol.persistence;

import java.util.List;

/**
 *
 * @author alonsorn
 * @param <T>
 */
public interface GenericDAO<T> {

    public void crear(T obj);

    public void actualizar(T obj);

    public T buscarPorId(int id);

    public void eliminar(int id);

    public List<T> buscarTodos();
}
