/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOs;

import Entidades.Tramite;
import Persistencia.PersistenciaException;

/**
 *
 * @author pc
 */
public interface ITramiteDAO {
    
    public boolean agregarTramite(Tramite tramite) throws PersistenciaException;
}
