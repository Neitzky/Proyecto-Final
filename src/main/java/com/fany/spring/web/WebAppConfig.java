/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fany.spring.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * @author servicio.presupuesto
 */
@EnableWebMvc
@Configuration
@ComponentScan("com.fany.spring.web")
public class WebAppConfig extends WebMvcConfigurerAdapter {
  //Aqui van mas configuraciones como los interceptores de sesion 
}
