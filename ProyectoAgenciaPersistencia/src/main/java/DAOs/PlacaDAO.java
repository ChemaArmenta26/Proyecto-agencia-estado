/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Conexion.IConexionBD;
import Entidades.Placa;
import Entidades.Vehiculo;
import Persistencia.PersistenciaException;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author PC
 */
public class PlacaDAO implements IPlacaDAO {

    IConexionBD conexion;

    public PlacaDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }

    @Override
    public Placa agregarPlaca(Placa placa) throws PersistenciaException {
        EntityManager entityManager = conexion.conexion();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(placa);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new PersistenciaException("La placa no se pudo registrar correctamente", e);
        } finally {
            entityManager.close();
        }
        return placa;
    }

    @Override
    public Placa consultarPlacaNum(String num) throws PersistenciaException {
        EntityManager entityManager = conexion.conexion();
        Placa placa = null;
        try {
            String jpql = "SELECT p FROM Placa p WHERE p.numeroPlaca = :numPlaca";
            TypedQuery<Placa> query = entityManager.createQuery(jpql, Placa.class);
            query.setParameter("numPlaca", num);
            placa = query.getSingleResult();

        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new PersistenciaException("No se pudo consultar la placa solicitada correctamente", e);
        } finally {
            entityManager.close();
        }
        return placa;
    }

    @Override
    public Placa consultarPlacaActiva(Vehiculo vehiculo) throws PersistenciaException {
        EntityManager entityManager = conexion.conexion();
        try {
            String jpql = "SELECT p FROM Placa p JOIN p.vehiculo v WHERE v.numeroSerie = :numeroSerie AND p.estado = true";
            TypedQuery<Placa> query = entityManager.createQuery(jpql, Placa.class);
            query.setParameter("numeroSerie", vehiculo.getNumeroSerie());
            Placa placa = query.getSingleResult();
            return placa;
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new PersistenciaException("No se pudo consultar la placa activa", e);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean actualizarEstadoPlaca(Placa placa) throws PersistenciaException {
        try {
            EntityManager entityManager = conexion.conexion();
            entityManager.getTransaction().begin();

            Calendar fechaActual = Calendar.getInstance();

            String sentenciaJpql = "UPDATE Placa p SET p.estado = :estado, p.fechaRecepcion = :fecha WHERE p.numeroPlaca = :numPlaca";
            Query query = entityManager.createQuery(sentenciaJpql);
            query.setParameter("estado", false);
            query.setParameter("fecha", fechaActual);
            query.setParameter("numPlaca", placa.getNumeroPlaca());

            int rowsUpdated = query.executeUpdate();

            entityManager.getTransaction().commit();
            entityManager.close();
            return rowsUpdated > 0;
        } catch (Exception e) {
            throw new PersistenciaException("Error al actualizar el estado de la placa", e);
        }
    }

}
