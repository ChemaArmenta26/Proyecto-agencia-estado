/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import Conexion.ConexionBD;
import DAOs.ILicenciaDAO;
import DAOs.IPersonaDAO;
import DAOs.IPlacaDAO;
import DAOs.ITramiteDAO;
import DAOs.LicenciaDAO;
import DAOs.PersonaDAO;
import DAOs.PlacaDAO;
import DAOs.TramiteDAO;
import DTO.LicenciaDTO;
import DTO.PersonaDTO;
import DTO.PlacaDTO;
import DTO.ReporteDTO;
import DTO.TramiteDTO;
import Entidades.Licencia;
import Entidades.Persona;
import Entidades.Placa;
import Entidades.Tramite;
import Persistencia.PersistenciaException;
import ReporteEstilo.ReporteTramite;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author PC
 */
public class ReporteTramiteBO implements IReporteTramiteBO {

    ConexionBD conexionBD = new ConexionBD();
    private ITramiteDAO tramiteDAO = new TramiteDAO(conexionBD);
    private IPersonaDAO personaDAO = new PersonaDAO(conexionBD);   
    private static final Logger logger = Logger.getLogger(ReporteTramiteBO.class.getName());
    

    @Override
    public List<TramiteDTO> obtenerTramites(ReporteDTO filtro) {
        List<TramiteDTO> listTramites = new ArrayList<>();

        try {
            List<Tramite> tramitesBase = tramiteDAO.consultarTodosTramites();

            for (Tramite tm : tramitesBase) {
                TramiteDTO tramiteDTO = null;

                if (tm instanceof Licencia) {
                    Licencia licencia = (Licencia) tm;
                    tramiteDTO = new LicenciaDTO(
                            licencia.getDuracionAños(),
                            licencia.getVigenciaF(),
                            licencia.isEstado(),
                            licencia.getPersona(),
                            licencia.getNumeroLicencia(),
                            licencia.getFecha(),
                            licencia.getCosto()
                    );
                } else if (tm instanceof Placa) {
                    Placa placa = (Placa) tm;
                    tramiteDTO = new PlacaDTO(
                            placa.getNumeroPlaca(),
                            placa.getFechaRecepcion(),
                            placa.getEstado(),
                            placa.getVehiculo(),
                            placa.getPersona(),
                            placa.getFecha(),
                            placa.getCosto()
                    );
                }

                // Aplicar filtro
                if (cumpleFiltro(tramiteDTO, filtro)) {
                    listTramites.add(tramiteDTO);
                }
            }

            logger.log(Level.INFO, "Se generó la lista de trámites");
            return listTramites;
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error al generar la lista de trámites para reporte");
            return null;
        }
    }

    @Override
    public boolean cumpleFiltro(TramiteDTO tramite, ReporteDTO filtro) {
         // Verificar si el tipo de trámite coincide
        if (filtro.getTipoTramite() != null && !filtro.getTipoTramite().isEmpty()) {
            if (tramite instanceof LicenciaDTO && !filtro.getTipoTramite().equalsIgnoreCase("Licencia")) {
                return false;
            }
            if (tramite instanceof PlacaDTO && !filtro.getTipoTramite().equalsIgnoreCase("Placa")) {
                return false;
            }
        }
        // Si pasa todos los filtros, devuelve true
        return true;
    }
    @Override
    public List<TramiteDTO> obtenerTramitesPorPersona(PersonaDTO persona) {
    List<TramiteDTO> listTramites = new ArrayList<>();

    try {
        Persona personaEntity = new Persona();
        personaEntity.setRFC(persona.getRfc());
        List<Tramite> tramitesBase = tramiteDAO.consultarTramitesPersona(personaEntity);

        for (Tramite tm : tramitesBase) {
            TramiteDTO tramiteDTO = null;

            if (tm instanceof Licencia) {
                Licencia licencia = (Licencia) tm;
                tramiteDTO = new LicenciaDTO(
                            licencia.getDuracionAños(),
                            licencia.getVigenciaF(),
                            licencia.isEstado(),
                            licencia.getPersona(),
                            licencia.getNumeroLicencia(),
                            licencia.getFecha(),
                            licencia.getCosto()
                    );
            } else if (tm instanceof Placa) {
                Placa placa = (Placa) tm;
                tramiteDTO = new PlacaDTO(
                        placa.getNumeroPlaca(),
                        placa.getFechaRecepcion(),
                        placa.getEstado(),
                        placa.getVehiculo(),
                        placa.getPersona(),
                        placa.getFecha(),
                        placa.getCosto()
                );
            }

            // Agregar el trámite DTO a la lista
            listTramites.add(tramiteDTO);
        }

        logger.log(Level.INFO, "Se generó la lista de trámites para la persona: {0}", persona.getRfc());
        return listTramites;
    } catch (PersistenciaException ex) {
        logger.log(Level.SEVERE, "Error al generar la lista de trámites para la persona con RFC: {0}", persona.getRfc());
        return null;
    }
    }
    
    @Override
    public void generarReporte(List<TramiteDTO> listaTramites) {
    // Crear un JRBeanCollectionDataSource con la lista de TramiteDTO
    JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(listaTramites);
    // Parámetros para el reporte
    Map<String, Object> parameters = new HashMap<>();
    parameters.put("CollectionBeanParam", itemsJRBean);

    try {
        
        JasperReport jasperReport = ReporteTramite.getCompiledReport("src\\main\\java\\ReporteEstilo\\ReporteTramite.jrxml");

        // Llenar el reporte con los datos y parámetros proporcionados
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());

        // Exportar el reporte a un archivo PDF
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar Reporte");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos PDF", "pdf"));
        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            String filePath = fileToSave.getAbsolutePath();
            if (!filePath.endsWith(".pdf")) {
                filePath += ".pdf";
            }

            try (OutputStream outputStream = new FileOutputStream(new File(filePath))) {
                JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
            }

            // Log y mensaje de éxito
            logger.log(Level.INFO, "Archivo generado");
            JOptionPane.showMessageDialog(null, "Archivo guardado", "Info", JOptionPane.INFORMATION_MESSAGE);
        } else if (userSelection == JFileChooser.CANCEL_OPTION) {
            // Si el usuario cancela la operación
            logger.log(Level.INFO, "Usuario canceló la operación");
        }
    } catch (Exception ex) {
        // Log y excepción en caso de error
        logger.log(Level.SEVERE, "Error al generar el reporte", ex);
    }
}

    @Override
    public List<Persona> obtenerListaDePersonas(PersonaDTO persona) {
        List<Persona> personas = new ArrayList<>();
        if (!persona.getRfc().equalsIgnoreCase("") && (persona.getNombre().equalsIgnoreCase("") && persona.getFecha_nacimiento() == null)) {
            try{
               personas.add(personaDAO.consultarPersonaRFC(persona.getRfc()));
            }catch(PersistenciaException e){
                JOptionPane.showMessageDialog(null, "Consulta fallida", "RFC", JOptionPane.INFORMATION_MESSAGE);
                return null;
            }
        }else if(!(persona.getRfc().equalsIgnoreCase("") && persona.getNombre().equalsIgnoreCase("")) && persona.getFecha_nacimiento() == null){
            try{
                personas = personaDAO.consultarPersonasNombreYRFC(persona.getNombre(), persona.getRfc());
            }catch(PersistenciaException e){
                JOptionPane.showMessageDialog(null, "Consulta fallida", "Nombre y RFC", JOptionPane.INFORMATION_MESSAGE);
                return null;
            }
        }else if(!(persona.getRfc().equalsIgnoreCase("") && persona.getFecha_nacimiento()==null) && persona.getNombre().equalsIgnoreCase("")){
            try{
                personas = personaDAO.consultarPersonasFechaNYYRFC(persona.getFecha_nacimiento(), persona.getRfc());
            }catch(PersistenciaException e){
                JOptionPane.showMessageDialog(null, "Consulta fallida", "Fecha y RFC", JOptionPane.INFORMATION_MESSAGE);
                return null;
            }
        }else if(!persona.getNombre().equalsIgnoreCase("") && (persona.getRfc().equalsIgnoreCase("") && persona.getFecha_nacimiento() == null)){
            try{
                personas = personaDAO.consultarPersonasNombre(persona.getNombre());
            }catch(PersistenciaException e){
                JOptionPane.showMessageDialog(null, "Consulta fallida", "Nombre", JOptionPane.INFORMATION_MESSAGE);
                return null;
            }
        }else if(persona.getFecha_nacimiento()!= null && (persona.getRfc().equalsIgnoreCase("") && persona.getNombre().equalsIgnoreCase(""))){
            try{
                personas = personaDAO.consultarPersonasFechaN(persona.getFecha_nacimiento());
            }catch(PersistenciaException e){
                JOptionPane.showMessageDialog(null, "Consulta fallida", "Fecha", JOptionPane.INFORMATION_MESSAGE);
                return null;
            }
        }else if(!(persona.getFecha_nacimiento()==null && persona.getNombre().equalsIgnoreCase("")) && persona.getRfc().equalsIgnoreCase("")){
            try{
                personas = personaDAO.consultarPersonasFechaNYNombre(persona.getNombre(), persona.getFecha_nacimiento());
            }catch(PersistenciaException e){
                JOptionPane.showMessageDialog(null, "Consulta fallida", "Fecha y Nombre", JOptionPane.INFORMATION_MESSAGE);
                return null;
            }
        }else{
            try{
                personas = personaDAO.consultarPersonasFechaNYNombreYRFC(persona.getNombre(), persona.getFecha_nacimiento(), persona.getRfc());
            }catch(PersistenciaException e){
                JOptionPane.showMessageDialog(null, "Consulta fallida", "Fecha Nombre y RFC", JOptionPane.INFORMATION_MESSAGE);
                return null;
            }
        }
        
        if (!personas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Consulta Exitosa", "Info", JOptionPane.INFORMATION_MESSAGE);
            return personas;
        }else{
            JOptionPane.showMessageDialog(null, "No se encontro personas", "Info", JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
        
    }
    
}
