package com.onepunch.dao;

import com.onepunch.domain.Cliente;
import com.onepunch.domain.Compras;
import org.springframework.data.repository.CrudRepository;

public interface ComprasDao extends CrudRepository<Compras, Long> {
    
}
