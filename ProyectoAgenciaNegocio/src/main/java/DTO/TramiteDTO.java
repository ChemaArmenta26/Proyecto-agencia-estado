/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Calendar;

/**
 *  Clase que implementa la lógica de negocio para TramiteDTO
 */
public class TramiteDTO {
    private Calendar fecha;
    private float costo;

    /**
     * Constructor por defecto de la clase TramiteDTO.
     */
    public TramiteDTO() {
    }

    /**
     * Constructor de la clase TramiteDTO con parámetros.
     * @param fecha La fecha del trámite.
     * @param costo El costo del trámite.
     */
    public TramiteDTO(Calendar fecha, float costo) {
        this.fecha = fecha;
        this.costo = costo;
    }

    /**
     * Obtiene la fecha del trámite.
     * @return La fecha del trámite
     */
    public Calendar getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha del trámite.
     * @param fecha La fecha del trámite a establecer.
     */
    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene el costo del trámite.
     * @return El costo del trámite.
     */
    public float getCosto() {
        return costo;
    }

    /**
     * Establece el costo del trámite.
     * @param costo El costo del trámite a establecer.
     */
    public void setCosto(float costo) {
        this.costo = costo;
    }
    
    
}
