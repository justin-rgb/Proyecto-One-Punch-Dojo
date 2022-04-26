package com.onepunch.service;

import com.onepunch.dao.EventoDao;
import com.onepunch.domain.Evento;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoServiceImpl implements EventoService{
    
    @Autowired
    private EventoDao eventoDao;
    
    @Override
    public List<Evento> getEventos(){
        return (List<Evento>) eventoDao.findAll();
    }
    
    @Override
    public void save(Evento evento) {
        eventoDao.save(evento);
    }

    @Override
    public void delete(Evento evento) {
        eventoDao.delete(evento);
    }

    @Override
    public Evento getEvento(Evento evento) {
        return eventoDao.findById(evento.getIdEvento()).orElse(null);
    }
}
