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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author PC
 */
@Entity
public class Licencia extends Tramite implements Serializable {

    

    @Column(name = "Vigencia", nullable = false)
    private int duracionAños;

    @Column(name = "FechaVigenciaExpiracion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar vigenciaF;

    public Licencia() {
    }

    public Licencia(String tipo, int duracionAños, Calendar vigenciaF, Calendar fecha, Float costo, Persona persona) {
        super(fecha, costo, persona);
        this.duracionAños = duracionAños;
        this.vigenciaF = vigenciaF;
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

    @Override
    public String toString() {
        return "Licencia{" + "duracionA\u00f1os=" + duracionAños + ", vigenciaF=" + vigenciaF + '}';
    }

    

}
