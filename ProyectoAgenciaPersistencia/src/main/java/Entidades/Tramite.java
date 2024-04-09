/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clase abstracta que representa un trámite genérico.
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Tramite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fecha;

    @Column(name = "costo", nullable = false)
    private Float costo;
    
    /**
     * Método para obtener el ID del trámite.
     *
     * @return El ID del trámite.
     */
    public Long getId() {
        return id;
    }

    /**
     * Método para establecer el ID del trámite.
     *
     * @param id El ID del trámite a establecer.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Constructor vacío de la clase Tramite.
     */
    public Tramite() {
    }

    /**
     * Constructor de la clase Tramite.
     *
     * @param fecha La fecha del trámite.
     * @param costo El costo del trámite.
     */
    public Tramite(Calendar fecha, Float costo) {
        this.fecha = fecha;
        this.costo = costo;
        
    }

    /**
     * Método para obtener la fecha del trámite.
     *
     * @return La fecha del trámite.
     */
    public Calendar getFecha() {
        return fecha;
    }

    /**
     * Método para establecer la fecha del trámite.
     *
     * @param fecha La fecha del trámite a establecer.
     */
    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    /**
     * Método para obtener el costo del trámite.
     *
     * @return El costo del trámite.
     */
    public Float getCosto() {
        return costo;
    }

    /**
     * Método para establecer el costo del trámite.
     *
     * @param costo El costo del trámite a establecer.
     */
    public void setCosto(Float costo) {
        this.costo = costo;
    }

    /**
     * Método para obtener una representación en forma de cadena del trámite.
     *
     * @return Una cadena que representa la información del trámite.
     */
    @Override
    public String toString() {
        return "Tramite{" + "id=" + id + ", fecha=" + fecha + ", costo=" + costo + '}';
    }

}
