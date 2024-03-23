/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BOs;

import Entidades.Persona;

/**
 *
 * @author PC
 */
public interface IRegistroLicenciaBO {
    
    public void agregarLicencia(int duracion, Persona persona);
    public Persona consultarRFC(String rfc, boolean verifiacion);
    public boolean verificarRFC(String rfc);
}
