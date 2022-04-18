package com.onepunch.service;

import com.onepunch.dao.InventarioDao;
import com.onepunch.domain.Inventario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventarioServiceImpl implements InventarioService {
    
    @Autowired
    private InventarioDao inventarioDao;

    @Override
    public List<Inventario> getInventario() {
        return (List<Inventario>) inventarioDao.findAll();
    }

    @Override
    public void save(Inventario inventario) {
        inventarioDao.save(inventario);
    }

    @Override
    public void delete(Inventario inventario) {
        inventarioDao.delete(inventario);
    }

    @Override
    public Inventario getItemInventario(Inventario inventario) {
        return inventarioDao.findById(inventario.getIdItem()).orElse(null);
    }
    
    
}
