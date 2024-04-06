/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Conexion.IConexionBD;
import Entidades.Licencia;
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
