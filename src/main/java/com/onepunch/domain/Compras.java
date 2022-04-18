package com.onepunch.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name="compras")
public class Compras implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCompra;
    
    private double monto;
    private String detalle;
    private String proveedor;
    private Date fecha;
    private String urlImagen;    

    public Compras(){
        
    }

    public Compras(double monto, String detalle, String proveedor, Date fecha, String urlImagen) {
        this.monto = monto;
        this.detalle = detalle;
        this.proveedor = proveedor;
        this.fecha = fecha;
        this.urlImagen = urlImagen;
    }
    
    
    
}
