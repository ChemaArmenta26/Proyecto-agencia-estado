/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ReporteEstilo;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

public class ReporteTramite {

    public static JasperReport getCompiledReport(String reportPath) throws Exception {
        JasperDesign jasperDesign = null;
        try {
            jasperDesign = JRXmlLoader.load(ReporteTramite.class.getResourceAsStream(reportPath));
        } catch (Exception e) {
            e.printStackTrace(); // O imprime el mensaje de la excepción
        }

        if (jasperDesign != null) {
            // Compilar el reporte si jasperDesign no es nulo
            return JasperCompileManager.compileReport(jasperDesign);
        } else {
            throw new Exception("No se pudo cargar el diseño del reporte.");
        }
    }

}
