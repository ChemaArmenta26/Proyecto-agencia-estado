/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author PC
 */
public class AutomovilDTO extends VehiculoDTO{
    private String linea;
    private String color;

    public AutomovilDTO() {
    }

    public AutomovilDTO(String linea, String color, String numero_serie, String modelo, String marca, PersonaDTO persona) {
        super(numero_serie, modelo, marca, persona);
        this.linea = linea;
        this.color = color;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    
}
