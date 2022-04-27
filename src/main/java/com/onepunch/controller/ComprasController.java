
package com.onepunch.controller;

import com.onepunch.domain.Compras;
import com.onepunch.service.ComprasService;
import com.onepunch.service.EventoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
@Slf4j    
public class ComprasController {
    
    @Autowired
    private ComprasService comprasService;
    
    @GetMapping("/compras")
    public String inicio(Model model){
        var compras = comprasService.getCompras();
        model.addAttribute("compras", compras);
        return "/compras/lista";
    }
    
    @GetMapping("/compras/nuevo")
    public String nuevoCompras(Compras compras) {
        return "/comprases/modificar";
    }

    @PostMapping("/compras/guardar")
    public String guardarCompras(Compras compras) {
        comprasService.save(compras);
        return "redirect:/compras";
    }

    @GetMapping("/compras/modificar/{idCompra}")
    public String modificarCompras(Compras compras, Model model) {
        compras = comprasService.getCompra(compras);
        model.addAttribute("compras", compras);
        return "/compras/modificar";
    }

    @GetMapping("/compras/eliminar/{idCompra}")
    public String eliminarCompras(Compras compras) {
        comprasService.delete(compras);
        return "redirect:/compras";
    }
    
}
