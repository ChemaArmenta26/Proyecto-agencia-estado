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
 * Clase que implementa los métodos de acceso a datos para la entidad Licencia.
 * Extiende de TramiteDAO e implementa la interfaz ILicenciaDAO.
 */
public class LicenciaDAO extends TramiteDAO implements ILicenciaDAO {

    IConexionBD conexion;

    /**
     * Constructor de la clase LicenciaDAO.
     *
     * @param conexion La conexión a la base de datos.
     */
    public LicenciaDAO(IConexionBD conexion) {
        super(conexion);
        this.conexion = conexion;
    }

    /**
     * Agrega una licencia a la base de datos.
     *
     * @param licenciaAgregar La licencia que se desea agregar.
     * @return true si la licencia se agregó correctamente, false si no se pudo agregar.
     * @throws PersistenciaException Si ocurre un error al intentar agregar la licencia.
     */
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

    /**
     * Calcula el costo de la licencia para una persona según su situación de discapacidad y la duración deseada.
     *
     * @param persona La persona a la que se le calcula el costo de la licencia.
     * @param duracion La duración deseada de la licencia (1, 2 o 3 años).
     * @return El costo de la licencia.
     * @throws PersistenciaException Si ocurre un error al calcular el costo de la licencia.
     */
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

    /**
     * Actualiza el estado de la licencia de una persona en la base de datos.
     *
     * @param persona La persona cuya licencia se desea actualizar.
     * @return true si se actualizó correctamente, false si no se pudo actualizar.
     * @throws PersistenciaException Si ocurre un error al intentar actualizar el estado de la licencia.
     */
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

    /**
     * Consulta la persona asociada a un número de licencia activo en la base de datos.
     *
     * @param numLicencia El número de licencia que se desea consultar.
     * @return La persona asociada al número de licencia especificado.
     * @throws PersistenciaException Si ocurre un error al intentar consultar la persona con el número de licencia.
     */
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

    /**
     * Genera un número de licencia aleatorio.
     *
     * @return El número de licencia generado.
     */
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
