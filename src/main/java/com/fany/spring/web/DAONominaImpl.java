/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fany.spring.web;

import java.util.ArrayList;
import org.hibernate.Criteria;

/**
 *
 * @author servicio.presupuesto
 */
public class DAONominaImpl extends DAO{
     public void agregarProducto(Nomina cliente)  {
    begin();
    getSession().save(cliente);
    commit();
    close();
    
    }
    
     public ArrayList<Nomina> buscarTodosClientes() {
        begin();
      //  Query q = getSession().createQuery("from Usuario");
        Criteria c=getSession().createCriteria(Nomina.class);
        ArrayList<Nomina> clientes = (ArrayList<Nomina>)c.list();
        commit();
        close();
         
return clientes; 
}
}

