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
 *
 * @author pc
 */
public interface ITramiteDAO {
    
    public List<Tramite> consultarTramitesPersona(Persona persona) throws PersistenciaException;
    public List<Tramite> consultarTodosTramites() throws PersistenciaException;
}
