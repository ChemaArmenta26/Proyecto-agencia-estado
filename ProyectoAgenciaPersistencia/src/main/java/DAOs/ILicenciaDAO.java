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
    
    public long autenticarDatos(Persona persona) throws PersistenciaException;
    public boolean consultarRFC(String rfc) throws PersistenciaException;
    public boolean agregarLicencia(int duracion, long idPersona) throws PersistenciaException;
    public float sacarCosto(long id, int duracion) throws PersistenciaException;
}
