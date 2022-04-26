
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
@Table(name="evento")
public class Evento implements Serializable {
   
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEvento;
    
    private String descripcion;
    private String fecha;
    private String hora;
    private String instructor;    

    public Evento(){
        
    }

    public Evento(String descripcion, String fecha, String hora, String instructor) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
        this.instructor = instructor;
    }    
}
