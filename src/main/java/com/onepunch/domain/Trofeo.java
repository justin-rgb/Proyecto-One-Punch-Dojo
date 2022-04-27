
package com.onepunch.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="trofeo")
public class Trofeo implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTrofeo;
    
    private String descripcion;
    private int puesto;
    private String nombreCompeticion;
    private String fecha;
    
    public Trofeo(){
        
    }

    public Trofeo(String descripcion, int puesto, String nombreCompeticion, String fecha){
        this.descripcion = descripcion;
        this.puesto = puesto;
        this.nombreCompeticion = nombreCompeticion;
        this.fecha = fecha;
    }
}
