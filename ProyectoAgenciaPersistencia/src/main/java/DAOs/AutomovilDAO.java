/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Conexion.IConexionBD;
import Entidades.Automovil;
import Persistencia.PersistenciaException;
import javax.persistence.EntityManager;

/**
 *
 * @author PC
 */
public class AutomovilDAO implements IAutomovilDAO{
IConexionBD conexion;

    public AutomovilDAO(IConexionBD conexion) {;
        this.conexion = conexion;
    }
    
    @Override
    public Automovil agregarAutomovil(Automovil automovil) throws PersistenciaException {
        EntityManager entityManager = conexion.conexion();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(automovil);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new PersistenciaException("El automovil no se pudo registrar");
        } finally {
            entityManager.close();
        }
        return automovil;
    }
    
}
