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
 *  Clase que implementa la lógica de negocio para PersonaDTO
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

    /**
     * Constructor por defecto de la clase PersonaDTO.
     */
    public PersonaDTO() {
    }
    
    /**
     * Constructor con sus parametros
     * @param rfc RFC de la persona.
     * @param nombre Nombre de la persona.
     * @param apellido_paterno Apellido paterno de la persona
     * @param apellido_materno Apellido materno de la persona.
     * @param discapacitado Indica si la persona tiene alguna discapacidad.
     * @param fecha_nacimiento Fecha de nacimiento de la persona.
     * @param telefono Número de teléfono de la persona.
     * @param tramites Lista de licencias asociadas a la persona.
     * @param vehiculos Lista de vehículos asociados a la persona.
     */
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

    /**
     * Constructor con sus parametros
     * @param rfc RFC de la persona.
     * @param nombre Nombre de la persona.
     * @param apellido_paterno Apellido paterno de la persona
     * @param apellido_materno Apellido materno de la persona.
     * @param discapacitado Indica si la persona tiene alguna discapacidad.
     * @param fecha_nacimiento Fecha de nacimiento de la persona.
     * @param telefono Número de teléfono de la persona.
     */
    public PersonaDTO(String rfc, String nombre, String apellido_paterno, String apellido_materno, Boolean discapacitado, Calendar fecha_nacimiento, String telefono) {
        this.rfc = rfc;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.discapacitado = discapacitado;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
    }
    
    /**
     * Obtiene el RFC de la persona.
     * @return El RFC de la persona.
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * Establece el RFC de la persona.
     * @param rfc El RFC de la persona.
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     * Obtiene el nombre de la persona.
     * @return El nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la persona.
     * @param nombre El nombre de la persona.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido paterno de la persona.
     * @return El apellido paterno de la persona.
     */
    public String getApellido_paterno() {
        return apellido_paterno;
    }

    /**
     * Establece el apellido paterno de la persona.
     * @param apellido_paterno El apellido paterno de la persona.
     */
    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    /**
     * Obtiene el apellido materno de la persona.
     * @return El apellido materno de la persona.
     */
    public String getApellido_materno() {
        return apellido_materno;
    }

    /**
     * Establece el apellido materno de la persona.
     * @param apellido_materno El apellido materno de la persona.
     */
    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    /**
     * Indica si la persona tiene alguna discapacidad.
     * @return true si la persona tiene alguna discapacidad, false de lo contrario.
     */
    public Boolean getDiscapacitado() {
        return discapacitado;
    }

    /**
     * Establece si la persona tiene alguna discapacidad.
     * @param discapacitado true si la persona tiene alguna discapacidad, false de lo contrario.
     */
    public void setDiscapacitado(Boolean discapacitado) {
        this.discapacitado = discapacitado;
    }

    /**
     * Obtiene la fecha de nacimiento de la persona
     * @return La fecha de nacimiento de la persona.
     */
    public Calendar getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    /**
     * Establece la fecha de nacimiento de la persona.
     * @param fecha_nacimiento La fecha de nacimiento de la persona.
     */
    public void setFecha_nacimiento(Calendar fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    /**
     * Obtiene el número de teléfono de la persona.
     * @return El número de teléfono de la persona.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono de la persona.
     * @param telefono El número de teléfono de la persona.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene la lista de licencias asociadas a la persona.
     * @return La lista de licencias asociadas a la persona.
     */
    public List<Licencia> getLicencias() {
        return licencias;
    }

    /**
     * Establece la lista de licencias asociadas a la persona.
     * @param tramites La lista de licencias asociadas a la persona.
     */
    public void setLicencias(List<Licencia> tramites) {
        this.licencias = tramites;
    }

    /**
     * Obtiene la lista de vehículos asociados a la persona.
     * @return La lista de vehículos asociados a la persona.
     */
    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    /** 
     *  Establece la lista de vehículos asociados a la persona.
     * @param vehiculos La lista de vehículos asociados a la persona.
     */
    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    /**
     * Obtiene la lista de placas asociadas a la persona.
     * @return La lista de placas asociadas a la persona.
     */
    public List<Placa> getPlacas() {
        return placas;
    }

    /**
     * Establece la lista de placas asociadas a la persona.
     * @param placas La lista de placas asociadas a la persona.
     */
    public void setPlacas(List<Placa> placas) {
        this.placas = placas;
    }

    
}
