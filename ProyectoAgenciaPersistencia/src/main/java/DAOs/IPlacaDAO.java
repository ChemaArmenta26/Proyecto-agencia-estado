/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOs;

import Entidades.Placa;
import Entidades.Vehiculo;
import Persistencia.PersistenciaException;

/**
 *
 * @author PC
 */
public interface IPlacaDAO {

    public Placa agregarPlaca(Placa placa) throws PersistenciaException;

    public Placa consultarPlacaNum(String num) throws PersistenciaException;
    
    public Placa consultarPlacaActiva(Vehiculo vehiculo) throws PersistenciaException;
    
    public boolean actualizarEstadoPlaca(Placa placa) throws PersistenciaException;
    public String generarCodigo();
}
