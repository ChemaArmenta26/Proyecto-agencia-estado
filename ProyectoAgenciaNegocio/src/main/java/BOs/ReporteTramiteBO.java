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
import DTO.ReporteDeTramiteDTO;
import DTO.TramiteDTO;
import Entidades.Licencia;
import Entidades.Persona;
import Entidades.Placa;
import Entidades.Tramite;
import Persistencia.PersistenciaException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

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
    public List<ReporteDeTramiteDTO> obtenerTramitesReporte(ReporteDTO filtro) {
        List<ReporteDeTramiteDTO> listTramites = new ArrayList<>();

        try {
            List<Tramite> tramitesBase = this.tramiteDAO.consultarTodosTramites();
            for (Tramite tm : tramitesBase) {
                TramiteDTO tramiteDTO = null;
                StringBuilder nombreCompleto = new StringBuilder();

                String tipoTramite = null;
                if (tm instanceof Licencia) {
                    tipoTramite = "Licencia";
                    nombreCompleto.append(((Licencia) tm).getPersona().getNombre())
                            .append(" ")
                            .append(((Licencia) tm).getPersona().getApellidoPaterno())
                            .append(" ")
                            .append(((Licencia) tm).getPersona().getApellidoMaterno());
                } else if (tm instanceof Placa) {
                    tipoTramite = "Placa";
                    nombreCompleto.append(((Placa) tm).getPersona().getNombre())
                            .append(" ")
                            .append(((Placa) tm).getPersona().getApellidoPaterno())
                            .append(" ")
                            .append(((Placa) tm).getPersona().getApellidoMaterno());
                }

                String nombreCompletoStr = nombreCompleto.toString();

                Date fecha = tm.getFecha().getTime();

                ReporteDeTramiteDTO tramiteReporte = new ReporteDeTramiteDTO(
                        fecha,
                        tipoTramite,
                        nombreCompletoStr,
                        NumberFormat.getCurrencyInstance().format(tm.getCosto()));

                if (filtro.getTipoTramite() != null) {
                    if (cumpleFiltro(tramiteDTO, filtro)) {
                        listTramites.add(tramiteReporte);
                    }
                } else {
                    listTramites.add(tramiteReporte);
                }
            }
            logger.log(Level.INFO, "Se genero la lista de tramites para los reportes");
            return listTramites;
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error al generar la lista de tramites para reporte");
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
    public void generarReporte(List<ReporteDeTramiteDTO> listaTramites) {
        
        JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(listaTramites);
        
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("ds", itemsJRBean);

        
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


            try (InputStream input = new FileInputStream(new File("ReporteDeTramites.jrxml"))) {
                JasperDesign jasperDesign = JRXmlLoader.load(input);

                JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
              
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());

             
                try (
                        OutputStream outputStream = new FileOutputStream(new File(filePath))) {
                    JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
                }

            } catch (Exception ex) {
               
                logger.log(Level.SEVERE, "Error al generar el reporte");

            }
         
            logger.log(Level.INFO, "Archivo generado");
            JOptionPane.showMessageDialog(null, "Archivo guardado", "Info", JOptionPane.INFORMATION_MESSAGE);
        } else if (userSelection == JFileChooser.CANCEL_OPTION) {
            
            logger.log(Level.INFO, "Usuario cancelo la operacion");
        }
    }

    @Override
    public List<Persona> obtenerListaDePersonas(PersonaDTO persona) {
        List<Persona> personas = new ArrayList<>();
        if (!persona.getRfc().equalsIgnoreCase("") && (persona.getNombre().equalsIgnoreCase("") && persona.getFecha_nacimiento() == null)) {
            try {
                personas.add(personaDAO.consultarPersonaRFC(persona.getRfc()));
            } catch (PersistenciaException e) {
                JOptionPane.showMessageDialog(null, "Consulta fallida", "RFC", JOptionPane.INFORMATION_MESSAGE);
                return null;
            }
        } else if (!(persona.getRfc().equalsIgnoreCase("") && persona.getNombre().equalsIgnoreCase("")) && persona.getFecha_nacimiento() == null) {
            try {
                personas = personaDAO.consultarPersonasNombreYRFC(persona.getNombre(), persona.getRfc());
            } catch (PersistenciaException e) {
                JOptionPane.showMessageDialog(null, "Consulta fallida", "Nombre y RFC", JOptionPane.INFORMATION_MESSAGE);
                return null;
            }
        } else if (!(persona.getRfc().equalsIgnoreCase("") && persona.getFecha_nacimiento() == null) && persona.getNombre().equalsIgnoreCase("")) {
            try {
                personas = personaDAO.consultarPersonasFechaNYYRFC(persona.getFecha_nacimiento(), persona.getRfc());
            } catch (PersistenciaException e) {
                JOptionPane.showMessageDialog(null, "Consulta fallida", "Fecha y RFC", JOptionPane.INFORMATION_MESSAGE);
                return null;
            }
        } else if (!persona.getNombre().equalsIgnoreCase("") && (persona.getRfc().equalsIgnoreCase("") && persona.getFecha_nacimiento() == null)) {
            try {
                personas = personaDAO.consultarPersonasNombre(persona.getNombre());
            } catch (PersistenciaException e) {
                JOptionPane.showMessageDialog(null, "Consulta fallida", "Nombre", JOptionPane.INFORMATION_MESSAGE);
                return null;
            }
        } else if (persona.getFecha_nacimiento() != null && (persona.getRfc().equalsIgnoreCase("") && persona.getNombre().equalsIgnoreCase(""))) {
            try {
                personas = personaDAO.consultarPersonasFechaN(persona.getFecha_nacimiento());
            } catch (PersistenciaException e) {
                JOptionPane.showMessageDialog(null, "Consulta fallida", "Fecha", JOptionPane.INFORMATION_MESSAGE);
                return null;
            }
        } else if (!(persona.getFecha_nacimiento() == null && persona.getNombre().equalsIgnoreCase("")) && persona.getRfc().equalsIgnoreCase("")) {
            try {
                personas = personaDAO.consultarPersonasFechaNYNombre(persona.getNombre(), persona.getFecha_nacimiento());
            } catch (PersistenciaException e) {
                JOptionPane.showMessageDialog(null, "Consulta fallida", "Fecha y Nombre", JOptionPane.INFORMATION_MESSAGE);
                return null;
            }
        } else {
            try {
                personas = personaDAO.consultarPersonasFechaNYNombreYRFC(persona.getNombre(), persona.getFecha_nacimiento(), persona.getRfc());
            } catch (PersistenciaException e) {
                JOptionPane.showMessageDialog(null, "Consulta fallida", "Fecha Nombre y RFC", JOptionPane.INFORMATION_MESSAGE);
                return null;
            }
        }

        if (!personas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Consulta Exitosa", "Info", JOptionPane.INFORMATION_MESSAGE);
            return personas;
        } else {
            JOptionPane.showMessageDialog(null, "No se encontro personas", "Info", JOptionPane.INFORMATION_MESSAGE);
            return null;
        }

    }

    @Override
    public List<TramiteDTO> obtenerTramitesPorPersona(Long idpersona) {
        List<TramiteDTO> listTramites = new ArrayList<>();

        try {
            // Obtener la persona por su ID
            Persona personaEntity = personaDAO.obtenerPersonaPorId(idpersona);

            // Consultar los trámites de la persona
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

            logger.log(Level.INFO, "Se generó la lista de trámites para la persona con ID: {0}", idpersona);
            return listTramites;
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error al generar la lista de trámites para la persona con ID: {0}", idpersona);
            return null;
        }
    }

}
