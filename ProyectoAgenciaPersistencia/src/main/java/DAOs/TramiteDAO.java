/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Conexion.IConexionBD;
import Entidades.Licencia;
import Entidades.Persona;
import Entidades.Placa;
import Entidades.Tramite;
import Persistencia.PersistenciaException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 * Clase que implementa los métodos de acceso a datos para la entidad Tramite.
 */
public class TramiteDAO implements ITramiteDAO{

    IConexionBD conexion;

    /**
     * Constructor de la clase TramiteDAO.
     *
     * @param conexion La conexión a la base de datos.
     */
    public TramiteDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }
    
    /**
     * Consulta los trámites asociados a una persona en la base de datos.
     *
     * @param persona La persona de la cual se desean consultar los trámites.
     * @return Una lista de trámites asociados a la persona.
     * @throws PersistenciaException Si ocurre un error al intentar consultar los trámites de la persona.
     */
    @Override
    public List<Tramite> consultarTramitesPersona(Persona persona) throws PersistenciaException {
        EntityManager entityManager = null;
        try {
            entityManager = conexion.conexion();
            TypedQuery<Tramite> query = entityManager.createQuery(
                    "SELECT l FROM Licencia l WHERE l.persona = :persona", Tramite.class);
            query.setParameter("persona", persona);
            List<Tramite> listaTramites = query.getResultList();
            
            TypedQuery<Tramite> query2 = entityManager.createQuery(
                    "SELECT p FROM Placa p WHERE p.persona = :persona", Tramite.class);
            query2.setParameter("persona", persona);
            
            listaTramites.addAll(query2.getResultList());
            
            
            return listaTramites;
        } catch (Exception ex) {
            throw new PersistenciaException("Error al consultar trámites de la persona", ex);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    /**
     * Consulta todos los trámites almacenados en la base de datos.
     *
     * @return Una lista de todos los trámites almacenados.
     * @throws PersistenciaException Si ocurre un error al intentar consultar todos los trámites.
     */
    @Override
    public List<Tramite> consultarTodosTramites() throws PersistenciaException {
       EntityManager entityManager = null;
        try {
            entityManager = conexion.conexion();
            TypedQuery<Tramite> query = entityManager.createQuery(
                    "SELECT l FROM Licencia l", Tramite.class);
            List<Tramite> listaTramites = query.getResultList();
            
            TypedQuery<Tramite> query2 = entityManager.createQuery(
                    "SELECT p FROM Placa p", Tramite.class);
            
            listaTramites.addAll(query2.getResultList());
            
            
            return listaTramites;
        } catch (Exception ex) {
            throw new PersistenciaException("Error al consultar trámites de la persona", ex);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
   
}
