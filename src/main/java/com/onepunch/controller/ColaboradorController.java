package com.onepunch.controller;

import com.onepunch.domain.Cliente;
import com.onepunch.domain.Colaborador;
import com.onepunch.service.ColaboradorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ColaboradorController {
    
    @Autowired
    private ColaboradorService colaboradorService;
    
    
    @GetMapping("/colaboradores")
    public String inicio(Model model){
        var colaboradores = colaboradorService.getColaboradores();
        model.addAttribute("colaboradores", colaboradores);
        return "/colaboradores/lista";
    }
    
    @GetMapping("/colaboradores/nuevo")
    public String nuevoCliente(Colaborador colaborador) {
        return "/colaboradores/modificar";
    }

    @PostMapping("/colaboradores/guardar")
    public String guardarCliente(Colaborador colaborador) {
        String primeraLetra = colaborador.getNombre().toUpperCase();
        String apellidos = colaborador.getApellidos().toUpperCase();
        
        String usuario = primeraLetra.charAt(0)+apellidos.replace(" ", "_");
        
        colaborador.setUsuario(usuario);
        colaboradorService.save(colaborador);
        return "redirect:/colaboradores";
    }

    @GetMapping("/colaboradores/modificar/{idColaborador}")
    public String modificarCliente(Colaborador colaborador, Model model) {
        colaborador = colaboradorService.getColaborador(colaborador);
        model.addAttribute("colaborador", colaborador);
        return "/colaboradores/modificar";
    }

    @GetMapping("/colaboradores/eliminar/{idColaborador}")
    public String eliminarCliente(Colaborador colaborador) {
        colaboradorService.delete(colaborador);
        return "redirect:/colaboradores";
    }

    
}
