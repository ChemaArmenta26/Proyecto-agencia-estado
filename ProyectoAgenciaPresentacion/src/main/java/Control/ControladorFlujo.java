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
 *
 * @author PC
 */
public class ControladorFlujo {

    public void mostrarVentanaPrincipal(boolean insercion) {
        Principal p = new Principal(insercion);
        p.setVisible(true);
    }
    public void mostrarSolicitarPlacas(){
        SolcitarPlacas s = new SolcitarPlacas();
        s.setVisible(true);
    }

    public void mostrarTramitarLicencia() {
        TramitarLicencia t = new TramitarLicencia();
        t.setVisible(true);
    }


    public void mostrarTramiteFinalizado() {
        TramiteFinalizado t = new TramiteFinalizado();
        t.setVisible(true);
    }

    

    public void mostrarConsultarLicenciaYPlacas() {
        ConsultarLP c = new ConsultarLP();
        c.setVisible(true);
    }

    public void mostrarConsultarTramites() {
        ConsultarLP c = new ConsultarLP();
        c.setVisible(true);
    }

    public void mostrarReporteLicenciaYPlacas() {
        ReporteLicYPla r = new ReporteLicYPla();
        r.setVisible(true);
    }
    
     


    public void mostrarTramitePlacaNueva() {
        TramitarPlacaNuevo t = new TramitarPlacaNuevo();
        t.setVisible(true);
    }

    public void mostrarTramitePlacaUsada() {
        TramitarPlacaUsado2 t = new TramitarPlacaUsado2();
        t.setVisible(true);
    }
}
