package com.onepunch.controller;

import com.onepunch.service.ColaboradorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ColaboradorController {
    
    @Autowired
    private ColaboradorService colaboradorService;
    
    
    @GetMapping("/colaboradores")
    public String inicio(Model model){
        var colaboradores = colaboradorService.getColaboradores();
        model.addAttribute("colaboradores", colaboradores);
        return "/colaboradores";
    }
    
}
