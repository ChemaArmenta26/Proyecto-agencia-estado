/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BOs;

import DTO.PersonaDTO;
import DTO.ReporteDTO;
import DTO.TramiteDTO;
import Entidades.Persona;
import java.util.List;

/**
 *
 * @author PC
 */
public interface IReporteTramiteBO {
    
    public List<TramiteDTO> obtenerTramites(ReporteDTO filtro);
    
    
    public boolean cumpleFiltro(TramiteDTO tramite, ReporteDTO filtro);
    
    public List<TramiteDTO> obtenerTramitesPorPersona(Long idpersona);
    
     public void generarReporte(List<TramiteDTO> listaTramites);
     
     public List<Persona> obtenerListaDePersonas(PersonaDTO persona);     
}
