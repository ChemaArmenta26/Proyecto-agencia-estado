/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author PC
 */
public class VehiculoDTO {

    private String numero_serie;
    private String modelo;
    private String marca;
    private PersonaDTO persona;

    public VehiculoDTO() {
    }

    public VehiculoDTO(String numero_serie, String modelo, String marca, PersonaDTO persona) {
        this.numero_serie = numero_serie;
        this.modelo = modelo;
        this.marca = marca;
        this.persona = persona;
    }

    

    public String getNumero_serie() {
        return numero_serie;
    }

    public void setNumero_serie(String numero_serie) {
        this.numero_serie = numero_serie;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public PersonaDTO getPersona() {
        return persona;
    }

    public void setPersona(PersonaDTO persona) {
        this.persona = persona;
    }

}
