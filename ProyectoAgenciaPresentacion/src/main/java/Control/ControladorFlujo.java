/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import GUI.ConfirmarTraPlacas;
import GUI.ConsultarLP;
import GUI.ConsultarLiYPla;
import GUI.OpcionPlacas;
import GUI.Principal;
import GUI.ReporteLicYPla;
import GUI.SolicitarLicPlacas;
import GUI.TramitarLicencia;
import GUI.TramitarPlacaNuevo;
import GUI.TramitarPlacaUsado;
import GUI.TramiteFinalizado;

/**
 *
 * @author PC
 */
public class ControladorFlujo {

    public void mostrarVentanaPrincipal() {
        Principal p = new Principal();
        p.setVisible(true);
    }

    public void mostrarTramitarLicencia() {
        TramitarLicencia t = new TramitarLicencia();
        t.setVisible(true);
    }


    public void mostrarTramiteFinalizado() {
        TramiteFinalizado t = new TramiteFinalizado();
        t.setVisible(true);
    }

    public void mostrarConfirmarTramitePlacas() {
        ConfirmarTraPlacas c = new ConfirmarTraPlacas();
        c.setVisible(true);
    }

    public void mostrarConsultarLicenciaYPlacas() {
        ConsultarLiYPla c = new ConsultarLiYPla();
        c.setVisible(true);
    }

    public void mostrarConsultarTramites() {
        ConsultarLP c = new ConsultarLP();
        c.setVisible(true);
    }

    public void mostrarOpcionPlacas() {
        OpcionPlacas o = new OpcionPlacas();
        o.setVisible(true);
    }

    public void mostrarReporteLicenciaYPlacas() {
        ReporteLicYPla r = new ReporteLicYPla();
        r.setVisible(true);
    }
    
     public void mostrarSolicitarPlacas() {
        SolicitarLicPlacas s = new SolicitarLicPlacas();
        s.setVisible(true);
    }


    public void mostrarTramitePlacaNueva() {
        TramitarPlacaNuevo t = new TramitarPlacaNuevo();
        t.setVisible(true);
    }

    public void mostrarTramitePlacaUsada() {
        TramitarPlacaUsado t = new TramitarPlacaUsado();
        t.setVisible(true);
    }
}
