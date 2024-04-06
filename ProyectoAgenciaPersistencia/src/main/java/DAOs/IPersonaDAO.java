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
 *
 * @author pc
 */
public interface IPersonaDAO {
    
    public Persona agregarPersona(Persona persona) throws PersistenciaException;
    
    public Persona consultarPersonaRFC(String RFC) throws PersistenciaException;
    
    public List<Persona> consultarPersonasNombre(String Nombre, String ApellidoPaterno, String ApellidoMaterno) throws PersistenciaException;
    
    public List<Persona> consultarPersonasFechaN(Calendar fechaNacimiento) throws PersistenciaException;
    
    public List<Persona> consultarPersonasFechaNYNombre(String Nombre, String ApellidoPaterno, String ApellidoMaterno, Calendar fechaNacimiento) throws PersistenciaException;
}
