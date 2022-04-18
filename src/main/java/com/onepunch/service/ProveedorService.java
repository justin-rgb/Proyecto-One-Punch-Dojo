package com.onepunch.service;

import com.onepunch.domain.Proveedor;
import java.util.List;

public interface ProveedorService {
    
    public List<Proveedor> getProveedores();
    public void save(Proveedor proveedor);
    public void delete(Proveedor proveedor);
    public Proveedor getProveedor(Proveedor proveedor);
    
}
