package com.onepunch.controller;

import com.onepunch.domain.Inventario;
import com.onepunch.service.FacturaService;
import com.onepunch.service.InventarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class InventarioController {
    
    @Autowired
    private InventarioService inventarioService;
    
    @GetMapping("/inventario")
    public String inicio(Model model) {
        var inventario = inventarioService.getInventario();
        model.addAttribute("inventario", inventario);
        return "/inventario/lista";
    }
    
    @GetMapping("/inventario/nuevo")
    public String nuevoInventario(Inventario inventario) {
        return "/inventarios/modificar";
    }

    @PostMapping("/inventario/guardar")
    public String guardarInventario(Inventario inventario) {
        inventarioService.save(inventario);
        return "redirect:/inventario";
    }

    @GetMapping("/inventario/modificar/{idItem}")
    public String modificarInventario(Inventario inventario, Model model) {
        inventario = inventarioService.getItemInventario(inventario);
        model.addAttribute("inventario", inventario);
        return "/inventarios/modificar";
    }

    @GetMapping("/inventario/eliminar/{idItem}")
    public String eliminarInventario(Inventario inventario) {
        inventarioService.delete(inventario);
        return "redirect:/inventario";
    }

    
}
