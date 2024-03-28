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

    @Override
    public void agregarAutomovil(AutomovilDTO automovil) {
        try {
            Persona persona = personasDAO.consultarPersonaRFC(automovil.getPersona().getRfc());
            Automovil automovilAgregar = new Automovil(automovil.getColor(), automovil.getLinea(), automovil.getNumero_serie(), automovil.getModelo(),
                    automovil.getMarca(), persona);

            automovilDAO.agregarAutomovil(automovilAgregar);
        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo agregar el vehículo al sistema.");
        }
    }

    @Override
    public AutomovilDTO consultarAutomovilPlaca(String numPlaca) {
        Placa placa = null;
        try {
            placa = placaDAO.consultarPlacaNum(numPlaca);
        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo consultar la placa.");
        }

        Automovil automovil = null;
        try {
            automovil = automovilDAO.consultarAutomovilNumSerie(placa.getVehiculo().getNumeroSerie());
        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo consultar el automovil.");
        }

        String telefonoEnc = new String(automovil.getPropietario().getTelefono());
        PersonaDTO persona = null;
        try {
            persona = new PersonaDTO(automovil.getPropietario().getRFC(), automovil.getPropietario().getNombre(), automovil.getPropietario().getApellidoPaterno(),
                    automovil.getPropietario().getApellidoMaterno(), automovil.getPropietario().isDiscapacitado(), automovil.getPropietario().getFechaNacimiento(),
                    encriptador.decrypt(telefonoEnc), automovil.getPropietario().getLicencias(), automovil.getPropietario().getVehiculos()
            );
        } catch (Exception ex) {

        }

        AutomovilDTO automovilConsulta = new AutomovilDTO(automovil.getLinea(), automovil.getColor(), automovil.getNumeroSerie(),
                automovil.getModelo(), automovil.getMarca(), persona);

        return automovilConsulta;
    }

}
