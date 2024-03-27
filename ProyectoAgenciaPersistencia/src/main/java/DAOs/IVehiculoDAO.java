/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOs;

import Entidades.Persona;
import Entidades.Vehiculo;
import Persistencia.PersistenciaException;
import java.util.List;

/**
 *
 * @author PC
 */
public interface IVehiculoDAO {
    public Vehiculo agregarVehiculo(Vehiculo vehiculo) throws PersistenciaException;
    
    public List<Vehiculo> consultarVehiculosPersona(Persona persona) throws PersistenciaException;
}
