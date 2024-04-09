/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOs;

import Entidades.Placa;
import Entidades.Vehiculo;
import Persistencia.PersistenciaException;
import java.util.List;

/**
 * Interfaz que define los métodos para interactuar con la entidad Placa en la base de datos.
 */
public interface IPlacaDAO {

    /**
     * Agrega una placa a la base de datos.
     *
     * @param placa La placa a agregar.
     * @return La placa agregada.
     * @throws PersistenciaException Si ocurre un error al intentar agregar la placa.
     */
    public Placa agregarPlaca(Placa placa) throws PersistenciaException;

    /**
     * Consulta una placa en la base de datos mediante su número.
     *
     * @param num El número de la placa a consultar.
     * @return La placa asociada al número.
     * @throws PersistenciaException Si ocurre un error al intentar consultar la placa.
     */
    public Placa consultarPlacaNum(String num) throws PersistenciaException;
    
    /**
     * Consulta la placa activa de un vehículo en la base de datos.
     *
     * @param vehiculo El vehículo del que se desea consultar la placa activa.
     * @return La placa activa asociada al vehículo.
     * @throws PersistenciaException Si ocurre un error al intentar consultar la placa activa.
     */
    public Placa consultarPlacaActiva(Vehiculo vehiculo) throws PersistenciaException;
    
    /**
     * Actualiza el estado de una placa en la base de datos.
     *
     * @param placa La placa cuyo estado se desea actualizar.
     * @return true si la actualización se realiza correctamente, false en caso contrario.
     * @throws PersistenciaException Si ocurre un error al intentar actualizar el estado de la placa.
     */
    public boolean actualizarEstadoPlaca(Placa placa) throws PersistenciaException;

    /**
     * Genera un código para una nueva placa.
     *
     * @return El código generado para la nueva placa.
     */
    public String generarCodigo();    
}
