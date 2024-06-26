/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import Conexion.ConexionBD;
import Conexion.IConexionBD;
import DAOs.IPersonaDAO;
import DAOs.IPlacaDAO;
import DAOs.PersonaDAO;
import DAOs.PlacaDAO;
import DTO.PlacaDTO;
import Encriptacion.AlgoritmoEncriptacion;
import Entidades.Automovil;
import Entidades.Persona;
import Entidades.Placa;
import Entidades.Vehiculo;
import Persistencia.PersistenciaException;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;

/**
 *  Clase que implementa la lógica de negocio para RegistroPlacaBO
 */
public class RegistroPlacaBO implements IRegistroPlacaBO {

    IConexionBD conexionBD = new ConexionBD();
    private IPersonaDAO personasDAO = new PersonaDAO(conexionBD);
    private IPlacaDAO placaDAO = new PlacaDAO(conexionBD);
    AlgoritmoEncriptacion encriptador = new AlgoritmoEncriptacion();
    private static final Logger logger = Logger.getLogger(RegistroPlacaBO.class.getName());

    
    
    /**
     * constructor por defecto
     */
    public RegistroPlacaBO() {
    }
    
    
    

    /**
     * Agrega una nueva placa al sistema.
     * @param placaNueva El objeto PlacaDTO que representa la nueva placa a agregar.
     * @return PlacaDTO que representa la placa agregada, o null si ocurrió un error durante el proceso.
     */
    @Override
    public PlacaDTO agregarPlaca(PlacaDTO placaNueva) {
        try {
            // Consultar si el vehículo ya tiene una placa activa
            Placa placaActiva = placaDAO.consultarPlacaActiva(placaNueva.getVehiculo());

            if (placaActiva == null) {
                // Si el vehículo no tiene una placa activa, registrar la nueva placa sin modificar vigencias
                agregarNuevaPlaca(placaNueva);
                JOptionPane.showMessageDialog(null, "Se registró la placa exitosamente");
                logger.log(Level.INFO, "Se registró la placa exitosamente");
            } else {
                // Si el vehículo tiene una placa activa, modificar su estado y fecha de recepción
                placaDAO.actualizarEstadoPlaca(placaActiva);
                placaNueva.setCosto(1500.0f);
                agregarNuevaPlaca(placaNueva);
                JOptionPane.showMessageDialog(null, "Se registró la placa exitosamente");
                logger.log(Level.INFO, "Se registró la placa exitosamente");
            }

            return placaNueva;
        } catch (PersistenciaException pe) {
            logger.log(Level.SEVERE, "Error al tramitar Placa", pe);
        }
        return null;
    }

    /**
     * Agrega una nueva placa al sistema sin verificar la existencia de una placa activa para el vehículo.
     * @param placaNuevaDTO El objeto PlacaDTO que representa la nueva placa a agregar.
     */
    @Override
    public void agregarNuevaPlaca(PlacaDTO placaNuevaDTO) {
        Placa nuevaPlaca = new Placa(placaDAO.generarCodigo(), true, placaNuevaDTO.getVehiculo(),
                placaNuevaDTO.getPersona(), placaNuevaDTO.getFecha(), placaNuevaDTO.getCosto());
        try {
            placaDAO.agregarPlaca(nuevaPlaca);
        } catch (PersistenciaException ex) {
            Logger.getLogger(RegistroPlacaBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Consulta una placa en el sistema mediante su número.
     * @param numPlaca El número de la placa a consultar.
     * @return El objeto PlacaDTO que representa la placa consultada, o null si no se encontró la placa.
     */
    @Override
    public PlacaDTO consultarPlaca(String numPlaca){
        try{
            Placa placa = placaDAO.consultarPlacaNum(numPlaca);
            if (placa == null) {
                JOptionPane.showMessageDialog(null, "No se encontro ninguna placa");
                return null;
            }else{
            PlacaDTO placaNueva = new PlacaDTO(placa.getNumeroPlaca(), placa.getFechaRecepcion(), placa.getEstado(), placa.getVehiculo(), placa.getPersona(), placa.getFecha(), placa.getCosto());
            JOptionPane.showMessageDialog(null, "Placa encontrada");
            return placaNueva;
            }
        }catch (PersistenciaException ex) {
            Logger.getLogger(RegistroPlacaBO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    }
    


