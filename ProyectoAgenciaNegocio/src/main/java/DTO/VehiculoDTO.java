/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *  Clase que implementa la lógica de negocio para VehiculoDTO
 */
public class VehiculoDTO {

    private String numero_serie;
    private String modelo;
    private String marca;
    private PersonaDTO persona;

    /**
     * Constructor por defecto de la clase VehiculoDTO.
     */
    public VehiculoDTO() {
    }

    /**
     * Constructor de la clase VehiculoDTO con parámetros.
     * @param numero_serie El número de serie del vehículo
     * @param modelo El modelo del vehículo.
     * @param marca La marca del vehículo.
     * @param persona La persona asociada al vehículo.
     */
    public VehiculoDTO(String numero_serie, String modelo, String marca, PersonaDTO persona) {
        this.numero_serie = numero_serie;
        this.modelo = modelo;
        this.marca = marca;
        this.persona = persona;
    }

    /**
     * Obtiene el número de serie del vehículo.
     * @return El número de serie del vehículo.
     */
    public String getNumero_serie() {
        return numero_serie;
    }

    /**
     * Establece el número de serie del vehículo.
     * @param numero_serie El número de serie del vehículo a establecer.
     */
    public void setNumero_serie(String numero_serie) {
        this.numero_serie = numero_serie;
    }

    /**
     * Obtiene el modelo del vehículo.
     * @return El modelo del vehículo.
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Establece el modelo del vehículo.
     * @param modelo El modelo del vehículo a establecer.
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Obtiene la marca del vehículo.
     * @return La marca del vehículo.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Establece la marca del vehículo.
     * @param marca La marca del vehículo a establecer.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Obtiene la persona asociada al vehículo.
     * @return La persona asociada al vehículo.
     */
    public PersonaDTO getPersona() {
        return persona;
    }

    /**
     * Establece la persona asociada al vehículo.
     * @param persona La persona asociada al vehículo a establecer.
     */
    public void setPersona(PersonaDTO persona) {
        this.persona = persona;
    }

}
