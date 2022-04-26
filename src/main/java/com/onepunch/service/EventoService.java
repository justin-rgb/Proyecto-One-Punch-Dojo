
package com.onepunch.service;

import com.onepunch.domain.Evento;
import java.util.List;

public interface EventoService {
    
    public List<Evento> getEventos();
    public void save(Evento evento);
    public void delete(Evento evento);
    public Evento getEvento(Evento evento);
}
