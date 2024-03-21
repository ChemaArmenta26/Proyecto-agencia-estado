/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Conexion.IConexionBD;
import Entidades.Tramite;
import Persistencia.PersistenciaException;

/**
 *
 * @author pc
 */
public class TramiteDAO implements ITramiteDAO{

    IConexionBD conexion;

    public TramiteDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }
    
    @Override
    public boolean agregarTramite(Tramite tramite) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
