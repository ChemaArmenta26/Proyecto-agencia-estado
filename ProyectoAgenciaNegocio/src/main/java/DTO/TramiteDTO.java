/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Calendar;

/**
 *
 * @author pc
 */
public class TramiteDTO {
    private Calendar fecha;
    private float costo;

    public TramiteDTO() {
    }

    public TramiteDTO(Calendar fecha, float costo) {
        this.fecha = fecha;
        this.costo = costo;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }
    
    
}
