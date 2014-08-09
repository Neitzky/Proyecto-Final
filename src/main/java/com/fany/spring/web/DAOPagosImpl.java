/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fany.spring.web;

import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Query;

/**
 *
 * @author servicio.presupuesto
 */
public class DAOPagosImpl extends DAO{
    
    public void agregarCalificacion(Pagos c) {
    begin();
 
    
    getSession().save(c);
    commit();
    close();
    
    }
 
       /**
        * Este metodo obtiene todos los registros de la tabla cliente 
        * @return Este metodo nos regresa todos los clientes
        */
    public ArrayList<Pagos> buscarTodosCalificacion() {
        begin();
      //  Query q = getSession().createQuery("from Usuario");
        Criteria c=getSession().createCriteria(Pagos.class);
        ArrayList<Pagos> calificaciones = (ArrayList<Pagos>)c.list();
        commit();
        close();
         
return calificaciones; 
        
      
    }
    /**
     * Este metodo borra un cliente
     * @param p Se le debe pasar un parametro de tipo cliente para ser borrado
     */
 public void borrarCalificacion(Pagos p){
            begin();
             getSession().delete(p);
            commit();
            close();
 }   
        /**
         * Este metodo busca un cliente por medio de su Id
         * @param id Este parametro es el Id del cliente que se quiere buscar
         * @return El tipo de retorno es el cliente buscado
         */
  public Pagos buscarPorId(int id){
      begin();
     Query q = getSession().createQuery("from Calificacion where id = :id");
        q.setInteger("id",id);
        Pagos p = (Pagos)q.uniqueResult();
        commit();
        close();
return p;  
   
  }  }

