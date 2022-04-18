package com.onepunch.service;

import com.onepunch.dao.ProveedorDao;
import com.onepunch.domain.Proveedor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProveedorServiceImpl implements ProveedorService {
    
    @Autowired
    private ProveedorDao proveedorDao;

    @Override
    public List<Proveedor> getProveedores() {
        return (List<Proveedor>) proveedorDao.findAll();
    }

    @Override
    public void save(Proveedor proveedor) {
        proveedorDao.save(proveedor);
    }

    @Override
    public void delete(Proveedor proveedor) {
        proveedorDao.delete(proveedor);
    }

    @Override
    public Proveedor getProveedor(Proveedor proveedor) {
        return proveedorDao.findById(proveedor.getIdProveedor()).orElse(null);
    }
    
    
}
