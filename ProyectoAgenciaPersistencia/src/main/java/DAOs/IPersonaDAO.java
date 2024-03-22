/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOs;

import Entidades.Persona;
import Persistencia.PersistenciaException;

/**
 *
 * @author pc
 */
public interface IPersonaDAO {
    
    public Persona agregarPersona(Persona persona) throws PersistenciaException;
    
    public Persona consultarPersonaRFC(String RFC) throws PersistenciaException;
}
