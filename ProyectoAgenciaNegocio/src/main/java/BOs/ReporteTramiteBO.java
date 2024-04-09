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
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
                        tm.getCosto());

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
        Document doc = new Document();

        try {
            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("ReporteDeTramites.pdf"));
            writer.setPageEvent(new PageNumberEvent());

            Font tituloFont = new Font(Font.FontFamily.TIMES_ROMAN, 24, Font.BOLD);
            Paragraph titulo = new Paragraph("Reporte de Trámites", tituloFont);
            titulo.setAlignment(Element.ALIGN_CENTER);

            Date fechaActual = new Date();
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
            Paragraph fecha = new Paragraph("Fecha del Reporte: " + formatoFecha.format(fechaActual));
            fecha.setAlignment(Element.ALIGN_LEFT);

            PdfPTable tabla = new PdfPTable(4);
            tabla.addCell(createCell("Fecha del Trámite", true));
            tabla.addCell(createCell("Costo", true));
            tabla.addCell(createCell("Nombre del solicitante", true));
            tabla.addCell(createCell("Tipo de Trámite", true));

            for (ReporteDeTramiteDTO tramite : listaTramites) {
                String fechaExpedicionFormateada = (tramite.getFecha() != null) ? formatoFecha.format(tramite.getFecha().getTime()) : "NoDate";
                tabla.addCell(createCell(fechaExpedicionFormateada, false));
                tabla.addCell(createCell(Double.toString(tramite.getCosto()), false));
                tabla.addCell(createCell(tramite.getNombre(), false));
                tabla.addCell(createCell(tramite.getTipo(), false));
            }

            doc.open();
            doc.add(titulo);
            doc.add(fecha);
            doc.add(Chunk.NEWLINE);
            doc.add(tabla);
            doc.close();

            JOptionPane.showMessageDialog(null, "El PDF ha sido exportado con exito!  Nombre del Archivo: ReporteDeTramites.pdf", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al generar el reporte de trámites.");
        }
    }

    private PdfPCell createCell(String content, boolean header) {
        PdfPCell cell = new PdfPCell(new Phrase(content));
        if (header) {
            cell.setBackgroundColor(new BaseColor(252, 121, 93));
        } else {
            cell.setBackgroundColor(new BaseColor(246, 236, 162));
        }
        return cell;
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

    private static class PageNumberEvent extends PdfPageEventHelper {

        @Override
        public void onEndPage(PdfWriter writer, Document document) {
            PdfContentByte cb = writer.getDirectContent();
            Phrase footer = new Phrase("Página " + writer.getPageNumber(), new Font(Font.FontFamily.HELVETICA, 12));
            ColumnText.showTextAligned(cb, Element.ALIGN_CENTER,
                    footer,
                    document.right() - 50,
                    document.bottom() - 10, 0);
        }
    }
}
