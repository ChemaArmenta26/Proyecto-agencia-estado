/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Conexion;

import Persistencia.PersistenciaException;
import javax.persistence.EntityManager;


/**
 * Interfaz para la conexión a la base de datos.
 */
public interface IConexionBD {
    
    /**
     * Establece una conexión con la base de datos.
     * @return Una instancia de EntityManager para interactuar con la base de datos.
     * @throws PersistenciaException Si ocurre un error durante la conexión.
     */
    public EntityManager conexion() throws PersistenciaException;
}
