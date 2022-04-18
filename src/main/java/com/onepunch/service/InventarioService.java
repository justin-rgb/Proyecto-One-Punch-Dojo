package com.onepunch.service;

import com.onepunch.domain.Inventario;
import java.util.List;

public interface InventarioService {
    
    public List<Inventario> getInventario();
    public void save(Inventario inventario);
    public void delete(Inventario inventario);
    public Inventario getItemInventario(Inventario inventario);
    
}