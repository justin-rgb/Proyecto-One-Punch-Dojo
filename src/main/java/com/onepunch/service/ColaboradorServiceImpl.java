package com.onepunch.service;

import com.onepunch.dao.ColaboradorDao;
import com.onepunch.domain.Colaborador;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColaboradorServiceImpl implements ColaboradorService {
    
    @Autowired
    private ColaboradorDao colaboradorDao;

    @Override
    public List<Colaborador> getColaboradores() {
        return (List<Colaborador>) colaboradorDao.findAll();
    }

    @Override
    public void save(Colaborador colaborador) {
        colaboradorDao.save(colaborador);
    }

    @Override
    public void delete(Colaborador colaborador) {
        colaboradorDao.delete(colaborador);
    }

    @Override
    public Colaborador getColaborador(Colaborador colaborador) {
        return colaboradorDao.findById(colaborador.getIdColaborador()).orElse(null);
    }
    
    
}
