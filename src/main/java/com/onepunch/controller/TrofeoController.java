
package com.onepunch.controller;

import com.onepunch.domain.Trofeo;
import com.onepunch.service.TrofeoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class TrofeoController {
    
    @Autowired
    private TrofeoService trofeoService;
    
    @GetMapping("/trofeos")
    public String inicio(Model model) {
        var trofeos = trofeoService.getTrofeos();
        model.addAttribute("trofeos", trofeos);
        return "/trofeos/lista";
    }
 
    @GetMapping("/trofeos/nuevo")
    public String nuevoTrofeo(Trofeo trofeo){
        return "/trofeos/modificar";
    }
    
    @PostMapping("/trofeos/guardar")
    public String guardarTrofeo(Trofeo trofeo){
        trofeoService.save(trofeo);
        return "redirect:/trofeos";
    }
    
    
    @GetMapping("/trofeos/modificar/{idTrofeo}")
    public String modificarCliente(Trofeo trofeo, Model model){
        trofeo = trofeoService.getTrofeo(trofeo);
        model.addAttribute("trofeo",trofeo);
        return "/trofeos/modificar";
    }
    
    @GetMapping("/trofeo/eliminar/{idTrofeo}")
    public String eliminarTrofeo(Trofeo trofeo){
        trofeoService.delete(trofeo);
        return "redirect:/trofeos";
    }
}
