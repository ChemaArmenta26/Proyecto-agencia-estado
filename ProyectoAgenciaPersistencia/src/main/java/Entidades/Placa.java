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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clase que representa a una Placa en el sistema.
 */
@Entity
public class Placa extends Tramite implements Serializable {

    @Column(name = "numero_placa", length = 7, unique = true)
    private String numeroPlaca;

    @Column(name = "fecha_recepcion", nullable = true)
    @Temporal(TemporalType.DATE)
    private Calendar fechaRecepcion;

    @Column(name = "estado")
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "numero_serie", nullable = false, referencedColumnName = "id")
    private Vehiculo vehiculo;

    @ManyToOne
    @JoinColumn(name = "id_Persona", referencedColumnName = "id")
    private Persona persona;

    /**
     * Constructor vacío de la clase Placa.
     */
    public Placa() {
    }

    /**
     * Constructor de la clase Placa.
     *
     * @param numeroPlaca El número de la placa.
     * @param estado      El estado de la placa.
     * @param vehiculo    El vehículo asociado a la placa.
     * @param persona     La persona asociada a la placa.
     * @param fecha       La fecha de creación de la placa.
     * @param costo       El costo de la placa.
     */
    public Placa(String numeroPlaca, Boolean estado, Vehiculo vehiculo, Persona persona, Calendar fecha, Float costo) {
        super(fecha, costo);
        this.numeroPlaca = numeroPlaca;
        this.estado = estado;
        this.vehiculo = vehiculo;
        this.persona = persona;
    }

    /**
     * Método para obtener el número de la placa.
     *
     * @return El número de la placa.
     */
    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    /**
     * Método para establecer el número de la placa.
     *
     * @param numeroPlaca El número de la placa a establecer.
     */
    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    /**
     * Método para obtener la fecha de recepción de la placa.
     *
     * @return La fecha de recepción de la placa.
     */
    public Calendar getFechaRecepcion() {
        return fechaRecepcion;
    }

    /**
     * Método para establecer la fecha de recepción de la placa.
     *
     * @param fechaRecepcion La fecha de recepción de la placa a establecer.
     */
    public void setFechaRecepcion(Calendar fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    /**
     * Método para obtener el estado de la placa.
     *
     * @return El estado de la placa.
     */
    public Boolean getEstado() {
        return estado;
    }

     /**
     * Método para establecer el estado de la placa.
     *
     * @param estado El estado de la placa a establecer.
     */
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    /**
     * Método para obtener el vehículo asociado a la placa.
     *
     * @return El vehículo asociado a la placa.
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /**
     * Método para establecer el vehículo asociado a la placa.
     *
     * @param vehiculo El vehículo asociado a la placa a establecer.
     */
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * Método para obtener la persona asociada a la placa.
     *
     * @return La persona asociada a la placa.
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Método para establecer la persona asociada a la placa.
     *
     * @param persona La persona asociada a la placa a establecer.
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * Método para obtener una representación en forma de cadena de la placa.
     *
     * @return Una cadena que representa la información de la placa.
     */
    @Override
    public String toString() {
        return "Placa{" + "numeroPlaca=" + numeroPlaca + ", fechaRecepcion=" + fechaRecepcion + ", estado=" + estado + ", vehiculo=" + vehiculo + '}';
    }

}
