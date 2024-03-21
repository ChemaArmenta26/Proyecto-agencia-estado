/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Conexion.IConexionBD;
import Entidades.Persona;
import Entidades.Tramite;
import Persistencia.PersistenciaException;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author pc
 */
public class LicenciaDAO extends TramiteDAO implements ILicenciaDAO{

    IConexionBD conexion;

    public LicenciaDAO(IConexionBD conexion) {
        super(conexion);
    }
    
    @Override
    public long autenticarDatos(Persona persona) throws PersistenciaException {
        EntityManager entity = conexion.conexion();
        try {
            // Construir la consulta JPQL
            String jpql = "SELECT COUNT(p) FROM Persona p WHERE p.RFC = :rfc AND p.nombre = :nombre AND p.telefono = :telefono AND p.fechaNacimiento = :fechaNacimiento AND p.discapacitado = :discapacitado";
            Query query = entity.createQuery(jpql);
            query.setParameter("rfc", persona.getRFC());
            query.setParameter("nombre", persona.getNombre());
            query.setParameter("telefono", persona.getTelefono());
            query.setParameter("fechaNacimiento", persona.getFechaNacimiento());
            query.setParameter("discapacitado", persona.isDiscapacitado());

            // Ejecutar la consulta
            Long count = (Long) query.getSingleResult();

            // Si el resultado es mayor que cero, significa que se encontró una coincidencia
            return count;
        } catch(Exception e) {
              System.out.println(e);
              return 0;
        }  
    }

    @Override
    public boolean consultarRFC(String rfc) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean agregarLicencia(int duracion, long idPersona) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public float sacarCosto(long id, int duracion) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean agregarTramite(Tramite tramite) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
