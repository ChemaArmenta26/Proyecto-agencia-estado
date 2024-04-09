/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BOs;

import Entidades.Persona;
import java.util.List;

/**
 *  Clase que implementa la lógica de negocio para IAgregarPersonaBO
 */
public interface IAgregarPersonaBO {

    /**
     * Método para agregar personas al sistema.
     */
    public void agregarPersonas();

    /**
     * Método para crear una lista de personas.
     * @return Una lista de objetos Persona creados.
     */
    public List<Persona> crearPersonas();
}
