/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Conexion.IConexionBD;
import Entidades.Persona;
import Entidades.Tramite;
import Persistencia.PersistenciaException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author pc
 */
public class TramiteDAO implements ITramiteDAO{

    IConexionBD conexion;

    public TramiteDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }
    
    @Override
    public List<Tramite> consultarTramitesPersona(Persona persona) throws PersistenciaException {
        EntityManager entityManager = null;
        try {
            entityManager = conexion.conexion();
            TypedQuery<Tramite> query = entityManager.createQuery(
                    "SELECT t FROM Tramite t WHERE t.persona = :persona", Tramite.class);
            query.setParameter("persona", persona);
            return query.getResultList();
        } catch (Exception ex) {
            throw new PersistenciaException("Error al consultar trámites de la persona", ex);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    @Override
    public List<Tramite> consultarTodosTramites() throws PersistenciaException {
        EntityManager entityManager = null;
        try {
            entityManager = conexion.conexion();
            TypedQuery<Tramite> query = entityManager.createQuery(
                    "SELECT t FROM Tramite t", Tramite.class);
            return query.getResultList();
        } catch (Exception ex) {
            throw new PersistenciaException("Error al consultar todos los trámites", ex);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
    
}
