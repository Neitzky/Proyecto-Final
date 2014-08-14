/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fany.spring.web;

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
public class ControladorPagos {
    
     @RequestMapping(value="/calificacion/{parcial}/{final}/{total}/{id}", method=RequestMethod.GET, headers={"Accept=text/html"})
    public @ResponseBody String mensajito(@PathVariable float primerPago, @PathVariable float 
            segundoPago,@PathVariable float total, @PathVariable int id ){
        String mensajito="nada";
        try{
           DAOPagosImpl d= new DAOPagosImpl();
            d.agregarPago(new Pagos(primerPago, segundoPago, total,new Cliente(id)));
           mensajito= "Pago guardado con exito";
        }catch(Exception  e){
            mensajito="Lo siento pero no existe ese id de usuario";
        }
        return mensajito;
    }
    
}
