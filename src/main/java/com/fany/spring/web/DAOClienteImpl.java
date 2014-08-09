/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fany.spring.web;

import java.util.ArrayList;
import org.hibernate.Query;

/**
 *
 * @author servicio.presupuesto
 */
public class DAOClienteImpl extends DAO {
    
    public void agregarCliente(Cliente cliente) {
    begin();
    getSession().save(cliente);
    commit();
    close();
    
    }
 
       /**
        * Este metodo obtiene todos los registros de la tabla cliente 
        * @return Este metodo nos regresa todos los clientes
        */
    public ArrayList<Cliente> buscarTodosClientes() {
        begin();
        Query q = getSession().createQuery("from Cliente");
      //  Criteria c=getSession().createCriteria(Cliente.class);
        ArrayList<Cliente> clientes = (ArrayList<Cliente>)q.list();
        commit();
        close();
         
return clientes; 
        
      
    }
    /**
     * Este metodo borra un cliente
     * @param p Se le debe pasar un parametro de tipo cliente para ser borrado
     */
 public void borrarCliente(Cliente p){
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
  public Cliente buscarPorId(int id){
      begin();
     Query q = getSession().createQuery("from Cliente where id = :id");
        q.setInteger("id",id);
        Cliente p = (Cliente)q.uniqueResult();
        commit();
        close();
return p;  
   
  }  }

