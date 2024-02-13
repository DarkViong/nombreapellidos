package com.example.repositorios;

import java.util.List;


public interface CRUDRepository<T, ID> {

    List <T> getAll();

    T getById(int id);

    T insert(T entity);

    T update(T entity);

    Boolean delete(T entity);
    
}
