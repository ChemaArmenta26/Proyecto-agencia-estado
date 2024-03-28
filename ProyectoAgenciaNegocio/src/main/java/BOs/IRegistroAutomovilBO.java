/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BOs;

import DTO.AutomovilDTO;

/**
 *
 * @author PC
 */
public interface IRegistroAutomovilBO {
    
     public void agregarAutomovil(AutomovilDTO automovil);

    public AutomovilDTO consultarAutomovilPlaca(String numPlaca);

}
