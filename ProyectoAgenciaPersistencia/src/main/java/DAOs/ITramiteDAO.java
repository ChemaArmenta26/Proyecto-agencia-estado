/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOs;

import Entidades.Persona;
import Entidades.Tramite;
import Persistencia.PersistenciaException;
import java.util.List;

/**
 * Interfaz que define los métodos para interactuar con la entidad Trámite en la base de datos.
 */
public interface ITramiteDAO {
    
    /**
     * Consulta los trámites asociados a una persona en la base de datos.
     *
     * @param persona La persona de la que se desean consultar los trámites.
     * @return Una lista de trámites asociados a la persona especificada.
     * @throws PersistenciaException Si ocurre un error al intentar consultar los trámites de la persona.
     */
    public List<Tramite> consultarTramitesPersona(Persona persona) throws PersistenciaException;

    /**
     * Consulta todos los trámites almacenados en la base de datos.
     *
     * @return Una lista de todos los trámites almacenados en la base de datos.
     * @throws PersistenciaException Si ocurre un error al intentar consultar todos los trámites.
     */
    public List<Tramite> consultarTodosTramites() throws PersistenciaException;
}
