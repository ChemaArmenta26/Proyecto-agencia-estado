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
public interface ILicenciaDAO extends ITramiteDAO{
    
    
    public boolean agregarLicencia(int duracion, Persona persona) throws PersistenciaException;
    public float sacarCosto(Persona persona, int duracion) throws PersistenciaException;
    boolean actualizarEstadoLicencia(Persona persona) throws PersistenciaException;
}
