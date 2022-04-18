package com.onepunch.dao;

import com.onepunch.domain.Cliente;
import com.onepunch.domain.Factura;
import com.onepunch.domain.Proveedor;
import org.springframework.data.repository.CrudRepository;

public interface ProveedorDao extends CrudRepository<Proveedor, Long> {
    
}
