/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Conexion.IConexionBD;
import Entidades.Persona;
import Persistencia.PersistenciaException;
import javax.persistence.EntityManager;

/**
 *
 * @author pc
 */
public class PersonaDAO implements IPersonaDAO{

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
    
}
