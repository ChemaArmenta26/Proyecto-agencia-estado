/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BOs;

import DTO.PlacaDTO;


/**
 *  Clase que implementa la lógica de negocio para IRegistroPlacaBO
 */
public interface IRegistroPlacaBO {

    /**
     * Agrega una nueva placa al sistema.
     * @param placa El objeto PlacaDTO que representa la nueva placa a agregar.
     * @return El objeto PlacaDTO que representa la placa agregada al sistema.
     */
    public PlacaDTO agregarPlaca(PlacaDTO placa);
    
    /**
     * Agrega una nueva placa al sistema sin verificar si el vehículo tiene una placa activa.
     * @param placaNuevaDTO El objeto PlacaDTO que representa la nueva placa a agregar.
     */
    public void agregarNuevaPlaca(PlacaDTO placaNuevaDTO);

    /**
     * Consulta la información de una placa en el sistema por su número.
     * @param numPlaca El número de la placa a consultar.
     * @return El objeto PlacaDTO que representa la información de la placa consultada, o null si no se encuentra.
     */
    public PlacaDTO consultarPlaca(String numPlaca);
}
