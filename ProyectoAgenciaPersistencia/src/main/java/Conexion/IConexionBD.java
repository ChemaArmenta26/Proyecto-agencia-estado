/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Conexion;

import Persistencia.PersistenciaException;
import javax.persistence.EntityManager;


/**
 *
 * @author pc
 */
public interface IConexionBD {
    
    
    public EntityManager conexion() throws PersistenciaException;
}
