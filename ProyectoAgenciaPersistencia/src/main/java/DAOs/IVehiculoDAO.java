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
 * Interfaz que define los métodos para interactuar con la entidad Vehículo en la base de datos.
 */
public interface IVehiculoDAO {

    /**
     * Agrega un vehículo a la base de datos.
     *
     * @param vehiculo El vehículo que se desea agregar.
     * @return El vehículo agregado.
     * @throws PersistenciaException Si ocurre un error al intentar agregar el vehículo.
     */
    public Vehiculo agregarVehiculo(Vehiculo vehiculo) throws PersistenciaException;
    
    /**
     * Consulta los vehículos asociados a una persona en la base de datos.
     *
     * @param persona La persona de la que se desean consultar los vehículos.
     * @return Una lista de vehículos asociados a la persona especificada.
     * @throws PersistenciaException Si ocurre un error al intentar consultar los vehículos de la persona.
     */
    public List<Vehiculo> consultarVehiculosPersona(Persona persona) throws PersistenciaException;
}
