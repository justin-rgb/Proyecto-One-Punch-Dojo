
package com.onepunch.controller;

import com.onepunch.domain.Evento;
import com.onepunch.service.EventoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



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

    @GetMapping("/eventos/nuevo")
    public String nuevoEvento(Evento evento) {
        return "/eventos/modificar";
    }

    @PostMapping("/eventos/guardar")
    public String guardarEvento(Evento evento) {
        eventoService.save(evento);
        return "redirect:/eventos";
    }

    @GetMapping("/eventos/modificar/{idEvento}")
    public String modificarEvento(Evento evento, Model model) {
        evento = eventoService.getEvento(evento);
        model.addAttribute("evento", evento);
        return "/eventos/modificar";
    }

    @GetMapping("/eventos/eliminar/{idEvento}")
    public String eliminarEvento(Evento evento) {
        eventoService.delete(evento);
        return "redirect:/eventos";
    }
    
    
    
    
}
