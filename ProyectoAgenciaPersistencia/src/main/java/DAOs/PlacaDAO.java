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
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * Clase que implementa los métodos de acceso a datos para la entidad Placa.
 */
public class PlacaDAO implements IPlacaDAO {

    IConexionBD conexion;

    /**
     * Constructor de la clase PlacaDAO.
     *
     * @param conexion La conexión a la base de datos.
     */
    public PlacaDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }

    /**
     * Agrega una nueva placa a la base de datos.
     *
     * @param placa La placa que se desea agregar.
     * @return La placa agregada.
     * @throws PersistenciaException Si ocurre un error al intentar agregar la placa.
     */
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

    /**
     * Consulta una placa por su número en la base de datos.
     *
     * @param num El número de placa que se desea consultar.
     * @return La placa encontrada con el número especificado, o null si no se encuentra ninguna.
     * @throws PersistenciaException Si ocurre un error al intentar consultar la placa por su número.
     */
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

    /**
     * Consulta la placa activa de un vehículo en la base de datos.
     *
     * @param vehiculo El vehículo del cual se desea consultar la placa activa.
     * @return La placa activa del vehículo especificado, o null si no tiene ninguna placa activa.
     * @throws PersistenciaException Si ocurre un error al intentar consultar la placa activa del vehículo.
     */
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

    /**
     * Actualiza el estado de una placa en la base de datos.
     *
     * @param placa La placa cuyo estado se desea actualizar.
     * @return true si se actualizó el estado correctamente, false en caso contrario.
     * @throws PersistenciaException Si ocurre un error al intentar actualizar el estado de la placa.
     */
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

    /**
     * Genera un código aleatorio para una nueva placa.
     *
     * @return El código aleatorio generado para la nueva placa.
     */
    @Override
    public String generarCodigo() {
         Random rand = new Random();
        StringBuilder codigo = new StringBuilder();

        // Generar las tres letras
        for (int i = 0; i < 3; i++) {
            char letra = (char) (rand.nextInt(26) + 'A'); // Genera una letra mayúscula aleatoria
            codigo.append(letra);
        }

        // Agregar el guión
        codigo.append("-");

        // Generar los tres dígitos
        for (int i = 0; i < 3; i++) {
            int digito = rand.nextInt(10); // Genera un dígito aleatorio entre 0 y 9
            codigo.append(digito);
        }

        return codigo.toString();
    }

}
