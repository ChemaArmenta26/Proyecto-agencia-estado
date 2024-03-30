/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BOs;

import DTO.PlacaDTO;


/**
 *
 * @author PC
 */
public interface IRegistroPlacaBO {
    public PlacaDTO agregarPlaca(PlacaDTO placa);
    
    public void agregarNuevaPlaca(PlacaDTO placaNuevaDTO);
    public PlacaDTO consultarPlaca(String numPlaca);
}
