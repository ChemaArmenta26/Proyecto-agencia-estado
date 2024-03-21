/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOs;

import Persistencia.PersistenciaException;

/**
 *
 * @author pc
 */
public interface IUsuarioDAO {
    
    
    public boolean autenticarUsuario(String usuario, String contraseña) throws PersistenciaException;
    public boolean agregarUsuario(String usuario, String contraseña) throws PersistenciaException;
    
}
