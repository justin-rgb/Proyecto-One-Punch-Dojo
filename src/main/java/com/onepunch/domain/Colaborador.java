package com.onepunch.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name="colaborador")
public class Colaborador implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idColaborador;
    
    private String nombre;
    private String apellidos;
    private String usuario;
    private String pass;    

    public Colaborador(){
        
    }

    public Colaborador(String nombre, String apellidos, String usuario, String pass) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.pass = pass;
    }
    
    
  
    
}
