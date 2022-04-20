package com.onepunch.controller;

import com.onepunch.service.FacturaService;
import com.onepunch.service.InventarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class InventarioController {
    
    @Autowired
    private InventarioService inventarioService;
    
    @GetMapping("/logistica/inventario")
    public String inicio(Model model) {
        var inventario = inventarioService.getInventario();
        model.addAttribute("inventario", inventario);
        return "/inventario/lsista";
    }
    
}
