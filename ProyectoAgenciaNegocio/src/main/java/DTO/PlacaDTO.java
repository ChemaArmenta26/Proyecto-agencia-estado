/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import Entidades.Persona;
import Entidades.Vehiculo;
import java.util.Calendar;

/**
 *  Clase que implementa la lógica de negocio para PlacaDTO
 */
public class PlacaDTO extends TramiteDTO {
    private String numeroPlaca;
    private Calendar fechaRecepcion;
    private boolean estado;
    private Vehiculo vehiculo;
    private Persona persona;

    /**
     * Constructor por defecto de la clase PlacaDTO.
     */
    public PlacaDTO() {
    }

    /**
     * Constructor de la clase PlacaDTO con parámetros.
     * @param numeroPlaca El número de placa.
     * @param fechaRecepcion La fecha de recepción.
     * @param estado El estado de la placa.
     * @param vehiculo El vehículo asociado a la placa.
     * @param persona La persona propietaria de la placa.
     */
    public PlacaDTO(String numeroPlaca, Calendar fechaRecepcion, boolean estado, Vehiculo vehiculo, Persona persona) {
        this.numeroPlaca = numeroPlaca;
        this.fechaRecepcion = fechaRecepcion;
        this.estado = estado;
        this.vehiculo = vehiculo;
        this.persona = persona;
    }

    /**
     * Constructor de la clase PlacaDTO con parámetros adicionales.
     * @param numeroPlaca El número de placa.
     * @param fechaRecepcion La fecha de recepción.
     * @param estado El estado de la placa.
     * @param vehiculo El vehículo asociado a la placa.
     * @param persona La persona propietaria de la placa.
     * @param fecha La fecha del trámite.
     * @param costo l costo del trámite.
     */
    public PlacaDTO(String numeroPlaca, Calendar fechaRecepcion, boolean estado, Vehiculo vehiculo, Persona persona, Calendar fecha, float costo) {
        super(fecha, costo);
        this.numeroPlaca = numeroPlaca;
        this.fechaRecepcion = fechaRecepcion;
        this.estado = estado;
        this.vehiculo = vehiculo;
        this.persona = persona;
    }

    /**
     *Obtiene el número de placa.
     * @return El número de placa.
     */
    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    /**
     * Establece el número de placa.
     * @param numeroPlaca El número de placa a establecer.
     */
    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    /**
     * Obtiene la fecha de recepción de la placa.
     * @return La fecha de recepción de la placa.
     */
    public Calendar getFechaRecepcion() {
        return fechaRecepcion;
    }

    /**
     * Establece la fecha de recepción de la placa.
     * @param fechaRecepcion La fecha de recepción de la placa a establecer.
     */
    public void setFechaRecepcion(Calendar fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    /**
     * Verifica el estado de la placa.
     * @return True si la placa está activa, False si no.
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * Establece el estado de la placa
     * @param estado El estado de la placa a establecer
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * Obtiene el vehículo asociado a la placa.
     * @return El vehículo asociado a la placa.
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /**
     * Establece el vehículo asociado a la placa.
     * @param vehiculo El vehículo asociado a la placa a establecer.
     */
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * Obtiene la persona propietaria de la placa.
     * @return La persona propietaria de la placa.
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Establece la persona propietaria de la placa.
     * @param persona La persona propietaria de la placa a establecer.
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    
}
