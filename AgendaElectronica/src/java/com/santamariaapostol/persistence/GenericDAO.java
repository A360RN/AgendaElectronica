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

    public void insert(T obj);

    public void update(T obj);

    public T findById(int id);

    public void delete(int id);

    public List<T> readAll();
}
