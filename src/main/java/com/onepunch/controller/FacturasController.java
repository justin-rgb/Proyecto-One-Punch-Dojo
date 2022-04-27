package com.onepunch.controller;

import com.onepunch.domain.Factura;
import com.onepunch.service.FacturaReportService;
import com.onepunch.service.FacturaService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class FacturasController {
    
    @Autowired
    private FacturaService facturaService;
    
    @Autowired
    private FacturaReportService facturaReportService;
    
    @GetMapping("/facturas")
    public String inicio(Model model) {
        var facturas = facturaService.getFacturas();
        model.addAttribute("facturas", facturas);
        return "/facturas/lista";
    }
    
    @GetMapping("/facturas/nuevo")
    public String nuevoFactura(Factura factura) {
        return "/facturas/modificar";
    }

    @PostMapping("/facturas/guardar")
    public String guardarFactura(Factura factura) {
        facturaService.save(factura);
        return "redirect:/facturas";
    }

    @GetMapping("/facturas/modificar/{idFactura}")
    public String modificarFactura(Factura factura, Model model) {
        factura = facturaService.getFactura(factura);
        model.addAttribute("factura", factura);
        return "/facturas/modificar";
    }

    @GetMapping("/facturas/eliminar/{idFactura}")
    public String eliminarFactura(Factura factura) {
        facturaService.delete(factura);
        return "redirect:/facturas";
    }
    
    
    @GetMapping(value = "/facturas/ReporteFacturas", produces = MediaType.APPLICATION_PDF_VALUE)
    public @ResponseBody
    byte[] getFile() throws IOException {
        try {
            FileInputStream fis = new FileInputStream(new File(facturaReportService.generateReport()));
            byte[] targetArray = new byte[fis.available()];
            fis.read(targetArray);
            return targetArray;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
}
