/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;

/**
 *
 * @author PC
 */
public class ReporteDeTramiteDTO {
    private Date fecha;
    private String tipo;
    private String nombre;
    private String costo;

    /**
     * Constructor que permite crear un objeto DTO de trámite simplificado para reportes.
     *
     * @param fecha Fecha del trámite.
     * @param tipo Tipo de trámite.
     * @param nombre Nombre del contribuyente asociado al trámite.
     * @param costo Costo del trámite.
     */
    public ReporteDeTramiteDTO(Date fecha, String tipo, String nombre, String costo) {
        this.fecha = fecha;
        this.tipo = tipo;
        this.nombre = nombre;
        this.costo = costo;
    }

    /**
     * Obtiene la fecha del trámite.
     *
     * @return Fecha del trámite.
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Obtiene el tipo de trámite.
     *
     * @return Tipo de trámite.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Obtiene el nombre del contribuyente asociado al trámite.
     *
     * @return Nombre del contribuyente asociado al trámite.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el costo del trámite.
     *
     * @return Costo del trámite.
     */
    public String getCosto() {
        return costo;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }
    
}
