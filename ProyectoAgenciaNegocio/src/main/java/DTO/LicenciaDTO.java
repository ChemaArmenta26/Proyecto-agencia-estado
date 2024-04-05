/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import Entidades.Persona;
import java.util.Calendar;

/**
 *
 * @author pc
 */
public class LicenciaDTO extends TramiteDTO {
    
    private int duracionAños;
    private Calendar vigenciaF;
    private boolean estado;
     private Persona persona;

    public LicenciaDTO() {
    }

    public LicenciaDTO(int duracionAños, Calendar vigenciaF, Calendar fecha, float costo,boolean estado) {
        super(fecha, costo);
        this.duracionAños = duracionAños;
        this.vigenciaF = vigenciaF;
        this.estado = estado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getDuracionAños() {
        return duracionAños;
    }

    public void setDuracionAños(int duracionAños) {
        this.duracionAños = duracionAños;
    }

    public Calendar getVigenciaF() {
        return vigenciaF;
    }

    public void setVigenciaF(Calendar vigenciaF) {
        this.vigenciaF = vigenciaF;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    
}
