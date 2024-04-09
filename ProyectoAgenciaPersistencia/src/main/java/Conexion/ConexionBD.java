/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import Persistencia.PersistenciaException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Implementación de la interfaz de conexión a la base de datos.
 */
public class ConexionBD implements IConexionBD {

    /**
     * constructor sin parametros
     */
    public ConexionBD() {
    }

    /**
     * Establece una conexión con la base de datos.
     *
     * @return Una instancia de EntityManager para interactuar con la base de
     * datos.
     * @throws PersistenciaException Si ocurre un error durante la conexión.
     */
    @Override
    public EntityManager conexion() throws PersistenciaException {
        EntityManagerFactory entity = Persistence.createEntityManagerFactory("conexionPU");
        EntityManager entityManager = entity.createEntityManager();
        return entityManager;
    }

}
