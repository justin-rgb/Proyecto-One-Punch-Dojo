package com.onepunch.controller;

import com.onepunch.service.FacturaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class FacturasController {
    
    @Autowired
    private FacturaService facturaService;
    
    @GetMapping("/facturas")
    public String inicio(Model model) {
        var facturas = facturaService.getFacturas();
        model.addAttribute("facturas", facturas);
        return "/facturas/lista";
    }
    
}
