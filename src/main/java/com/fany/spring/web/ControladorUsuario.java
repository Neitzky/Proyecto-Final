/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fany.spring.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author servicio.presupuesto
 */

@Controller
@RequestMapping("/")
public class ControladorUsuario {
    
     @RequestMapping(value="/usuario/{nombre}", method=RequestMethod.POST, headers={"Accept=text/html"})
    public @ResponseBody String insertar(@PathVariable String nombre){
        /*
        Esto esta mal, alerta de lo que no se debe hacer, esta clase que le puse de nombre Guarda NO USA UNA SESION A PRUEBA DE THREASD NI NADA
        ES SOLO UN EJEMPLO DE  CONTROLADOR, LE PASAMOS UN PARAMETRO NOMBRE Y LA LO GUADA, TU LABOR ES HACER QUE FUNCIONE 
        A PRUEBA DE TREADS JIJIJI
        */
 DAOUsuarioImpl.insertar(new Usuario(nombre));
  return "El usuario se ha registrado correctamente";
 
    }
    
    @RequestMapping(value="/usuario{id}/{nombre}", method=RequestMethod.PUT, headers={"Accept=text/html"})
    public @ResponseBody String actualizar(@PathVariable int id, @PathVariable String nombre){
       
        
        try {
            DAOUsuarioImpl.actualizar(new Usuario(id, nombre));
            return "El registro se ha modificado correctamente";    
        } catch (Exception e) {
            return "El registro solicitado no existe";
        }
        
    }
    
    @RequestMapping (value = "/usuario/{id}/{nombre}", method = RequestMethod.DELETE, headers = {"Accept=text/html"})
    public @ResponseBody String eliminar (@PathVariable int id, @PathVariable String nombre){
        
        try {
            DAOUsuarioImpl.borrar(new Usuario(id, nombre));
            return "El registro se ha eliminado correctamente";    
        } catch (Exception e) {
            return "El registro solicitado no existe";
        }
        
    }
    
    @RequestMapping (value = "/usuario", method = RequestMethod.GET, headers = {"Accept=Application/json"})
    public @ResponseBody String buscarTodos() throws IOException{
        
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(DAOUsuarioImpl.buscarTodos());
    }
    
    @RequestMapping (value = "/proveedores/{id}", method = RequestMethod.GET, headers = {"Accept=text/html"})
    public @ResponseBody String buscarPorId(@PathVariable int id){
        
        return DAOUsuarioImpl.buscarId(id).toString();
    }
}
    
    
   
    
    

    
    

