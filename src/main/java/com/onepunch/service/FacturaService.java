package com.onepunch.service;

import com.onepunch.domain.Factura;
import java.util.List;

public interface FacturaService {
    
    public List<Factura> getFacturas();
    public void save(Factura factura);
    public void delete(Factura factura);
    public Factura getFactura(Factura factura);
    
}
