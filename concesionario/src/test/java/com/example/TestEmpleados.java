package com.example;

import java.util.List;

import com.example.modelos.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TestEmpleados {

    private static EntityManager manager;
    private static EntityManagerFactory emf;

    public static void main(String[] args) {

        //Crear el gestor de persistencia
        emf = Persistence.createEntityManagerFactory("Persistencia");
        manager = emf.createEntityManager();

        List<Cliente> clientes = (List<Cliente>) manager.createQuery("FROM Cliente",Cliente.class).getResultList();
        System.out.println("En esta base de datos hay " + clientes.size()+"clientes");
    }
    
}
