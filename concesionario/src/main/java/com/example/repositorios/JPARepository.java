package com.example.repositorios;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public abstract class JPARepository  {
    protected final EntityManagerFactory entityManagerFactory;
    
    public JPARepository() {
        entityManagerFactory = Persistence.createEntityManagerFactory("Persistencia");
    }
}
