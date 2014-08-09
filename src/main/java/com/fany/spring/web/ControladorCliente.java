/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fany.spring.web;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author servicio.presupuesto
 */

@Controller
@RequestMapping("/")
public class ControladorCliente {
     @RequestMapping(value="/cliente/{nombre}/{email}", method=RequestMethod.GET, headers={"Accept=text/html"})
    public @ResponseBody String mensajito(@PathVariable String nombre, @PathVariable String email){
           DAOClienteImpl d= new DAOClienteImpl();
           d.agregarCliente(new Cliente(nombre, email));
           return "Cliente guardado con exito";
    }
    
    @RequestMapping(value="/alumno", method=RequestMethod.GET, headers={"Accept=application/json"})
    public @ResponseBody String metodo2()throws Exception {
        DAOClienteImpl d=new DAOClienteImpl();
        ObjectMapper maper=new ObjectMapper();
            
        return maper.writeValueAsString(d.buscarTodosClientes());
    }
}

