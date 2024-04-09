/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase que representa un automóvil en el sistema.
 */
@Entity
@Table(name = "automoviles")
public class Automovil extends Vehiculo implements Serializable {

    @Column(name = "color", nullable = false)
    /**
     * Color del automóvil.
     */
    private String color;

    @Column(name = "linea", nullable = false)
    /**
     * Línea del automóvil.
     */
    private String linea;

    /**
     * Constructor vacío de la clase Automovil.
     */
    public Automovil() {
    }

    /**
     * Constructor de la clase Automovil.
     *
     * @param color El color del automóvil.
     * @param linea La línea del automóvil.
     * @param numeroSerie El número de serie del automóvil.
     * @param modelo El modelo del automóvil.
     * @param marca La marca del automóvil.
     * @param persona La persona asociada al automóvil.
     */
    public Automovil(String color, String linea, String numeroSerie, String modelo, String marca, Persona persona) {
        super(numeroSerie, modelo, marca, persona);
        this.color = color;
        this.linea = linea;
    }

    /**
     * Obtiene el color del automóvil.
     *
     * @return El color del automóvil.
     */
    public String getColor() {
        return color;
    }

    /**
     * Establece el color del automóvil.
     *
     * @param color El nuevo color del automóvil.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Obtiene la línea del automóvil.
     *
     * @return La línea del automóvil.
     */
    public String getLinea() {
        return linea;
    }

    /**
     * Establece la línea del automóvil.
     *
     * @param linea La nueva línea del automóvil.
     */
    public void setLinea(String linea) {
        this.linea = linea;
    }

    /**
     * Devuelve una representación en cadena del objeto Automovil.
     *
     * @return Una cadena que representa el objeto Automovil.
     */
    @Override
    public String toString() {
        return "Automovil{" + "color=" + color + ", linea=" + linea + '}';
    }

}
