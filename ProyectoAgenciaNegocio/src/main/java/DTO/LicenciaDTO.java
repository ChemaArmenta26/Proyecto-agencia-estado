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
    private String numeroLicencia;

    public LicenciaDTO() {
    }


    public LicenciaDTO(int duracionAños, Calendar vigenciaF, boolean estado, Persona persona, String numeroLicencia, Calendar fecha, float costo) {
        super(fecha, costo);
        this.duracionAños = duracionAños;
        this.vigenciaF = vigenciaF;
        this.estado = estado;
        this.persona = persona;
        this.numeroLicencia = numeroLicencia;
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

    public String getNumeroLicencia() {
        return numeroLicencia;
    }

    public void setNumeroLicencia(String numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }

}
