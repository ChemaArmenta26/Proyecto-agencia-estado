/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BOs;

import DTO.LicenciaDTO;
import Entidades.Persona;

/**
 *
 * @author PC
 */
public interface IRegistroLicenciaBO {

    public void agregarLicencia(LicenciaDTO licenciaNueva);

    public Persona consultarRFC(String rfc, boolean verifiacion);

    public boolean verificarRFC(String rfc);
}
