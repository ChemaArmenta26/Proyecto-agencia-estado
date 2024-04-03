/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import Conexion.ConexionBD;
import DAOs.ITramiteDAO;
import DAOs.TramiteDAO;
import DTO.LicenciaDTO;
import DTO.PlacaDTO;
import DTO.ReporteDTO;
import DTO.TramiteDTO;
import Entidades.Licencia;
import Entidades.Placa;
import Entidades.Tramite;
import Persistencia.PersistenciaException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class ReporteTramiteBO implements IReporteTramiteBO {

    ConexionBD conexionBD = new ConexionBD();
    private ITramiteDAO tramiteDAO = new TramiteDAO(conexionBD);
    private static final Logger logger = Logger.getLogger(ReporteTramiteBO.class.getName());
    

    @Override
    public List<TramiteDTO> obtenerTramites(ReporteDTO filtro) {
        List<TramiteDTO> listTramites = new ArrayList<>();

        try {
            List<Tramite> tramitesBase = this.tramiteDAO.consultarTodosTramites();

            for (Tramite tm : tramitesBase) {
                TramiteDTO tramiteDTO = null;

                if (tm instanceof Licencia) {
                    Licencia licencia = (Licencia) tm;
                    tramiteDTO = new LicenciaDTO(
                            licencia.getDuracionAños(),
                            licencia.getVigenciaF(),
                            licencia.getFecha(),
                            licencia.getCosto(),
                            licencia.isEstado()
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

        // Aquí puedes agregar más condiciones para filtrar según tus necesidades

        // Si pasa todos los filtros, devuelve true
        return true;
    }
    }

