package DAOs;

import Conexion.IConexionBD;
import Entidades.Persona;
import Persistencia.PersistenciaException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author pc
 */
public class PersonaDAO implements IPersonaDAO {

    IConexionBD conexion;

    public PersonaDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }

    @Override
    public Persona agregarPersona(Persona persona) throws PersistenciaException {
        EntityManager entityManager = conexion.conexion();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(persona);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new PersistenciaException("No se pudo agregar a la persona correctamente");
        } finally {
            entityManager.close();
        }
        return persona;
    }

    @Override
    public Persona consultarPersonaRFC(String RFC) throws PersistenciaException {
        EntityManager entityManager = conexion.conexion();
        Persona persona = new Persona();

        String jpql = "SELECT p FROM Persona p WHERE p.RFC = :RFC";

        TypedQuery<Persona> query = entityManager.createQuery(jpql, Persona.class);
        query.setParameter("RFC", RFC);

        try {
            persona = query.getSingleResult();
        } catch (NoResultException e) {
            persona = null;
        }
        return persona;
    }

    @Override
    public List<Persona> consultarPersonasNombre(String nombre) throws PersistenciaException {
        EntityManager entityManager = conexion.conexion();
        Query query = entityManager.createQuery("SELECT p FROM Persona p WHERE p.nombre LIKE :nombre");
        query.setParameter("nombre", "%" + nombre + "%");
        return query.getResultList();
    }

    @Override
    public List<Persona> consultarPersonasFechaN(Calendar fechaNacimiento) throws PersistenciaException {
        EntityManager entityManager = conexion.conexion();
        Query query = entityManager.createQuery("SELECT p FROM Persona p WHERE p.fechaNacimiento = :fechaNacimiento");
        query.setParameter("fechaNacimiento", fechaNacimiento);
        return query.getResultList();
    }

    @Override
    public List<Persona> consultarPersonasFechaNYNombre(String nombre, Calendar fechaNacimiento) throws PersistenciaException {
        EntityManager entityManager = conexion.conexion();
        StringBuilder queryString = new StringBuilder("SELECT p FROM Persona p WHERE 1=1");
        Map<String, Object> parameters = new HashMap<>();

        if (nombre != null && !nombre.isEmpty()) {
            queryString.append(" AND p.nombre LIKE :nombre");
            parameters.put("nombre", "%" + nombre + "%");
        }

        if (fechaNacimiento != null) {
            // Depending on your date format and database setup, you may need to adjust how you handle the date comparison
            queryString.append(" AND p.fechaNacimiento = :fechaNacimiento");
            parameters.put("fechaNacimiento", fechaNacimiento);
        }

        Query query = entityManager.createQuery(queryString.toString());
        for (Map.Entry<String, Object> entry : parameters.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }

        return query.getResultList();
    }

    public List<Persona> consultarPersonasFechaNYNombreYRFC(String nombre, Calendar fechaNacimiento, String rfc) throws PersistenciaException {
        EntityManager entityManager = conexion.conexion();
        StringBuilder queryString = new StringBuilder("SELECT p FROM Persona p WHERE 1=1");
        Map<String, Object> parameters = new HashMap<>();

        if (nombre != null && !nombre.isEmpty()) {
            queryString.append(" AND p.nombre LIKE :nombre");
            parameters.put("nombre", "%" + nombre + "%");
        }

        if (fechaNacimiento != null) {
            // Depending on your date format and database setup, you may need to adjust how you handle the date comparison
            queryString.append(" AND p.fechaNacimiento = :fechaNacimiento");
            parameters.put("fechaNacimiento", fechaNacimiento);
        }

        if (rfc != null && !rfc.isEmpty()) {
            queryString.append(" AND p.RFC = :rfc");
            parameters.put("rfc", rfc);
        }

        Query query = entityManager.createQuery(queryString.toString());
        for (Map.Entry<String, Object> entry : parameters.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }

        return query.getResultList();
    }

}
