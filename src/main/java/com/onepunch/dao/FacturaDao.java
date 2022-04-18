package com.onepunch.dao;

import com.onepunch.domain.Cliente;
import com.onepunch.domain.Factura;
import org.springframework.data.repository.CrudRepository;

public interface FacturaDao extends CrudRepository<Factura, Long> {
    
}
