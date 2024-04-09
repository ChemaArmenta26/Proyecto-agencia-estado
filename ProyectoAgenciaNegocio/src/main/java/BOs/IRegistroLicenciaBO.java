/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BOs;

import DTO.LicenciaDTO;
import Entidades.Persona;

/**
 *  Clase que implementa la lógica de negocio para IRegistroLicenciaBO
 */
public interface IRegistroLicenciaBO {

    /**
     * Agrega una nueva licencia al sistema.
     * @param licenciaNueva El objeto LicenciaDTO que representa la nueva licencia a agregar.
     */
    public void agregarLicencia(LicenciaDTO licenciaNueva);

    /**
     * Consulta la información de una persona por su RFC.
     * @param rfc El RFC de la persona a consultar.
     * @param verifiacion Indica si se realiza una verificación adicional.
     * @return Un objeto Persona que contiene la información de la persona consultada, o null si no se encuentra.
     */
    public Persona consultarRFC(String rfc, boolean verifiacion);

    /**
     * Verifica la existencia de una persona en el sistema mediante su RFC.
     * @param rfc El RFC de la persona a verificar.
     * @return true si la persona existe en el sistema, false si no.
     */
    public boolean verificarRFC(String rfc);
}
