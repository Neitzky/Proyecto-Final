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
public class DAOUsuarioImpl extends DAO{
    
    /**
     *         este metodo sirve para guardar un cliente
     * @param cliente Este parametro se le deve pasar a este metodo para 
     * que se guarde un nuevo cliente 
     * 
     */
    public void agregarProducto(Usuario cliente) {
    begin();
    getSession().save(cliente);
    commit();
    close();
    
    }
 
       /**
        * Este metodo obtiene todos los registros de la tabla cliente 
        * @return Este metodo nos regresa todos los clientes
        */
    public ArrayList<Usuario> buscarTodosClientes() {
        begin();
      //  Query q = getSession().createQuery("from Usuario");
        Criteria c=getSession().createCriteria(Usuario.class);
        ArrayList<Usuario> clientes = (ArrayList<Usuario>)c.list();
        commit();
        close();
         
return clientes; 
        
      
    }
    /**
     * Este metodo borra un cliente
     * @param p Se le debe pasar un parametro de tipo cliente para ser borrado
     */
 public void borrarCliente(Usuario p){
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
  public Usuario buscarPorId(int id){
      begin();
     Query q = getSession().createQuery("from Cliente where id = :id");
        q.setInteger("id",id);
        Usuario p = (Usuario)q.uniqueResult();
        commit();
        close();
return p;  
   
  }  }
  
 
  

