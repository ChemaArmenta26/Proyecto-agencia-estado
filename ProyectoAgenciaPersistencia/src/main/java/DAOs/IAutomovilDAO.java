/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOs;

import Entidades.Automovil;
import Persistencia.PersistenciaException;

/**
 *
 * @author PC
 */
public interface IAutomovilDAO {
    public Automovil agregarAutomovil(Automovil automovil) throws PersistenciaException;
}
