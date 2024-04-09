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
import DTO.LicenciaDTO;
import Entidades.Licencia;
import Entidades.Persona;
import Persistencia.PersistenciaException;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *  Clase que implementa la lógica de negocio para RegistroLicenciaBO
 */
public class RegistroLicenciaBO implements IRegistroLicenciaBO {

    IConexionBD conexionBD = new ConexionBD();
    private ILicenciaDAO licenciaDAO = new LicenciaDAO(conexionBD);
    private IPersonaDAO personaDAO = new PersonaDAO(conexionBD);

    
    
    /**
     * constructor por defecto
     */
    public RegistroLicenciaBO() {
    }
    
    
    

    /**
     * Agrega una nueva licencia al sistema.
     * @param licenciaNueva El objeto LicenciaDTO que representa la nueva licencia a agregar.
     */
    @Override
    public void agregarLicencia(LicenciaDTO licenciaNueva) {
        try {
            // Consultar si la persona ya tiene una licencia activa
            if (licenciaDAO.actualizarEstadoLicencia(licenciaNueva.getPersona())) {
                // Si la persona ya tiene una licencia activa, marcarla como inactiva  
                JOptionPane.showMessageDialog(null, "La licencia existente de la persona ha sido marcada como inactiva.");
            }

            Calendar fecha = Calendar.getInstance();
            Calendar fechaVigencia = Calendar.getInstance();
            String numeroLicencia = licenciaDAO.generarNumeroLicencia();
            fechaVigencia.set(fechaVigencia.get(Calendar.YEAR) + licenciaNueva.getDuracionAños(), fechaVigencia.get(Calendar.MONTH), fechaVigencia.get(Calendar.DAY_OF_MONTH));

            licenciaNueva.setFecha(fecha);
            licenciaNueva.setCosto(licenciaDAO.sacarCosto(licenciaNueva.getPersona(), licenciaNueva.getDuracionAños()));
            licenciaNueva.setNumeroLicencia(numeroLicencia);
            licenciaNueva.setVigenciaF(fechaVigencia);
            licenciaNueva.setEstado(true);

            Licencia licencia = new Licencia(licenciaNueva.getDuracionAños(), licenciaNueva.getVigenciaF(), licenciaNueva.getPersona(), licenciaNueva.getFecha(), licenciaNueva.getCosto(), licenciaNueva.isEstado(), licenciaNueva.getNumeroLicencia());
            licencia.setDuracionAños(licenciaNueva.getDuracionAños());
            // Agregar la nueva licencia
            if (licenciaDAO.agregarLicencia(licencia)) {
                JOptionPane.showMessageDialog(null, "Licencia agregada exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo registrar la licencia");
            }
        } catch (PersistenciaException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * Consulta una persona en el sistema mediante su RFC.
     * @param rfc El RFC de la persona a consultar.
     * @param verificacion Indica si se requiere una verificación adicional.
     * @return Persona que representa la persona consultada, o null si no se encontró la persona.
     */
    @Override
    public Persona consultarRFC(String rfc, boolean verificacion) {
        try {
            Persona personaNueva = personaDAO.consultarPersonaRFC(rfc);
            if (personaNueva != null && verificacion) {
                return personaNueva;
            } else {
                return null;
            }
        } catch (PersistenciaException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    /**
     * Verifica la existencia de una persona en el sistema mediante su RFC.
     * @param rfc El RFC de la persona a verificar.
     * @return si la persona existe en el sistema, false en caso contrario.
     */
    @Override
    public boolean verificarRFC(String rfc) {
        try {
            if (personaDAO.consultarPersonaRFC(rfc) != null) {
                JOptionPane.showMessageDialog(null, "Consulta exitosa");
                return true;

            } else {
                JOptionPane.showMessageDialog(null, "Persona no encontrada");
                return false;
            }
        } catch (PersistenciaException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
}
