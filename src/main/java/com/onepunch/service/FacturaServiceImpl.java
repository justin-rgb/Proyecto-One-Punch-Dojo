package com.onepunch.service;

import com.onepunch.dao.FacturaDao;
import com.onepunch.domain.Factura;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaServiceImpl implements FacturaService {
    
    @Autowired
    private FacturaDao facturaDao;

    @Override
    public List<Factura> getFacturas() {
        return (List<Factura>) facturaDao.findAll();
    }

    @Override
    public void save(Factura factura) {
        facturaDao.save(factura);
    }

    @Override
    public void delete(Factura factura) {
        facturaDao.delete(factura);
    }

    @Override
    public Factura getFactura(Factura factura) {
        return facturaDao.findById(factura.getIdFactura()).orElse(null);
    }
    
    
}
