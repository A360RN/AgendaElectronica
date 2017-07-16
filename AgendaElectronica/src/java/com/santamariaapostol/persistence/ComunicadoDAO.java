/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santamariaapostol.persistence;

import com.santamariaapostol.entity.Comunicado;
import java.util.List;

/**
 *
 * @author alonsorn
 */
public interface ComunicadoDAO extends GenericDAO<Comunicado>{
    
    public List<Comunicado> ultimosComunicadosEnviados(int idSeccion);
}
