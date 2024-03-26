/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOs;

import Entidades.Vehiculo;
import Persistencia.PersistenciaException;

/**
 *
 * @author PC
 */
public interface IVehiculoDAO {
    public Vehiculo agregarVehiculo(Vehiculo vehiculo) throws PersistenciaException;
    
    public Vehiculo consultarVehiculoNumeroSerie(String numSerie) throws PersistenciaException;
}
