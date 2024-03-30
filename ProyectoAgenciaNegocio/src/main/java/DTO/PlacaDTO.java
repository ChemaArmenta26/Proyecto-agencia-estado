/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import Entidades.Persona;
import Entidades.Vehiculo;
import java.util.Calendar;

/**
 *
 * @author PC
 */
public class PlacaDTO extends TramiteDTO {
    private String numeroPlaca;
    private Calendar fechaRecepcion;
    private boolean estado;
    private Vehiculo vehiculo;
    private Persona persona;

    public PlacaDTO() {
    }

    public PlacaDTO(String numeroPlaca, Calendar fechaRecepcion, boolean estado, Vehiculo vehiculo, Persona persona) {
        this.numeroPlaca = numeroPlaca;
        this.fechaRecepcion = fechaRecepcion;
        this.estado = estado;
        this.vehiculo = vehiculo;
        this.persona = persona;
    }

    public PlacaDTO(String numeroPlaca, Calendar fechaRecepcion, boolean estado, Vehiculo vehiculo, Persona persona, Calendar fecha, float costo) {
        super(fecha, costo);
        this.numeroPlaca = numeroPlaca;
        this.fechaRecepcion = fechaRecepcion;
        this.estado = estado;
        this.vehiculo = vehiculo;
        this.persona = persona;
    }

    

    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    public Calendar getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Calendar fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    
}
