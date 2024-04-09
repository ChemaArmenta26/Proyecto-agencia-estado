/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOs;

import Entidades.Automovil;
import Persistencia.PersistenciaException;

/**
 * Interfaz que define los métodos para interactuar con la entidad Automovil en la base de datos.
 */
public interface IAutomovilDAO {

    /**
     * Agrega un automóvil a la base de datos.
     * @param automovil El automóvil a agregar.
     * @return El automóvil agregado.
     * @throws PersistenciaException Si ocurre un error al intentar agregar el automóvil.
     */
    public Automovil agregarAutomovil(Automovil automovil) throws PersistenciaException;
    
    /**
     * Consulta un automóvil por número de serie.
     * @param numSerie El número de serie del automóvil a consultar.
     * @return El automóvil encontrado o null si no se encuentra.
     * @throws PersistenciaException Si ocurre un error al intentar agregar el automóvil.
     */
    public Automovil consultarAutomovilNumSerie(String numSerie) throws PersistenciaException;
}
