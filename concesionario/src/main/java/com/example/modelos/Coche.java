package com.example.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="coche")
public class Coche {
    
    @Id
    @Column(name = "ID")
    private int id;
    @Column(name="MARCA")
    String marca;
    @Column(name = "MODELO")
    String modelo;
    @Column(name = "AÑO")
    int año;
    @Column(name = "COLOR")
    String color;
    @Column(name = "PRECIO")
    float precio;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente dueño;

    @ManyToOne
    @JoinColumn(name = "concesionario_id")
    private Concesionario concesionario;
    
    public Coche(int id,String marca,String modelo,int año, String color, float precio,Cliente dueño,Concesionario consesionario){
        this.id=id;
        this.marca = marca;
        this.modelo = modelo;
        this.año =año;
        this.color = color;
        this.precio = precio;
        this.dueño = dueño;
        this.concesionario=consesionario;
    }
    public Coche(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    public Concesionario getConcesionario() {
        return concesionario;
    }
    public void setConcesionario(Concesionario concesionario) {
        this.concesionario = concesionario;
    }
    public Cliente getDueño() {
        return dueño;
    }
    public void setDueño(Cliente dueño) {
        this.dueño = dueño;
    }

    @Override
    public String toString() {
        return "Coche [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", año=" + año + ", color=" + color
                + ", precio=" + precio + ", dueño=" + dueño.getNombre() + ", concesionario=" + concesionario.nombre + "]";
    }

    
}
