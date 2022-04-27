
package com.onepunch.controller;

import com.onepunch.domain.Proveedor;
import com.onepunch.service.ProveedorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
@Slf4j    
public class ProveedorController {
    
    @Autowired
    private ProveedorService proveedorService;
    
    @GetMapping("/proveedores")
    public String inicio(Model model){
        var proveedor = proveedorService.getProveedores();
        model.addAttribute("proveedor", proveedor);
        return "/proveedores/lista";
    }
    
    @GetMapping("/proveedores/nuevo")
    public String nuevoProveedor(Proveedor proveedor) {
        return "/proveedores/modificar";
    }

    @PostMapping("/proveedores/guardar")
    public String guardarProveedor(Proveedor proveedor) {
        proveedorService.save(proveedor);
        return "redirect:/proveedores";
    }

    @GetMapping("/proveedores/modificar/{idProveedor}")
    public String modificarProveedor(Proveedor proveedor, Model model) {
        proveedor = proveedorService.getProveedor(proveedor);
        model.addAttribute("proveedor", proveedor);
        return "/proveedores/modificar";
    }

    @GetMapping("/proveedores/eliminar/{idProveedor}")
    public String eliminarProveedor(Proveedor proveedor) {
        proveedorService.delete(proveedor);
        return "redirect:/proveedores";
    }
    
}
