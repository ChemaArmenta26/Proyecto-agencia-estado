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
 * Clase que implementa los métodos de acceso a datos para la entidad Persona.
 */
public class PersonaDAO implements IPersonaDAO {

    IConexionBD conexion;

    /**
     * Constructor de la clase PersonaDAO.
     *
     * @param conexion La conexión a la base de datos.
     */
    public PersonaDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }

    /**
     * Agrega una persona a la base de datos.
     *
     * @param persona La persona que se desea agregar.
     * @return La persona agregada.
     * @throws PersistenciaException Si ocurre un error al intentar agregar la persona.
     */
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

    /**
     * Consulta una persona por su RFC en la base de datos.
     *
     * @param RFC El RFC de la persona que se desea consultar.
     * @return La persona encontrada con el RFC especificado.
     * @throws PersistenciaException Si ocurre un error al intentar consultar la persona por su RFC.
     */
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

    /**
     * Consulta personas cuyo nombre coincida parcialmente con el proporcionado.
     *
     * @param nombre El nombre (o parte del nombre) de las personas que se desean consultar.
     * @return Una lista de personas cuyo nombre coincida parcialmente con el proporcionado.
     * @throws PersistenciaException Si ocurre un error al intentar consultar las personas por nombre.
     */
    @Override
    public List<Persona> consultarPersonasNombre(String nombre) throws PersistenciaException {
        EntityManager entityManager = conexion.conexion();
        Query query = entityManager.createQuery("SELECT p FROM Persona p WHERE p.nombre LIKE :nombre");
        query.setParameter("nombre", "%" + nombre + "%");
        return query.getResultList();
    }

    /**
     * Consulta personas que nacieron en una fecha específica.
     *
     * @param fechaNacimiento La fecha de nacimiento de las personas que se desean consultar.
     * @return Una lista de personas que nacieron en la fecha especificada.
     * @throws PersistenciaException Si ocurre un error al intentar consultar las personas por fecha de nacimiento.
     */
    @Override
    public List<Persona> consultarPersonasFechaN(Calendar fechaNacimiento) throws PersistenciaException {
        EntityManager entityManager = conexion.conexion();
        Query query = entityManager.createQuery("SELECT p FROM Persona p WHERE p.fechaNacimiento = :fechaNacimiento");
        query.setParameter("fechaNacimiento", fechaNacimiento);
        return query.getResultList();
    }

    /**
     * Consulta personas cuyo nombre coincida parcialmente con el proporcionado y que nacieron en una fecha específica.
     *
     * @param nombre El nombre (o parte del nombre) de las personas que se desean consultar.
     * @param fechaNacimiento La fecha de nacimiento de las personas que se desean consultar.
     * @return Una lista de personas cuyo nombre coincida parcialmente con el proporcionado y que nacieron en la fecha especificada.
     * @throws PersistenciaException Si ocurre un error al intentar consultar las personas por nombre y fecha de nacimiento.
     */
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

    /**
     * Consulta personas cuyo nombre coincida parcialmente con el proporcionado, que nacieron en una fecha específica y que tienen un RFC específico.
     *
     * @param nombre El nombre (o parte del nombre) de las personas que se desean consultar.
     * @param fechaNacimiento La fecha de nacimiento de las personas que se desean consultar.
     * @param rfc El RFC de las personas que se desean consultar.
     * @return Una lista de personas cuyo nombre coincida parcialmente con el proporcionado, que nacieron en la fecha especificada y que tienen el RFC especificado.
     * @throws PersistenciaException Si ocurre un error al intentar consultar las personas por nombre, fecha de nacimiento y RFC.
     */
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

    /**
     * Consulta personas cuyo nombre coincida parcialmente con el proporcionado y que tengan un RFC específico.
     *
     * @param nombre El nombre (o parte del nombre) de las personas que se desean consultar.
     * @param rfc El RFC de las personas que se desean consultar.
     * @return Una lista de personas cuyo nombre coincida parcialmente con el proporcionado y que tengan el RFC especificado.
     * @throws PersistenciaException Si ocurre un error al intentar consultar las personas por nombre y RFC.
     */
    @Override
    public List<Persona> consultarPersonasNombreYRFC(String nombre, String rfc) throws PersistenciaException {
        EntityManager entityManager = conexion.conexion();
        StringBuilder queryString = new StringBuilder("SELECT p FROM Persona p WHERE 1=1");
        Map<String, Object> parameters = new HashMap<>();

        if (nombre != null && !nombre.isEmpty()) {
            queryString.append(" AND p.nombre LIKE :nombre");
            parameters.put("nombre", "%" + nombre + "%");
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

    /**
     * Consulta personas que nacieron en una fecha específica y que tengan un RFC específico.
     *
     * @param fechaNacimiento La fecha de nacimiento de las personas que se desean consultar.
     * @param rfc El RFC de las personas que se desean consultar.
     * @return Una lista de personas que nacieron en la fecha especificada y que tienen el RFC especificado.
     * @throws PersistenciaException Si ocurre un error al intentar consultar las personas por fecha de nacimiento y RFC.
     */
    @Override
    public List<Persona> consultarPersonasFechaNYYRFC(Calendar fechaNacimiento, String rfc) throws PersistenciaException {
        EntityManager entityManager = conexion.conexion();
        StringBuilder queryString = new StringBuilder("SELECT p FROM Persona p WHERE 1=1");
        Map<String, Object> parameters = new HashMap<>();

        if (fechaNacimiento != null) {
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

    /**
     * Obtiene una persona por su ID.
     *
     * @param id El ID de la persona que se desea obtener.
     * @return La persona encontrada con el ID especificado, o null si no se encuentra ninguna persona con ese ID.
     * @throws PersistenciaException Si ocurre un error al intentar obtener la persona por su ID.
     */
    @Override
    public Persona obtenerPersonaPorId(Long id) throws PersistenciaException {
        EntityManager entityManager = conexion.conexion();
        
try {
            // Utilizar una consulta tipada para obtener la persona por su ID
            TypedQuery<Persona> query = entityManager.createQuery(
                    "SELECT p FROM Persona p WHERE p.id = :id", Persona.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        } catch (NoResultException e) {
            // Si no se encuentra ninguna persona con el ID proporcionado, devolver null
            return null;
        }    }
    
    
    
    

}
