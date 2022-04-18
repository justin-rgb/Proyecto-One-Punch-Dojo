package com.onepunch.service;

import com.onepunch.dao.ComprasDao;
import com.onepunch.domain.Compras;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComprasServiceImpl implements ComprasService {
    
    @Autowired
    private ComprasDao comprasDao;

    @Override
    public List<Compras> getCompras() {
        return (List<Compras>) comprasDao.findAll();
    }

    @Override
    public void save(Compras compras) {
        comprasDao.save(compras);
    }

    @Override
    public void delete(Compras compras) {
        comprasDao.delete(compras);
    }

    @Override
    public Compras getCompra(Compras compras) {
        return comprasDao.findById(compras.getIdCompra()).orElse(null);
    }
    
    
}
