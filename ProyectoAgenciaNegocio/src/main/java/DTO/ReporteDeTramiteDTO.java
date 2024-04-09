/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;

/**
 *  Clase que implementa la lógica de negocio para ReporteDeTramiteDTO
 */
public class ReporteDeTramiteDTO {
    private Date fecha;
    private String tipo;
    private String nombre;
    private Float costo;

    /**
     * Constructor que permite crear un objeto DTO de trámite simplificado para reportes.
     *
     * @param fecha Fecha del trámite.
     * @param tipo Tipo de trámite.
     * @param nombre Nombre del contribuyente asociado al trámite.
     * @param costo Costo del trámite.
     */
    public ReporteDeTramiteDTO(Date fecha, String tipo, String nombre, Float costo) {
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
     * Obtiene el nombre del solicitante del trámite.
     *
     * @return Nombre del solicitante del trámite.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el costo del trámite.
     *
     * @return Costo del trámite.
     */
    public Float getCosto() {
        return costo;
    }

    /**
     * Establece la fecha del trámite.
     * @param fecha Fecha del trámite a establecer.
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Establece el tipo de trámite.
     * @param tipo Tipo de trámite a establecer.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Establece el nombre del solicitante del trámite.
     * @param nombre Nombre del solicitante del trámite a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece el costo del trámite.
     * @param costo Costo del trámite a establecer.
     */
    public void setCosto(Float costo) {
        this.costo = costo;
    }

    /** 
     * Retorna una representación de cadena de este objeto.
     * @return Una cadena que representa este objeto.
     */
    @Override
    public String toString() {
        return "ReporteDeTramiteDTO{" + "fecha=" + fecha + ", tipo=" + tipo + ", nombre=" + nombre + ", costo=" + costo + '}';
    }
    
}
