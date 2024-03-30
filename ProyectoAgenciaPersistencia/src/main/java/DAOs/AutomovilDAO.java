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
 *
 * @author PC
 */
public class AutomovilDAO implements IAutomovilDAO {

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
