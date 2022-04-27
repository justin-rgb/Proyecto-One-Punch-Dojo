package com.onepunch.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.beans.factory.annotation.Autowired;



@Service
public class FacturaReportService {
    
    private String reportPath;

    public String generateReport() {
        try {
            File file = ResourceUtils.getFile("classpath:ReporteFacturas.jasper");
            reportPath = file.getParent();
            
            // Carga el reporte
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(file);
            
            // Añade paramáteros (pero para este caso no hay)
            Map<String, Object> parameters = new HashMap<>();
            
            //Instanciar la conexión
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/onepunchdojo_bd", "admin123", "admin");
            // Llena el reporte
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, con);
            
            // Exporta a PDF
            JasperExportManager.exportReportToPdfFile(jasperPrint, reportPath + "\\ReporteFacturas.pdf");
            return reportPath + "\\ReporteFacturas.pdf";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
