/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Conexion.IConexionBD;
import Entidades.Automovil;
import Persistencia.PersistenciaException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 * Implementación de la interfaz IAutomovilDAO que proporciona métodos para interactuar con la entidad Automovil en la base de datos.
 */
public class AutomovilDAO implements IAutomovilDAO {

    IConexionBD conexion;

    /**
     * Constructor de la clase AutomovilDAO.
     * @param conexion La conexión a la base de datos.
     */
    public AutomovilDAO(IConexionBD conexion) {;
        this.conexion = conexion;
    }

    /**
     * Agrega un automóvil a la base de datos.
     * @param automovil El automóvil a agregar.
     * @return El automóvil agregado.
     * @throws PersistenciaException Si ocurre un error al intentar agregar el automóvil.
     */
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

    /**
     * Consulta un automóvil por número de serie.
     * @param numSerie El número de serie del automóvil a consultar.
     * @return El automóvil encontrado o null si no se encuentra.
     * @throws PersistenciaException Si ocurre un error al intentar consultar el automóvil.
     */
    @Override
    public Automovil consultarAutomovilNumSerie(String numSerie) throws PersistenciaException {
        EntityManager entityManager = conexion.conexion();
        Automovil automovil = new Automovil();

        try {
            entityManager.getTransaction().begin();
            String jpql = "SELECT a FROM Automovil a WHERE a.numeroSerie = :numSerie";

            TypedQuery<Automovil> query = entityManager.createQuery(jpql, Automovil.class);
            query.setParameter("numSerie", numSerie);
            try {
                automovil = query.getSingleResult();
            } catch (NoResultException e) {
                automovil = null;
            }
            return automovil;
        } catch (Exception e) {
            throw new PersistenciaException("No se pudo consultar el automovil.");
        } finally {
            entityManager.close();
        }
    }

}
