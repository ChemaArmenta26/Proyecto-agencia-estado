/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Calendar;

/**
 *
 * @author PC
 */
public class ReporteDTO {
    private String nombrePersonaSolicitante;
    private Calendar fechaInicio;
    private Calendar fechaFin;
    private String tipoTramite;

    public ReporteDTO() {
    }

    public String getNombrePersonaSolicitante() {
        return nombrePersonaSolicitante;
    }

    public void setNombrePersonaSolicitante(String nombrePersonaSolicitante) {
        this.nombrePersonaSolicitante = nombrePersonaSolicitante;
    }

    public Calendar getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Calendar fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Calendar getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Calendar fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getTipoTramite() {
        return tipoTramite;
    }

    public void setTipoTramite(String tipoTramite) {
        this.tipoTramite = tipoTramite;
    }
     
}
