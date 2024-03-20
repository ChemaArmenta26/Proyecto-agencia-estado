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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Tipo", nullable = false)
    private String tipo;

    @Column(name = "Vigencia", nullable = false)
    private int duracionAños;

    @Column(name = "FechaVigenciaExpiracion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar vigenciaF;

    public Licencia() {
    }

    public Licencia(String tipo, int duracionAños, Calendar vigenciaF, Calendar fecha, int costo, Persona persona) {
        super(fecha, costo, persona);
        this.tipo = tipo;
        this.duracionAños = duracionAños;
        this.vigenciaF = vigenciaF;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
        return "Licencia{" + "id=" + id + ", tipo=" + tipo + ", duracionA\u00f1os=" + duracionAños + ", vigenciaF=" + vigenciaF + '}';
    }

}
