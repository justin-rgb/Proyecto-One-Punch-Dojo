
package com.onepunch.service;

import com.onepunch.dao.TrofeoDao;
import com.onepunch.domain.Trofeo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrofeoServiceImpl implements TrofeoService {
    
    @Autowired
    private TrofeoDao trofeoDao;

    @Override
    public List<Trofeo> getTrofeos() {
        return (List<Trofeo>) trofeoDao.findAll();
    }

    @Override
    public void save(Trofeo trofeo) {
        trofeoDao.save(trofeo);
    }

    @Override
    public void delete(Trofeo trofeo) {
        trofeoDao.delete(trofeo);
    }

    @Override
    public Trofeo getTrofeo(Trofeo trofeo) {
        return trofeoDao.findById(trofeo.getIdTrofeo()).orElse(null);
    }    
}
