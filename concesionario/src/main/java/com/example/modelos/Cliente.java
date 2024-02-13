package com.example.modelos;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @Column(name = "DNI")
    private Long DNI;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "TELEFONO")
    private String telefono;

    @OneToMany(mappedBy = "dueño")
    private List<Coche> cochesComprados;
    
    public Cliente(){

    }
    public Cliente(Long dni, String nombre, String telefono){
        this.DNI=dni;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Long getDNI() {
        return DNI;
    }

    public void setDNI(Long dNI) {
        DNI = dNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Coche> getCochesComprados() {
        return cochesComprados;
    }

    public void setCochesComprados(List<Coche> cochesComprados) {
        this.cochesComprados = cochesComprados;
    }
    @Override
    public String toString() {
        return "Cliente [DNI=" + DNI + ", nombre=" + nombre + ", telefono=" + telefono + ", cochesComprados="
                + cochesComprados + "]";
    }
    
    
}
 