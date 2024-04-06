package DAOs;

import Conexion.IConexionBD;
import Entidades.Persona;
import Persistencia.PersistenciaException;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
    public List<Persona> consultarPersonasNombre(String Nombre, String ApellidoPaterno, String ApellidoMaterno) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Persona> consultarPersonasFechaN(Calendar fechaNacimiento) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Persona> consultarPersonasFechaNYNombre(String Nombre, String ApellidoPaterno, String ApellidoMaterno, Calendar fechaNacimiento) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

}
