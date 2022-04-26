
package com.onepunch.controller;

import com.onepunch.service.EventoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
@Slf4j    
public class EventoController {
    
    @Autowired
    private EventoService eventoService;
    
    @GetMapping("/eventos")
    public String inicio(Model model){
        var eventos = eventoService.getEventos();
        model.addAttribute("eventos", eventos);
        return "/eventos/lista";
    }
}
