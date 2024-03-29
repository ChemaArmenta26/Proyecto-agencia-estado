/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import Conexion.ConexionBD;
import Conexion.IConexionBD;
import DAOs.AutomovilDAO;
import DAOs.IAutomovilDAO;
import DAOs.IPersonaDAO;
import DAOs.IPlacaDAO;
import DAOs.PersonaDAO;
import DAOs.PlacaDAO;
import DTO.AutomovilDTO;
import DTO.PersonaDTO;
import DTO.VehiculoDTO;
import Encriptacion.AlgoritmoEncriptacion;
import Entidades.Automovil;
import Entidades.Persona;
import Entidades.Placa;
import Persistencia.PersistenciaException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class RegistroAutomovilBO implements IRegistroAutomovilBO {

    IConexionBD conexionBD = new ConexionBD();
    private IAutomovilDAO automovilDAO = new AutomovilDAO(conexionBD);
    private IPersonaDAO personasDAO = new PersonaDAO(conexionBD);
    private IPlacaDAO placaDAO = new PlacaDAO(conexionBD);
    AlgoritmoEncriptacion encriptador = new AlgoritmoEncriptacion();
    private static final Logger logger = Logger.getLogger(RegistroAutomovilBO.class.getName());

    @Override
    public void agregarAutomovil(AutomovilDTO automovil) {
        try {
            // Consultar la persona asociada al automóvil
            Persona persona = personasDAO.consultarPersonaRFC(automovil.getPersona().getRfc());
            if (persona == null) {
                throw new IllegalArgumentException("La persona asociada al automóvil no existe en la base de datos.");
            }

            // Agregar el automóvil
            Automovil automovilAgregar = new Automovil(automovil.getColor(), automovil.getLinea(), automovil.getNumero_serie(),
                    automovil.getModelo(), automovil.getMarca(), persona);
            automovilDAO.agregarAutomovil(automovilAgregar);
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error al agregar el automóvil al sistema", ex);
            JOptionPane.showMessageDialog(null, "No se pudo agregar el vehículo al sistema.");
        }
    }

    @Override
    public AutomovilDTO consultarAutomovilPlaca(String numPlaca) {
       try {
        // Consultar la placa
        Placa placa = placaDAO.consultarPlacaNum(numPlaca);
        if (placa == null || placa.getVehiculo() == null) {
            return null;
        }
        
        // Consultar el automóvil asociado a la placa
        Automovil automovil = automovilDAO.consultarAutomovilNumSerie(placa.getVehiculo().getNumeroSerie());
        if (automovil == null) {
            return null;
        }
        
        // Desencriptar el teléfono de la persona
        String telefonoEncriptado = new String(automovil.getPropietario().getTelefono());
        String telefonoDesencriptado = null;
        try {
            telefonoDesencriptado = encriptador.decrypt(telefonoEncriptado);
        } catch (Exception ex) {
            logger.log(Level.WARNING, "Error al desencriptar el teléfono del propietario", ex);
        }
        
        // Crear el objeto PersonaDTO
        PersonaDTO personaDTO = new PersonaDTO(automovil.getPropietario().getRFC(), automovil.getPropietario().getNombre(),
            automovil.getPropietario().getApellidoPaterno(), automovil.getPropietario().getApellidoMaterno(),
            automovil.getPropietario().getDiscapacitado(), automovil.getPropietario().getFechaNacimiento(),
            telefonoDesencriptado, automovil.getPropietario().getLicencia(), automovil.getPropietario().getVehiculos());

        // Crear el objeto AutomovilDTO
        AutomovilDTO automovilConsulta = new AutomovilDTO(automovil.getLinea(), automovil.getColor(), automovil.getNumeroSerie(),
            automovil.getModelo(), automovil.getMarca(), personaDTO);

        return automovilConsulta;
    } catch (PersistenciaException ex) {
        logger.log(Level.SEVERE, "Error al consultar el automóvil y la placa", ex);
        JOptionPane.showMessageDialog(null, "No se pudo consultar el automovil y la placa.");
        return null;
    }
    }

}
