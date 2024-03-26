/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Conexion.IConexionBD;
import Entidades.Vehiculo;
import Persistencia.PersistenciaException;
import javax.persistence.EntityManager;

/**
 *
 * @author PC
 */
public class VehiculoDAO implements IVehiculoDAO {

    IConexionBD conexion;

    public VehiculoDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }

    @Override
    public Vehiculo agregarVehiculo(Vehiculo vehiculo) throws PersistenciaException {
       EntityManager entityManager = conexion.conexion();

        entityManager.getTransaction().begin();
        entityManager.persist(vehiculo);

        entityManager.getTransaction().commit();
        entityManager.close();
        return vehiculo;
    }

    @Override
    public Vehiculo consultarVehiculoNumeroSerie(String numSerie) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
