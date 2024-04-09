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
 * Clase que implementa los métodos de acceso a datos para la entidad Vehiculo.
 */
public class VehiculoDAO implements IVehiculoDAO {

    IConexionBD conexion;

    /**
     * Constructor de la clase VehiculoDAO.
     *
     * @param conexion La conexión a la base de datos.
     */
    public VehiculoDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }

    /**
     * Agrega un vehículo a la base de datos.
     *
     * @param vehiculo El vehículo que se desea agregar.
     * @return El vehículo agregado.
     * @throws PersistenciaException Si ocurre un error al intentar agregar el vehículo.
     */
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

    /**
     * Consulta los vehículos asociados a una persona en la base de datos.
     *
     * @param persona La persona de la cual se desean consultar los vehículos.
     * @return Una lista de vehículos asociados a la persona.
     * @throws PersistenciaException Si ocurre un error al intentar consultar los vehículos de la persona.
     */
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
