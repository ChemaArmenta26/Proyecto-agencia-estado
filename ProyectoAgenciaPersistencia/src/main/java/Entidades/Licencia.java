/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clase que representa una licencia en el sistema.
 */
@Entity
public class Licencia extends Tramite implements Serializable {

    

    @Column(name = "Vigencia", nullable = false)
    private Integer duracionAños;
    
    @Column(name = "estado", nullable = false)
    private Boolean estado;
    
    @Column(name = "FechaVigenciaExpiracion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar vigenciaF;
    @Column(name = "numeroLicencia", nullable = false)
    private String numeroLicencia;
    
    @ManyToOne
    @JoinColumn(name = "id_Persona", referencedColumnName = "id")
    private Persona persona;

    /**
     * Constructor vacío de la clase Licencia.
     */
    public Licencia() {
    }

    /**
     * Constructor de la clase Licencia.
     *
     * @param duracionAños La duración en años de la licencia.
     * @param vigenciaF    La fecha de vigencia de la licencia.
     * @param persona      La persona asociada a la licencia.
     * @param fecha        La fecha de realización del trámite.
     * @param costo        El costo del trámite.
     * @param estado       El estado de la licencia.
     * @param numero       El número de licencia.
     */
    public Licencia(int duracionAños, Calendar vigenciaF, Persona persona, Calendar fecha, float costo, boolean estado, String numero) {
        super(fecha, costo);
        this.duracionAños = duracionAños;
        this.vigenciaF = vigenciaF;
        this.persona = persona;
        this.estado = estado;
        this.numeroLicencia = numero;
    }

    /**
     * Obtiene el estado de la licencia.
     *
     * @return El estado de la licencia.
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * Establece el estado de la licencia.
     *
     * @param estado El nuevo estado de la licencia.
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    /**
     * Obtiene la duración en años de la licencia.
     *
     * @return La duración en años de la licencia.
     */
    public int getDuracionAños() {
        return duracionAños;
    }

    /**
     * Establece la duración en años de la licencia.
     *
     * @param duracionAños La nueva duración en años de la licencia.
     */
    public void setDuracionAños(int duracionAños) {
        this.duracionAños = duracionAños;
    }

    /**
     * Obtiene la fecha de vigencia de la licencia.
     *
     * @return La fecha de vigencia de la licencia.
     */
    public Calendar getVigenciaF() {
        return vigenciaF;
    }

    /**
     * Establece la fecha de vigencia de la licencia.
     *
     * @param vigenciaF La nueva fecha de vigencia de la licencia.
     */
    public void setVigenciaF(Calendar vigenciaF) {
        this.vigenciaF = vigenciaF;
    }

    /**
     * Obtiene la persona asociada a la licencia.
     *
     * @return La persona asociada a la licencia.
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Establece la persona asociada a la licencia.
     *
     * @param persona La nueva persona asociada a la licencia.
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * Obtiene el número de licencia.
     *
     * @return El número de licencia.
     */
    public String getNumeroLicencia() {
        return numeroLicencia;
    }

    /**
     * Establece el número de licencia.
     *
     * @param numeroLicencia El nuevo número de licencia.
     */
    public void setNumeroLicencia(String numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }
    
    /**
     * Devuelve una representación en cadena del objeto Licencia.
     *
     * @return Una cadena que representa el objeto Licencia.
     */
    @Override
    public String toString() {
        return "Licencia{" + "duracionA\u00f1os=" + duracionAños + ", vigenciaF=" + vigenciaF + '}';
    }

    

}
