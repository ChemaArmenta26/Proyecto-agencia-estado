/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import Entidades.Persona;
import java.util.Calendar;

/**
 *  Clase que implementa la lógica de negocio para LicenciaDTO
 */
public class LicenciaDTO extends TramiteDTO {

    private int duracionAños;
    private Calendar vigenciaF;
    private boolean estado;
    private Persona persona;
    private String numeroLicencia;

    /**
     * Constructor por defecto de la clase LicenciaDTO.
     */
    public LicenciaDTO() {
    }

    /**
     * Constructor de la clase LicenciaDTO que inicializa todos los atributos.
     * @param duracionAños Duración en años de la licencia.
     * @param vigenciaF Fecha de vigencia de la licencia.
     * @param estado Estado de la licencia (activo/inactivo).
     * @param persona Persona asociada a la licencia.
     * @param numeroLicencia Número de licencia.
     * @param fecha Fecha de la licencia.
     * @param costo Costo de la licencia.
     */
    public LicenciaDTO(int duracionAños, Calendar vigenciaF, boolean estado, Persona persona, String numeroLicencia, Calendar fecha, float costo) {
        super(fecha, costo);
        this.duracionAños = duracionAños;
        this.vigenciaF = vigenciaF;
        this.estado = estado;
        this.persona = persona;
        this.numeroLicencia = numeroLicencia;
    }

    /**
     * Obtiene el estado de la licencia.
     * @return Estado de la licencia (true si está activa, false si está inactiva).
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * Establece el estado de la licencia.
     * @param estado Estado de la licencia a establecer (true si está activa, false si está inactiva).
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * Obtiene la duración en años de la licencia.
     * @return Duración en años de la licencia.
     */
    public int getDuracionAños() {
        return duracionAños;
    }

    /**
     * Establece la duración en años de la licencia.
     * @param duracionAños Duración en años de la licencia a establecer.
     */
    public void setDuracionAños(int duracionAños) {
        this.duracionAños = duracionAños;
    }

    /**
     * Obtiene la fecha de vigencia de la licencia.
     * @return Fecha de vigencia de la licencia.
     */
    public Calendar getVigenciaF() {
        return vigenciaF;
    }

    /**
     * Establece la fecha de vigencia de la licencia.
     * @param vigenciaF Fecha de vigencia de la licencia a establecer.
     */
    public void setVigenciaF(Calendar vigenciaF) {
        this.vigenciaF = vigenciaF;
    }

    /**
     * Obtiene la persona asociada a esta licencia.
     * @return La persona asociada a esta licencia.
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Establece la persona asociada a esta licencia.
     * @param persona La persona a establecer.
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * Obtiene el número de licencia.
     * @return El número de licencia.
     */
    public String getNumeroLicencia() {
        return numeroLicencia;
    }

    /**
     * Establece el número de licencia.
     * @param numeroLicencia El número de licencia a establecer.
     */
    public void setNumeroLicencia(String numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }

}
