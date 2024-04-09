/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOs;

import Entidades.Licencia;
import Entidades.Persona;
import Persistencia.PersistenciaException;
import java.util.List;

/**
 * Interfaz que define los métodos para interactuar con la entidad Licencia en la base de datos,
 * heredando métodos de la interfaz ITramiteDAO.
 */
public interface ILicenciaDAO extends ITramiteDAO {

    /**
     * Agrega una licencia a la base de datos.
     * @param licenciaAgregar La licencia a agregar.
     * @return true si la licencia se agregó correctamente, false en caso contrario.
     * @throws PersistenciaException Si ocurre un error al intentar agregar la licencia.
     */
    public boolean agregarLicencia(Licencia licenciaAgregar) throws PersistenciaException;

    /**
     * Calcula el costo de una licencia para una persona y una duración determinada.
     * @param persona La persona para la cual se calculará el costo de la licencia.
     * @param duracion La duración de la licencia en años.
     * @return El costo de la licencia.
     * @throws PersistenciaException Si ocurre un error al intentar agregar la licencia.
     */ 
    public float sacarCosto(Persona persona, int duracion) throws PersistenciaException;

    /**
     * Actualiza el estado de la licencia de una persona en la base de datos.
     * @param persona La persona cuya licencia se actualizará.
     * @return true si se actualizó el estado correctamente, false en caso contrario.
     * @throws PersistenciaException Si ocurre un error al intentar agregar la licencia.
     */
    public boolean actualizarEstadoLicencia(Persona persona) throws PersistenciaException;

    /**
     * Consulta una persona en la base de datos mediante su número de licencia.
     * @param numLicencia El número de licencia de la persona a consultar.
     * @return La persona asociada al número de licencia o null si no se encuentra.
     * @throws PersistenciaException Si ocurre un error al intentar agregar la licencia.
     */
    public Persona consultarPersonaConNumLicencia(String numLicencia) throws PersistenciaException;

    /**
     * Genera un número de licencia de manera aleatoria.
     * @return El número de licencia generado.
     */
    public String generarNumeroLicencia();
    
}
