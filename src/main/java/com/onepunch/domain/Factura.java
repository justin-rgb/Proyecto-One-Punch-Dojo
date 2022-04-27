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
@Table(name="factura")
public class Factura implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFactura;
    
    private String nombre;
    private String apellidos;
    private int montoTotal;
    private String cedula;
    private String Fecha;

    public Factura(){
        
    }

    public Factura(String nombre, String apellidos, int montoTotal, String cedula, String Fecha) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.montoTotal = montoTotal;
        this.cedula = cedula;
        this.Fecha = Fecha;
    }

    
    
}
