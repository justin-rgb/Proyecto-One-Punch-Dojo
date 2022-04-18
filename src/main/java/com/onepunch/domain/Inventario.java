package com.onepunch.domain;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name="inventario")
public class Inventario implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idItem;
    
    private String descripcion;
    private int cantidad;
    private String urlImagen;
    
    public Inventario(){
        
    }

    public Inventario(String descripcion, int cantidad, String urlImagen) {
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.urlImagen = urlImagen;
    }
    
    
 
}
