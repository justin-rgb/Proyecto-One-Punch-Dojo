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
@Table(name="cliente")
public class Cliente implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCliente;
    
    private String nombre;
    private String apellidos;
    private String cedula;
    private String direccion;
    private String numTelefono;
    private String categoria;

    public Cliente(){
        
    }

    public Cliente(String nombre, String apellidos, String cedula, String direccion, String numTelefono, String categoria) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.direccion = direccion;
        this.numTelefono = numTelefono;
        this.categoria = categoria;
    }
    
    
    
}
