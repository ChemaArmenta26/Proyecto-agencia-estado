/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Conexion.IConexionBD;
import Entidades.Licencia;
import Entidades.Persona;
import Persistencia.PersistenciaException;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.swing.JOptionPane;

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
    public boolean agregarLicencia(Licencia licenciaAgregar) throws PersistenciaException {
        if (licenciaAgregar.getPersona() != null) {
            EntityManager entityManager = conexion.conexion();
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(licenciaAgregar);
                JOptionPane.showMessageDialog(null, "Numero de licencia: " + licenciaAgregar.getNumeroLicencia());
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

    public Persona consultarPersonaConNumLicencia(String numLicencia) throws PersistenciaException {
        EntityManager entityManager = conexion.conexion();
        Persona persona = new Persona();
        Query query = entityManager.createQuery("SELECT lic.persona FROM Licencia lic WHERE lic.numeroLicencia = :numeroLicencia AND lic.estado = true");
        query.setParameter("numeroLicencia", numLicencia);
        try {
            persona = (Persona) query.getSingleResult();
            return persona;
        } catch (NoResultException e) {
            return null;
        }
    }

    public String generarNumeroLicencia() {
        StringBuilder numeroLicencia = new StringBuilder();

        Random rand = new Random();

        // Generar cuatro letras aleatorias
        for (int i = 0; i < 4; i++) {
            char letra = (char) (rand.nextInt(26) + 'a'); // Genera una letra minúscula aleatoria
            numeroLicencia.append(letra);
        }

        // Generar dos dígitos aleatorios
        for (int i = 0; i < 2; i++) {
            int digito = rand.nextInt(10); // Genera un dígito aleatorio entre 0 y 9
            numeroLicencia.append(digito);
        }

        // Generar una letra aleatoria
        char letra = (char) (rand.nextInt(26) + 'a'); // Genera una letra minúscula aleatoria
        numeroLicencia.append(letra);

        // Generar dos dígitos aleatorios
        for (int i = 0; i < 2; i++) {
            int digito = rand.nextInt(10); // Genera un dígito aleatorio entre 0 y 9
            numeroLicencia.append(digito);
        }

        return numeroLicencia.toString();
    }

}
