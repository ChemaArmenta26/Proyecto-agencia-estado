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
 *
 * @author PC
 */
@Entity
@Table(name = "automoviles")
public class Automovil extends Vehiculo implements Serializable {

    @Column(name = "color", nullable = false)
    private String color;

    @Column(name = "linea", nullable = false)
    private String linea;

    public Automovil() {
    }

    public Automovil(String color, String linea, String numeroSerie, String modelo, String marca, Persona persona) {
        super(numeroSerie, modelo, marca, persona);
        this.color = color;
        this.linea = linea;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    @Override
    public String toString() {
        return "Automovil{" + "color=" + color + ", linea=" + linea + '}';
    }

   
    
    
}
