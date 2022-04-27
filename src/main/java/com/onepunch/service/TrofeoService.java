
package com.onepunch.service;

import com.onepunch.domain.Trofeo;
import java.util.List;

public interface TrofeoService {
    
    public List<Trofeo> getTrofeos();
    public void save(Trofeo trofeo);
    public void delete(Trofeo trofeo);
    public Trofeo getTrofeo(Trofeo trofeo);
}
