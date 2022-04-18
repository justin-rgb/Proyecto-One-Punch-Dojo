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
@Table(name="proveedor")
public class Proveedor implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProveedor;
    
    private String nombreEmpresa;
    private String telefono;
    private String ubicacion;
    private String urlImagen;    

    public Proveedor(){
        
    }

    public Proveedor(String nombreEmpresa, String telefono, String ubicacion, String urlImagen) {
        this.nombreEmpresa = nombreEmpresa;
        this.telefono = telefono;
        this.ubicacion = ubicacion;
        this.urlImagen = urlImagen;
    }
    
    
    
}
