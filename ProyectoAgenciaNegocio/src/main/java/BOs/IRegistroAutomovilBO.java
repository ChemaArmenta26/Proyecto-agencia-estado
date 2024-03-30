/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BOs;

import DTO.AutomovilDTO;
import DTO.PersonaDTO;
import Entidades.Persona;

/**
 *
 * @author PC
 */
public interface IRegistroAutomovilBO {

    public void agregarAutomovil(AutomovilDTO automovil);

    public AutomovilDTO consultarAutomovilPlaca(String numPlaca);

    public PersonaDTO obtenerPersonaConLicencia(String id, boolean prueba);
    public boolean verificarLicencia(String id);

    public Long obtenerIdConNumeroDeSerie(String numSerie);
}
