package com.example.modelos;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table( name ="concesionario")
public class Concesionario {
    
    @Id
    @Column(name= "ID")
    private int id;
    @Column(name= "NOMBRE")
    String nombre;
    @Column(name= "DIRECCION")
    String direccion;
    @Column(name= "TELEFONO")
    String telefono;

    @OneToMany(mappedBy = "concesionario")
    private List<Coche> cochesEnVenta;

    @ManyToMany
    @JoinTable(
        name = "coche",
        joinColumns = @JoinColumn(name = "concesionario_id"),
        inverseJoinColumns = @JoinColumn(name = "cliente_id")
    )
    private List<Cliente> clientesQueCompraron;


    public Concesionario(){
        
    }
    public Concesionario(int id,String nombre, String direccion, String telefono){
        this.id=id;
        this.nombre=nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getDireccion() {
        return direccion;
    }


    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    public String getTelefono() {
        return telefono;
    }


    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public List<Cliente> getClientesQueCompraron() {
        return clientesQueCompraron;
    }
    public void setClientesQueCompraron(List<Cliente> clientesQueCompraron) {
        this.clientesQueCompraron = clientesQueCompraron;
    }
    public List<Coche> getCochesEnVenta() {
        return cochesEnVenta;
    }
    public void setCochesEnVenta(List<Coche> cochesEnVenta) {
        this.cochesEnVenta = cochesEnVenta;
    }


    @Override
    public String toString() {
        return "Concesionario [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono
                + ", cochesEnVenta=" + cochesEnVenta.size() + ", clientesQueCompraron=" + clientesQueCompraron.size() + "]";
    }
    
}
