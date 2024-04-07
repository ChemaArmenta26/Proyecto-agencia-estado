/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import Entidades.Licencia;
import Entidades.Placa;
import Entidades.Vehiculo;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author pc
 */
public class PersonaDTO {
    
    private String rfc;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private Boolean discapacitado;
    private Calendar fecha_nacimiento;
    private String telefono;
    private List<Licencia> licencias;
    private List<Vehiculo> vehiculos;
    private List<Placa> placas;

    public PersonaDTO() {
    }
    
    

    public PersonaDTO(String rfc, String nombre, String apellido_paterno, String apellido_materno, Boolean discapacitado, Calendar fecha_nacimiento, String telefono, List<Licencia> tramites, List<Vehiculo> vehiculos) {
        this.rfc = rfc;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.discapacitado = discapacitado;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.licencias = tramites;
        this.vehiculos = vehiculos;
    }

    public PersonaDTO(String rfc, String nombre, String apellido_paterno, String apellido_materno, Boolean discapacitado, Calendar fecha_nacimiento, String telefono) {
        this.rfc = rfc;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.discapacitado = discapacitado;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
    }
    

   
    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public Boolean getDiscapacitado() {
        return discapacitado;
    }

    public void setDiscapacitado(Boolean discapacitado) {
        this.discapacitado = discapacitado;
    }

    public Calendar getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Calendar fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Licencia> getLicencias() {
        return licencias;
    }

    public void setLicencias(List<Licencia> tramites) {
        this.licencias = tramites;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public List<Placa> getPlacas() {
        return placas;
    }

    public void setPlacas(List<Placa> placas) {
        this.placas = placas;
    }

    
}
