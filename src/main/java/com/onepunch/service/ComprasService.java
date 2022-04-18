package com.onepunch.service;

import com.onepunch.domain.Compras;
import java.util.List;

public interface ComprasService {
    
    public List<Compras> getCompras();
    public void save(Compras compras);
    public void delete(Compras compras);
    public Compras getCompra(Compras compras);
    
}
