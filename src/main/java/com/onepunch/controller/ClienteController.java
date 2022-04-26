package com.onepunch.controller;

import com.onepunch.domain.Cliente;
import com.onepunch.service.ClienteService;
import com.onepunch.service.ColaboradorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;
    
    @GetMapping("/clientes")
    public String inicio(Model model) {
        var clientes = clienteService.getClientes();
        model.addAttribute("clientes", clientes);
        return "/clientes/lista";
    }
 
    @GetMapping("/clientes/nuevo")
    public String nuevoCliente(Cliente cliente){
        return "/clientes/modificar";
    }
    
    @PostMapping("/clientes/guardar")
    public String guardarCliente(Cliente cliente){
        clienteService.save(cliente);
        return "redirect:/clientes";
    }
    
    
    @GetMapping("/clientes/modificar/{idCliente}")
    public String modificarCliente(Cliente cliente, Model model){
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente",cliente);
        return "/clientes/modificar";
    }
    
    @GetMapping("/clientes/eliminar/{idCliente}")
    public String eliminarCliente(Cliente cliente){
        clienteService.delete(cliente);
        return "redirect:/clientes";
    }

    
    
}
