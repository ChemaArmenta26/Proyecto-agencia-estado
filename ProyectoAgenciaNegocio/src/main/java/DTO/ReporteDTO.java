/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Calendar;

/**
 *  Clase que implementa la lógica de negocio para ReporteDTO
 */
public class ReporteDTO {
    private String nombrePersonaSolicitante;
    private Calendar fechaInicio;
    private Calendar fechaFin;
    private String tipoTramite;

    /**
     * Constructor por defecto de la clase ReporteDTO.
     */
    public ReporteDTO() {
    }

    /**
     * Obtiene el nombre de la persona solicitante del reporte.
     * @return El nombre de la persona solicitante.
     */
    public String getNombrePersonaSolicitante() {
        return nombrePersonaSolicitante;
    }

    /**
     * Establece el nombre de la persona solicitante del reporte.
     * @param nombrePersonaSolicitante El nombre de la persona solicitante a establecer.
     */
    public void setNombrePersonaSolicitante(String nombrePersonaSolicitante) {
        this.nombrePersonaSolicitante = nombrePersonaSolicitante;
    }

    /**
     * Obtiene la fecha de inicio del periodo del reporte.
     * @return La fecha de inicio del periodo del reporte.
     */
    public Calendar getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Establece la fecha de inicio del periodo del reporte.
     * @param fechaInicio La fecha de inicio del periodo del reporte a establecer.
     */
    public void setFechaInicio(Calendar fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Obtiene la fecha de fin del periodo del reporte.
     * @return La fecha de fin del periodo del reporte.
     */
    public Calendar getFechaFin() {
        return fechaFin;
    }

    /**
     * Establece la fecha de fin del periodo del reporte.
     * @param fechaFin La fecha de fin del periodo del reporte a establecer.
     */
    public void setFechaFin(Calendar fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * Obtiene el tipo de trámite asociado al reporte.
     * @return El tipo de trámite asociado al reporte.
     */
    public String getTipoTramite() {
        return tipoTramite;
    }

    /**
     * Establece el tipo de trámite asociado al reporte.
     * @param tipoTramite El tipo de trámite asociado al reporte a establecer.
     */
    public void setTipoTramite(String tipoTramite) {
        this.tipoTramite = tipoTramite;
    }
     
}
