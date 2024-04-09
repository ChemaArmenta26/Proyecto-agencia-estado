/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
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
 * Clase que representa a una persona en el sistema.
 */
@Entity
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Obtiene el ID de la persona.
     *
     * @return El ID de la persona.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID de la persona.
     *
     * @param id El nuevo ID de la persona.
     */
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "RFC", nullable = false, unique = true, length = 150)
    private String RFC;

    @Column(name = "nombre", nullable = false, length = 150)
    private String nombre;

    @Column(name = "ApellidoPaterno", nullable = false, length = 150)
    private String ApellidoPaterno;

    @Column(name = "ApellidoMaterno", nullable = false, length = 150)
    private String ApellidoMaterno;

    @Column(name = "telefono", nullable = false, length = 150)
    private String telefono;

    @Temporal(TemporalType.DATE)
    @Column(name = "fechaNacimiento", nullable = false)
    private Calendar fechaNacimiento;

    @Column(name = "discapacitado", nullable = false)
    private Boolean discapacitado;

    @OneToMany(mappedBy = "persona", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Licencia> licencia;

    @OneToMany(mappedBy = "propietario", cascade = CascadeType.PERSIST)
    private List<Vehiculo> vehiculos;
    
    @OneToMany(mappedBy = "persona", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Placa> placas;

    /**
     * Constructor vacío de la clase Persona.
     */
    public Persona() {
    }

    /**
     * Constructor de la clase Persona.
     *
     * @param RFC              El RFC de la persona.
     * @param nombre           El nombre de la persona.
     * @param ApellidoPaterno  El apellido paterno de la persona.
     * @param ApellidoMaterno  El apellido materno de la persona.
     * @param telefono         El teléfono de la persona.
     * @param fechaNacimiento  La fecha de nacimiento de la persona.
     * @param discapacitado    Indica si la persona tiene discapacidad.
     */
    public Persona(String RFC, String nombre, String ApellidoPaterno, String ApellidoMaterno, String telefono, Calendar fechaNacimiento, boolean discapacitado) {
        this.RFC = RFC;
        this.nombre = nombre;
        this.ApellidoPaterno = ApellidoPaterno;
        this.ApellidoMaterno = ApellidoMaterno;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.discapacitado = discapacitado;
        this.licencia = new ArrayList<>();
        this.vehiculos = new ArrayList<>();
    }

    /**
     * Obtiene el RFC de la persona.
     *
     * @return El RFC de la persona.
     */
    public String getRFC() {
        return RFC;
    }

    /**
     * Establece el RFC de la persona.
     *
     * @param RFC El nuevo RFC de la persona.
     */
    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    /**
     * Obtiene el nombre de la persona.
     *
     * @return El nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la persona.
     *
     * @param nombre El nuevo nombre de la persona.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el teléfono de la persona.
     *
     * @return El teléfono de la persona.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono de la persona.
     *
     * @param telefono El nuevo teléfono de la persona.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * obtiene la fecha de nacimiento
     * @return la fecha de nacimiento
     */
    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     *Establece la fecha de nacimiento
     * @param fechaNacimiento La fecha de nacimeinto estblecida
     */
    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    /**
     * Obtiene el apellido paterno de la persona.
     *
     * @return El apellido paterno de la persona.
     */
    public String getApellidoPaterno() {
        return ApellidoPaterno;
    }

    /**
     * Establece el apellido paterno de la persona.
     *
     * @param ApellidoPaterno El nuevo apellido paterno de la persona.
     */
    public void setApellidoPaterno(String ApellidoPaterno) {
        this.ApellidoPaterno = ApellidoPaterno;
    }

    /**
     * Obtiene el apellido materno de la persona.
     *
     * @return El apellido materno de la persona.
     */
    public String getApellidoMaterno() {
        return ApellidoMaterno;
    }

         
/**
     * Establece el apellido materno de la persona.
     *
     * @param ApellidoMaterno El nuevo apellido materno de la persona.
     */
    public void setApellidoMaterno(String ApellidoMaterno) {
        this.ApellidoMaterno = ApellidoMaterno;
    }

    /**
 * Método para obtener la lista de vehículos asociados a la persona.
 *
 * @return La lista de vehículos asociados a la persona.
 */
    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    /**
 * Método para establecer la lista de vehículos asociados a la persona.
 *
 * @param vehiculos La lista de vehículos a establecer.
 */
    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    /**
 * Método para obtener el estado de discapacidad de la persona.
 *
 * @return true si la persona tiene alguna discapacidad, false en caso contrario.
 */
    public Boolean getDiscapacitado() {
        return discapacitado;
    }

    /**
 * Método para establecer el estado de discapacidad de la persona.
 *
 * @param discapacitado true si la persona tiene alguna discapacidad, false en caso contrario.
 */
    public void setDiscapacitado(Boolean discapacitado) {
        this.discapacitado = discapacitado;
    }

    /**
 * Método para obtener la lista de licencias asociadas a la persona.
 *
 * @return La lista de licencias asociadas a la persona.
 */
    public List<Licencia> getLicencia() {
        return licencia;
    }

    /**
 * Método para establecer la lista de licencias asociadas a la persona.
 *
 * @param licencia La lista de licencias a establecer.
 */
    public void setLicencia(List<Licencia> licencia) {
        this.licencia = licencia;
    }

    /**
 * Método para obtener la lista de placas asociadas a la persona.
 *
 * @return La lista de placas asociadas a la persona.
 */
    public List<Placa> getPlacas() {
        return placas;
    }

    /**
 * Método para establecer la lista de placas asociadas a la persona.
 *
 * @param placas La lista de placas a establecer.
 */
    public void setPlacas(List<Placa> placas) {
        this.placas = placas;
    }

    /**
 * Método que devuelve una representación en forma de cadena de la persona.
 *
 * @return Una cadena que representa la información de la persona.
 */
    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", RFC=" + RFC + ", nombre=" + nombre + ", ApellidoPaterno=" + ApellidoPaterno + ", ApellidoMaterno=" + ApellidoMaterno + ", telefono=" + telefono + ", fechaNacimiento=" + fechaNacimiento + ", discapacitado=" + discapacitado + ", licencia=" + licencia + ", vehiculos=" + vehiculos + '}';
    }
    


}
