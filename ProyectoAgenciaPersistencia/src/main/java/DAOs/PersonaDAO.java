
package DAOs;

import Conexion.IConexionBD;
import Entidades.Persona;
import Persistencia.PersistenciaException;
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

        entityManager.getTransaction().begin();
        entityManager.persist(persona);

        entityManager.getTransaction().commit();
        entityManager.close();
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
        }catch(NoResultException e){
            persona = null;
        }
        return persona;
    }

}
