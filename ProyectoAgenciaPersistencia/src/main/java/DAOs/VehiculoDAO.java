/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Conexion.IConexionBD;
import Entidades.Persona;
import Entidades.Vehiculo;
import Persistencia.PersistenciaException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(vehiculo);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new PersistenciaException("El vehiculo no se pudo registrar");
        } finally {
            entityManager.close();
        }
        return vehiculo;
    }

    @Override
    public List<Vehiculo> consultarVehiculosPersona(Persona persona) throws PersistenciaException {
        EntityManager entityManager = conexion.conexion();
        try {
            String jpql = "SELECT v FROM Vehiculo v WHERE v.persona.rfc LIKE :rfc";
            TypedQuery<Vehiculo> query = entityManager.createQuery(jpql, Vehiculo.class);
            query.setParameter("rfc", "%" + persona.getRFC() + "%");
            List<Vehiculo> vehiculos = query.getResultList();
            return vehiculos;
        } catch (Exception e) {
            throw new PersistenciaException("No se pudieron consultar los vehículos");
        } finally {
            entityManager.close();
        }
    }

}
