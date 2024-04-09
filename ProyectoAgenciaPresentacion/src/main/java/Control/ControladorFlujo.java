/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import GUI.ConfirmarTraPlacas;
import GUI.ConsultarLP;
import GUI.Principal;
import GUI.ReporteLicYPla;
import GUI.SolcitarPlacas;
import GUI.TramitarLicencia;
import GUI.TramitarPlacaNuevo;
import GUI.TramitarPlacaUsado2;
import GUI.TramiteFinalizado;

/**
 * Esta clase ControladorFlujo contiene métodos para controlar el flujo de la
 * aplicación.
 */
public class ControladorFlujo {

    /**
     * Constructor por defecto
     */
    public ControladorFlujo() {
    }

    /**
     * Muestra la ventana principal de la aplicación.
     *
     * @param insercion Indica si se debe habilitar la opción de inserción de
     * datos en la ventana principal.
     */
    public void mostrarVentanaPrincipal(boolean insercion) {
        Principal p = new Principal(insercion);
        p.setVisible(true);
    }

    /**
     * Muestra la ventana para solicitar placas.
     */
    public void mostrarSolicitarPlacas() {
        SolcitarPlacas s = new SolcitarPlacas();
        s.setVisible(true);
    }

    /**
     * Muestra la ventana para tramitar una nueva licencia.
     */
    public void mostrarTramitarLicencia() {
        TramitarLicencia t = new TramitarLicencia();
        t.setVisible(true);
    }

    /**
     * Muestra la ventana que indica que un trámite ha sido finalizado.
     */
    public void mostrarTramiteFinalizado() {
        TramiteFinalizado t = new TramiteFinalizado();
        t.setVisible(true);
    }

    /**
     * Muestra la ventana para consultar licencias y placas.
     */
    public void mostrarConsultarLicenciaYPlacas() {
        ConsultarLP c = new ConsultarLP();
        c.setVisible(true);
    }

    /**
     * Muestra la ventana para consultar trámites.
     */
    public void mostrarConsultarTramites() {
        ConsultarLP c = new ConsultarLP();
        c.setVisible(true);
    }

    /**
     * Muestra el reporte de licencias y placas.
     */
    public void mostrarReporteLicenciaYPlacas() {
        ReporteLicYPla r = new ReporteLicYPla();
        r.setVisible(true);
    }

    /**
     * Muestra la ventana para tramitar una nueva placa.
     */
    public void mostrarTramitePlacaNueva() {
        TramitarPlacaNuevo t = new TramitarPlacaNuevo();
        t.setVisible(true);
    }

    /**
     * Muestra la ventana para tramitar una placa usada.
     */
    public void mostrarTramitePlacaUsada() {
        TramitarPlacaUsado2 t = new TramitarPlacaUsado2();
        t.setVisible(true);
    }
}
