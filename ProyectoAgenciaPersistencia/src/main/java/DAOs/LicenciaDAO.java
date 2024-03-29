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
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author pc
 */
public class LicenciaDAO extends TramiteDAO implements ILicenciaDAO {

    IConexionBD conexion;

    public LicenciaDAO(IConexionBD conexion) {
        super(conexion);
        this.conexion = conexion;
    }

    @Override
    public boolean agregarLicencia(int duracion, Persona persona) throws PersistenciaException {
        if (persona != null) {
            EntityManager entityManager = conexion.conexion();
            try {
                entityManager.getTransaction().begin();
                Calendar fecha = Calendar.getInstance();
                Calendar fechaVigencia = Calendar.getInstance();
                fechaVigencia.set(fechaVigencia.get(Calendar.YEAR) + duracion, fechaVigencia.get(Calendar.MONTH), fechaVigencia.get(Calendar.DAY_OF_MONTH));
                Licencia licencia = new Licencia(duracion, fechaVigencia, persona, fecha, this.sacarCosto(persona, duracion), true);
                entityManager.persist(licencia);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                throw new PersistenciaException("No se pudo registrar la licencia correctamente");
            } finally {
                entityManager.close();
            }
            return true;
        }
        return false;
    }

    @Override
    public float sacarCosto(Persona persona, int duracion) throws PersistenciaException {
        if (!persona.getDiscapacitado()) {
            if (duracion == 1) {
                return 600.00f;
            } else if (duracion == 2) {
                return 900.00f;
            } else if (duracion == 3) {
                return 1100.00f;
            } else {
                return 0f;
            }
        } else {
            if (duracion == 1) {
                return 200.00f;
            } else if (duracion == 2) {
                return 500.00f;
            } else if (duracion == 3) {
                return 700.00f;
            } else {
                return 0f;
            }
        }
    }

    @Override
    public boolean actualizarEstadoLicencia(Persona persona) throws PersistenciaException {
        EntityManager entityManager = conexion.conexion();
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("UPDATE Licencia l SET l.estado = false WHERE l.persona = :persona AND l.estado = true");
        query.setParameter("persona", persona);
        int rowsUpdated = query.executeUpdate();

        entityManager.getTransaction().commit();
        entityManager.close();

        return rowsUpdated > 0;
    }

}
