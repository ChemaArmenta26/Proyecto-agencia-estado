/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import Conexion.ConexionBD;
import Conexion.IConexionBD;
import DAOs.ILicenciaDAO;
import DAOs.IPersonaDAO;
import DAOs.LicenciaDAO;
import DAOs.PersonaDAO;
import Entidades.Persona;
import Persistencia.PersistenciaException;
import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class RegistroLicenciaBO implements IRegistroLicenciaBO {
    
    IConexionBD conexionBD = new ConexionBD();
    private ILicenciaDAO licenciaDAO = new LicenciaDAO(conexionBD);
    private IPersonaDAO personaDAO = new PersonaDAO(conexionBD);
    
    public void agregarLicencia(int duracion, Persona persona){
        try{
            if (licenciaDAO.agregarLicencia(duracion, persona)) {
                JOptionPane.showMessageDialog(null, "Licencia agregada exitosamente");
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo registrar la licencia");
            }
        }catch(PersistenciaException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public Persona consultarRFC(String rfc, boolean verificacion){
        try{
            Persona personaNueva = personaDAO.consultarPersonaRFC(rfc);
            if (personaNueva != null && verificacion) {
                return personaNueva;
            }else{
                return null;
            }
        }catch(PersistenciaException e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
        }
    public boolean verificarRFC(String rfc){
        try{
            if (personaDAO.consultarPersonaRFC(rfc) != null) {
                JOptionPane.showMessageDialog(null, "Consulta exitosa");
                return true;
                
            }else{
                JOptionPane.showMessageDialog(null, "Persona no encontrada");
                return false;
            }
        }catch(PersistenciaException e){
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
        }
}
