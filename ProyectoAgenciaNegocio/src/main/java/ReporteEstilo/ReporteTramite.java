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
        // Cargar el diseño del reporte desde el archivo jrxml
        JasperDesign jasperDesign = JRXmlLoader.load(ReporteTramite.class.getResourceAsStream(reportPath));

        // Compilar el reporte
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

        return jasperReport;
    }
}
