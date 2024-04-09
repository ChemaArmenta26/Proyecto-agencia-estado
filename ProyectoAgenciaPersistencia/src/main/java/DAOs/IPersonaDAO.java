/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOs;

import Entidades.Persona;
import Persistencia.PersistenciaException;
import java.util.Calendar;
import java.util.List;

/**
 * Interfaz que define los métodos para interactuar con la entidad Persona en la base de datos.
 */
public interface IPersonaDAO {
    
    /**
     * Agrega una persona a la base de datos.
     *
     * @param persona La persona a agregar.
     * @return La persona agregada.
     * @throws PersistenciaException Si ocurre un error al intentar agregar la persona.
     */
    public Persona agregarPersona(Persona persona) throws PersistenciaException;
    
    /**
     * Consulta una persona en la base de datos mediante su RFC.
     *
     * @param RFC El RFC de la persona a consultar.
     * @return La persona asociada al RFC.
     * @throws PersistenciaException Si ocurre un error al intentar consultar la persona.
     */
    public Persona consultarPersonaRFC(String RFC) throws PersistenciaException;
    
    /**
     * Consulta personas en la base de datos mediante su nombre.
     *
     * @param Nombre El nombre de la persona o parte de él.
     * @return Una lista de personas que coinciden con el nombre proporcionado.
     * @throws PersistenciaException Si ocurre un error al intentar consultar las personas.
     */
    public List<Persona> consultarPersonasNombre(String Nombre) throws PersistenciaException;
    
    /**
     * Consulta personas en la base de datos mediante su fecha de nacimiento.
     *
     * @param fechaNacimiento La fecha de nacimiento de la persona.
     * @return Una lista de personas que tienen la fecha de nacimiento proporcionada.
     * @throws PersistenciaException Si ocurre un error al intentar consultar las personas.
     */
    public List<Persona> consultarPersonasFechaN(Calendar fechaNacimiento) throws PersistenciaException;
    
    /**
     * Consulta personas en la base de datos mediante su nombre y fecha de nacimiento.
     *
     * @param Nombre El nombre de la persona o parte de él.
     * @param fechaNacimiento La fecha de nacimiento de la persona.
     * @return Una lista de personas que coinciden con el nombre y la fecha de nacimiento proporcionados.
     * @throws PersistenciaException Si ocurre un error al intentar consultar las personas.
     */
    public List<Persona> consultarPersonasFechaNYNombre(String Nombre, Calendar fechaNacimiento) throws PersistenciaException;
    
    /**
     * Consulta personas en la base de datos mediante su nombre, fecha de nacimiento y RFC.
     *
     * @param Nombre El nombre de la persona o parte de él.
     * @param fechaNacimiento La fecha de nacimiento de la persona.
     * @param rfc El RFC de la persona.
     * @return Una lista de personas que coinciden con el nombre, la fecha de nacimiento y el RFC proporcionados.
     * @throws PersistenciaException Si ocurre un error al intentar consultar las personas.
     */
    public List<Persona> consultarPersonasFechaNYNombreYRFC(String Nombre, Calendar fechaNacimiento, String rfc) throws PersistenciaException;
    
    /**
     * Consulta personas en la base de datos mediante su nombre y RFC.
     *
     * @param Nombre El nombre de la persona o parte de él.
     * @param rfc El RFC de la persona.
     * @return Una lista de personas que coinciden con el nombre y el RFC proporcionados.
     * @throws PersistenciaException Si ocurre un error al intentar consultar las personas.
     */
    public List<Persona> consultarPersonasNombreYRFC(String Nombre, String rfc) throws PersistenciaException;
    
    /**
     * Consulta personas en la base de datos mediante su fecha de nacimiento y RFC.
     *
     * @param fechaNacimiento La fecha de nacimiento de la persona.
     * @param rfc El RFC de la persona.
     * @return Una lista de personas que coinciden con la fecha de nacimiento y el RFC proporcionados.
     * @throws PersistenciaException Si ocurre un error al intentar consultar las personas.
     */
    public List<Persona> consultarPersonasFechaNYYRFC(Calendar fechaNacimiento, String rfc) throws PersistenciaException;

    /**
     * Obtiene una persona de la base de datos mediante su identificador.
     *
     * @param id El identificador único de la persona.
     * @return La persona asociada al identificador.
     * @throws PersistenciaException Si ocurre un error al intentar obtener la persona.
     */
    public Persona obtenerPersonaPorId(Long id) throws PersistenciaException;
       
}
