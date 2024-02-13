package com.example.Controller;

import java.util.logging.Logger;
import java.util.List;

import com.example.modelos.Cliente;
import com.example.modelos.Coche;
import com.example.modelos.Concesionario;
import com.example.repositorios.Cliente.JPAClientesRepository;
import com.example.repositorios.Coche.JPAcocheRepositorio;
import com.example.repositorios.Concesionario.JPAconcesionarioRepository;

public class señorController {

    private final Logger logger = Logger.getLogger(señorController.class.getName());

    // Mis dependencias
    private final JPAcocheRepositorio cocheRepository;
    private final JPAClientesRepository clienteRepository;
    private final JPAconcesionarioRepository concesionarioRepository;


    public señorController(JPAcocheRepositorio cocheRepository, JPAClientesRepository clienteRepository,JPAconcesionarioRepository concesionarioRepository) {
        this.cocheRepository = cocheRepository;
        this.clienteRepository = clienteRepository;
        this.concesionarioRepository = concesionarioRepository;
    }

    // Coches
    public List<Coche> getCoches() {
        logger.info("Obteniendo coche");
        return cocheRepository.getAll();
    }

    public Coche createCoche(Coche coche) {
        logger.info("Creando coche");
        return cocheRepository.insert(coche);
    }

    public Coche getCocheById(int id) {
        logger.info("Obteniendo coche con id: " + id);
        return cocheRepository.getById(id);
    }

    public Coche updateCoche(Coche coche) {
        logger.info("Actualizando coche con id: " + coche.getId());
        return cocheRepository.update(coche);
    }

    public Boolean deleteCoche(Coche coche) {
        logger.info("Eliminando coche con id: " + coche.getId());
        return cocheRepository.delete(coche);
    }

    // Clientes
    public List<Cliente> getClientes() {
        logger.info("Obteniendo Cliente");
        return clienteRepository.getAll();
    }

    public Cliente createCliente(Cliente cliente) {
        logger.info("Creando Cliente");
        return clienteRepository.insert(cliente);
    }

    public Cliente getClienteById(int id) {
        logger.info("Obteniendo Cliente con id: " + id);
        return clienteRepository.getById(id);
    }

    public Cliente updateCliente(Cliente cliente) {
        logger.info("Actualizando Cliente con id: " + cliente.getDNI());
        return clienteRepository.update(cliente);
    }

    public Boolean deleteCliente(Cliente cliente) {
        logger.info("Eliminando Cliente con id: " + cliente.getDNI());
        return clienteRepository.delete(cliente);
    }
    //Concesionarios

    public List<Concesionario> getConcesionarios() {
        logger.info("Obteniendo concesionarios");
        return concesionarioRepository.getAll();
    }

    public Concesionario createConcesionario(Concesionario concesionario) {
        logger.info("Creando concesionario");
        return concesionarioRepository.insert(concesionario);
    }

    public Concesionario getConcesionarioById(int id) {
        logger.info("Obteniendo concesionario con id: " + id);
        return concesionarioRepository.getById(id);
    }

    public Concesionario updateRaqueta(Concesionario concesionario) {
        logger.info("Actualizando concesionario con id: " + concesionario.getId());
        return concesionarioRepository.update(concesionario);
    }

    public Boolean deleteRaqueta(Concesionario concesionario) {
        logger.info("Eliminando concesionario con id: " + concesionario.getId());
        return concesionarioRepository.delete(concesionario);
    }

}

