/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BOs;

import DTO.AutomovilDTO;
import DTO.PersonaDTO;
import Entidades.Persona;

/**
 *  Clase que implementa la lógica de negocio para IRegistroAutomovilBO
 */
public interface IRegistroAutomovilBO {

    /**
     * Agrega un nuevo automóvil al sistema.
     * @param automovil El objeto AutomovilDTO que representa el automóvil a agregar.
     */
    public void agregarAutomovil(AutomovilDTO automovil);

    /**
     * Consulta un automóvil por su número de placa.
     * @param numPlaca El número de placa del automóvil a consultar.
     * @return Un objeto AutomovilDTO que contiene la información del automóvil consultado, o null si no se encuentra.
     */
    public AutomovilDTO consultarAutomovilPlaca(String numPlaca);

    /**
     * Obtiene la información de la persona asociada a una licencia con el ID especificado.
     * @param id El ID de la licencia.
     * @param prueba Indica si se está realizando una prueba.
     * @return Un objeto PersonaDTO que representa a la persona asociada a la licencia, o null si no se encuentra.
     */
    public PersonaDTO obtenerPersonaConLicencia(String id, boolean prueba);

    /**
     * Verifica la existencia de una licencia en el sistema.
     * @param id El ID de la licencia a verificar.
     * @return true si la licencia existe, false si no.
     */
    public boolean verificarLicencia(String id);

    /**
     * Obtiene el ID de un automóvil a partir de su número de serie.
     * @param numSerie El número de serie del automóvil.
     * @return El ID del automóvil, o null si no se encuentra.
     */
    public Long obtenerIdConNumeroDeSerie(String numSerie);
}
