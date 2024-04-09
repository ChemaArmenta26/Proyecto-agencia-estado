/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *  Clase que implementa la lógica de negocio para AutomovilDTO
 */
public class AutomovilDTO extends VehiculoDTO{
    private String linea;
    private String color;

    /**
     * Constructor por defecto de la clase AutomovilDTO.
     */
    public AutomovilDTO() {
    }

    /**
     * Constructor de la clase AutomovilDTO que inicializa todos los atributos.
     * @param linea La línea del automóvil.
     * @param color El color del automóvil
     * @param numero_serie El número de serie del vehículo.
     * @param modelo El modelo del vehículo.
     * @param marca La marca del vehículo.
     * @param persona El propietario del vehículo.
     */ 
    public AutomovilDTO(String linea, String color, String numero_serie, String modelo, String marca, PersonaDTO persona) {
        super(numero_serie, modelo, marca, persona);
        this.linea = linea;
        this.color = color;
    }

    /**
     * Obtiene la línea del automóvil.
     * @return La línea del automóvil.
     */
    public String getLinea() {
        return linea;
    }

    /**
     * Establece la línea del automóvil.
     * @param linea La línea del automóvil a establecer.
     */
    public void setLinea(String linea) {
        this.linea = linea;
    }

    /**
     * Obtiene el color del automóvil.
     * @return El color del automóvil.
     */
    public String getColor() {
        return color;
    }

    /** 
     * Establece el color del automóvil.
     * @param color El color del automóvil a establecer.
     */
    public void setColor(String color) {
        this.color = color;
    }
    
    
}
