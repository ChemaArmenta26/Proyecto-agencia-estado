/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Clase que representa un vehículo.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_vehiculo", discriminatorType = DiscriminatorType.STRING)
public class Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * Identificador único del vehículo.
     */
    private Long id;

    @Column(name = "numero_serie", nullable = false, unique = true)
    /**
     * Número de serie del vehículo.
     */
    private String numeroSerie;

    @Column(name = "modelo", nullable = false)
    /**
     * Modelo del vehículo.
     */
    private String modelo;

    @Column(name = "marca", nullable = false)
    /**
     * Marca del vehículo.
     */
    private String marca;

    @ManyToOne
    @JoinColumn(name = "id_Persona", referencedColumnName = "id", nullable = false)
    /**
     * Propietario del vehículo.
     */
    private Persona propietario;

    @OneToMany(mappedBy = "vehiculo", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    /**
     * Lista de placas asociadas al vehículo.
     */
    private List<Placa> placas;

    /**
     * Constructor vacío de la clase Vehiculo.
     */
    public Vehiculo() {
    }

    /**
     * Constructor de la clase Vehiculo.
     *
     * @param numeroSerie El número de serie del vehículo.
     * @param modelo El modelo del vehículo.
     * @param marca La marca del vehículo.
     * @param persona El propietario del vehículo.
     */
    public Vehiculo(String numeroSerie, String modelo, String marca, Persona persona) {
        this.numeroSerie = numeroSerie;
        this.modelo = modelo;
        this.marca = marca;
        this.propietario = persona;
        this.placas = new ArrayList<>();
    }

    /**
     * Método para obtener el ID del vehículo.
     *
     * @return El ID del vehículo.
     */
    public Long getId() {
        return id;
    }

    /**
     * Método para establecer el ID del vehículo.
     *
     * @param id El ID del vehículo a establecer.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Método para obtener el número de serie del vehículo.
     *
     * @return El número de serie del vehículo.
     */
    public String getNumeroSerie() {
        return numeroSerie;
    }

    /**
     * Método para establecer el número de serie del vehículo.
     *
     * @param numeroSerie El número de serie del vehículo a establecer.
     */
    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    /**
     * Método para obtener el modelo del vehículo.
     *
     * @return El modelo del vehículo.
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Método para establecer el modelo del vehículo.
     *
     * @param modelo El modelo del vehículo a establecer.
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Método para obtener la marca del vehículo.
     *
     * @return La marca del vehículo.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Método para establecer la marca del vehículo.
     *
     * @param marca La marca del vehículo a establecer.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Método para obtener el propietario del vehículo.
     *
     * @return El propietario del vehículo.
     */
    public Persona getPropietario() {
        return propietario;
    }

    /**
     * Método para establecer el propietario del vehículo.
     *
     * @param propietario El propietario del vehículo a establecer.
     */
    public void setPropietario(Persona propietario) {
        this.propietario = propietario;
    }

    /**
     * Método para obtener la lista de placas asociadas al vehículo.
     *
     * @return La lista de placas asociadas al vehículo.
     */
    public List<Placa> getPlacas() {
        return placas;
    }

    /**
     * Método para establecer la lista de placas asociadas al vehículo.
     *
     * @param placas La lista de placas asociadas al vehículo a establecer.
     */
    public void setPlacas(List<Placa> placas) {
        this.placas = placas;
    }

    /**
     * Método para obtener una representación en forma de cadena del vehículo.
     *
     * @return Una cadena que representa la información del vehículo.
     */
    @Override
    public String toString() {
        return "Vehiculo{" + "id=" + id + ", numeroSerie=" + numeroSerie + ", modelo=" + modelo + ", marca=" + marca + ", propietario=" + propietario + ", placas=" + placas + '}';
    }

}
