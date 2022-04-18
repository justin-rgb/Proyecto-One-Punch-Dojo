package com.onepunch.dao;

import com.onepunch.domain.Cliente;
import com.onepunch.domain.Inventario;
import org.springframework.data.repository.CrudRepository;

public interface InventarioDao extends CrudRepository<Inventario, Long> {
    
}
