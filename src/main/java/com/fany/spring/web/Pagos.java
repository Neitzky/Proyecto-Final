/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fany.spring.web;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

/**
 *
 * @author servicio.presupuesto
 */
@MappedSuperclass
@Table(name = "pagos")
public class Pagos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pagos")
    private Integer idPagos;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "primer_pago")
    private Float primerPago;
    @Column(name = "segundo_pago")
    private Float segundoPago;
    @Column(name = "total")
    private Float total;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne
    private Cliente idCliente;

    public Pagos() {
    }

    public Pagos(Integer idPagos, Float primerPago, Float segundoPago, Float total, Cliente idCliente) {
        this.idPagos = idPagos;
        this.primerPago = primerPago;
        this.segundoPago = segundoPago;
        this.total = total;
        this.idCliente = idCliente;
    }

    
    public Pagos(Integer idPagos) {
        this.idPagos = idPagos;
    }

    public Integer getIdPagos() {
        return idPagos;
    }

    public void setIdPagos(Integer idPagos) {
        this.idPagos = idPagos;
    }

    public Float getPrimerPago() {
        return primerPago;
    }

    public void setPrimerPago(Float primerPago) {
        this.primerPago = primerPago;
    }

    public Float getSegundoPago() {
        return segundoPago;
    }

    public void setSegundoPago(Float segundoPago) {
        this.segundoPago = segundoPago;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPagos != null ? idPagos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pagos)) {
            return false;
        }
        Pagos other = (Pagos) object;
        if ((this.idPagos == null && other.idPagos != null) || (this.idPagos != null && !this.idPagos.equals(other.idPagos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fany.spring.web.Pagos[ idPagos=" + idPagos + " ]";
    }
    
}
