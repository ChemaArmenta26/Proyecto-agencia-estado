/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BOs;

import DTO.PersonaDTO;
import DTO.ReporteDTO;
import DTO.ReporteDeTramiteDTO;
import DTO.TramiteDTO;
import Entidades.Persona;
import java.util.List;

/**
 *  Clase que implementa la lógica de negocio para IReporteTramiteBO
 */
public interface IReporteTramiteBO {

    /**
     * Obtiene una lista de trámites basada en el filtro proporcionado.
     * @param filtro El objeto ReporteDTO que contiene los criterios de filtro para la consulta.
     * @return Una lista de objetos TramiteDTO que representan los trámites que cumplen con el filtro.
     */
    public List<TramiteDTO> obtenerTramites(ReporteDTO filtro);

    /**
     * Obtiene una lista de trámites formateada para su presentación en un reporte.
     * @param filtro El objeto ReporteDTO que contiene los criterios de filtro para la consulta.
     * @return Una lista de objetos ReporteDeTramiteDTO que representan los trámites formateados para el reporte.
     */
    public List<ReporteDeTramiteDTO> obtenerTramitesReporte(ReporteDTO filtro);

    /**
     * Verifica si un trámite cumple con los criterios de filtro especificados.
     * @param tramite El objeto TramiteDTO que representa el trámite a verificar.
     * @param filtro El objeto ReporteDTO que contiene los criterios de filtro a aplicar.
     * @return true si el trámite cumple con los criterios de filtro, false en caso contrario.
     */
    public boolean cumpleFiltro(TramiteDTO tramite, ReporteDTO filtro);

    /**
     * Obtiene una lista de trámites asociados a una persona identificada por su ID.
     * @param idpersona El ID de la persona cuyos trámites se desean obtener.
     * @return Una lista de objetos TramiteDTO que representan los trámites asociados a la persona.
     */
    public List<TramiteDTO> obtenerTramitesPorPersona(Long idpersona);

    /**
     * Genera un reporte en formato PDF basado en la lista de trámites proporcionada.
     * @param listaTramites La lista de trámites para incluir en el reporte.
     */
    public void generarReporte(List<ReporteDeTramiteDTO> listaTramites);

    /**
     * Obtiene una lista de personas basada en los criterios de filtro proporcionados.
     * @param persona El objeto PersonaDTO que contiene los criterios de filtro para la consulta de personas.
     * @return Una lista de objetos Persona que representan las personas que cumplen con los criterios de filtro.
     */
    public List<Persona> obtenerListaDePersonas(PersonaDTO persona);
}
