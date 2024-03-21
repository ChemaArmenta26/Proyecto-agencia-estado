/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author PC
 */
@Entity
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "RFC",nullable = false, unique = true)
    private String RFC;

    @Column(name = "nombre",nullable = false)
    private String nombre;

    @Column(name = "telefono",nullable = false)
    private String telefono;

    @Temporal(TemporalType.DATE)
    @Column(name = "fechaNacimiento",nullable = false)
    private Date fechaNacimiento;

    @Column(name = "discapacitado",nullable = false)
    private boolean discapacitado;

    @OneToMany(mappedBy = "Persona")
    private List<Tramite> tramites;
    

    public Persona() {
    }

    public Persona(String RFC, String nombre, String telefono, Date fechaNacimiento, boolean discapacitado) {
        this.RFC = RFC;
        this.nombre = nombre;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.discapacitado = discapacitado;
        this.tramites = new ArrayList<>();
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean isDiscapacitado() {
        return discapacitado;
    }

    public void setDiscapacitado(boolean discapacitado) {
        this.discapacitado = discapacitado;
    }

    public List<Tramite> getTramites() {
        return tramites;
    }

    public void setTramites(List<Tramite> tramites) {
        this.tramites = tramites;
    }

    

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", RFC=" + RFC + ", nombre=" + nombre + ", telefono=" + telefono + ", fechaNacimiento=" + fechaNacimiento + ", discapacitado=" + discapacitado + ", tramites=" + tramites + '}';
    }
    
    
    
}
