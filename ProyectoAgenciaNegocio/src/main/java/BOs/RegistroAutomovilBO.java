/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import Conexion.ConexionBD;
import Conexion.IConexionBD;
import DAOs.AutomovilDAO;
import DAOs.IAutomovilDAO;
import DAOs.ILicenciaDAO;
import DAOs.IPersonaDAO;
import DAOs.IPlacaDAO;
import DAOs.LicenciaDAO;
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
 * Clase que implementa la lógica de negocio para RegistroAutomovilBO
 */
public class RegistroAutomovilBO implements IRegistroAutomovilBO {

    IConexionBD conexionBD = new ConexionBD();
    private IAutomovilDAO automovilDAO = new AutomovilDAO(conexionBD);
    private ILicenciaDAO licenciaDAO = new LicenciaDAO(conexionBD);
    private IPersonaDAO personasDAO = new PersonaDAO(conexionBD);
    private IPlacaDAO placaDAO = new PlacaDAO(conexionBD);
    AlgoritmoEncriptacion encriptador = new AlgoritmoEncriptacion();
    private static final Logger logger = Logger.getLogger(RegistroAutomovilBO.class.getName());

    /**
     * constructor por defecto
     */
    public RegistroAutomovilBO() {
    }

    /**
     * Agrega un automóvil al sistema.
     *
     * @param automovil El objeto AutomovilDTO que representa el automóvil a
     * agregar.
     */
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
            JOptionPane.showMessageDialog(null, "Se agrego el auto con exito");
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error al agregar el automóvil al sistema", ex);
            JOptionPane.showMessageDialog(null, "No se pudo agregar el vehículo al sistema.");
        }
    }

    /**
     * Consulta la información de un automóvil mediante su número de placa.
     *
     * @param numPlaca El número de placa del automóvil a consultar.
     * @return Un objeto AutomovilDTO con la información del automóvil
     * consultado, o null si no se encontró el automóvil.
     */
    @Override
    public AutomovilDTO consultarAutomovilPlaca(String numPlaca) {
        try {
            // Consultar la placa
            Placa placa = placaDAO.consultarPlacaNum(numPlaca);
            if (placa == null || placa.getVehiculo() == null) {
                JOptionPane.showMessageDialog(null, "No se pudo consultar la placa.");
                return null;
            }

            // Consultar el automóvil asociado a la placa
            Automovil automovil = automovilDAO.consultarAutomovilNumSerie(placa.getVehiculo().getNumeroSerie());
            if (automovil == null) {
                return null;
            }

            // Desencriptar el teléfono de la persona
            String telefonoEncriptado = automovil.getPropietario().getTelefono();
            String telefonoDesencriptado = "";
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

    /**
     * Obtiene la información de una persona que posee una licencia con un
     * número específico.
     *
     * @param id id El número de licencia de la persona.
     * @param prueba Indica si se realiza una prueba o no.
     * @return Un objeto PersonaDTO con la información de la persona, o null si
     * no se encontró la persona.
     */
    @Override
    public PersonaDTO obtenerPersonaConLicencia(String id, boolean prueba) {
        try {
            Persona persona = licenciaDAO.consultarPersonaConNumLicencia(id);
            if (persona != null && prueba) {
                PersonaDTO personaNueva = new PersonaDTO(persona.getRFC(), persona.getNombre(), persona.getApellidoPaterno(), persona.getApellidoMaterno(), persona.getDiscapacitado(), persona.getFechaNacimiento(), persona.getTelefono());
                return personaNueva;
            } else {
                return null;
            }
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error al consultar el automóvil y la placa", ex);
            JOptionPane.showMessageDialog(null, "No se pudo consultar la licencia");
            return null;
        }
    }

    /**
     * Verifica la existencia de una licencia en el sistema.
     *
     * @param id id El número de licencia a verificar.
     * @return true si la licencia existe en el sistema, false en caso
     * contrario.
     */
    public boolean verificarLicencia(String id) {
        try {
            Persona persona = licenciaDAO.consultarPersonaConNumLicencia(id);
            if (persona != null) {
                JOptionPane.showMessageDialog(null, "Licencia encontrada");
                PersonaDTO personaNueva = new PersonaDTO(persona.getRFC(), persona.getNombre(), persona.getApellidoPaterno(), persona.getApellidoMaterno(), persona.getDiscapacitado(), persona.getFechaNacimiento(), persona.getTelefono());
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Licencia no encontrada");
                return false;
            }
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error al consultar el automóvil y la placa", ex);
            JOptionPane.showMessageDialog(null, "No se pudo consultar la licencia");
            return false;
        }
    }

    /**
     * Obtiene el identificador único de un automóvil mediante su número de
     * serie.
     *
     * @param numSerie El número de serie del automóvil.
     * @return El identificador único del automóvil, o null si el automóvil no
     * se encontró en el sistema.
     */
    public Long obtenerIdConNumeroDeSerie(String numSerie) {
        try {
            Automovil auto = automovilDAO.consultarAutomovilNumSerie(numSerie);
            if (auto != null) {
                return auto.getId();
            } else {
                return null;
            }
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error al consultar el automóvil y la placa", ex);
            JOptionPane.showMessageDialog(null, "No se pudo consultar la licencia");
            return null;
        }
    }

}
