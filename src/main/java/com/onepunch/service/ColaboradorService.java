package com.onepunch.service;

import com.onepunch.domain.Colaborador;
import java.util.List;

public interface ColaboradorService {
    
    public List<Colaborador> getColaboradores();
    public void save(Colaborador colaborador);
    public void delete(Colaborador colaborador);
    public Colaborador getColaborador(Colaborador colaborador);
    
}
