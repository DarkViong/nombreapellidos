package com.example;

import java.util.List;

import com.example.Controller.señorController;
import com.example.modelos.Cliente;
import com.example.modelos.Coche;
import com.example.modelos.Concesionario;
import com.example.repositorios.Cliente.JPAClientesRepository;
import com.example.repositorios.Coche.JPAcocheRepositorio;
import com.example.repositorios.Concesionario.JPAconcesionarioRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;



public class Main {

 private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");


    public static void main(String[] args) {
        
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();

        var controller = new señorController(

                new JPAcocheRepositorio(),
                new JPAClientesRepository(),
                new JPAconcesionarioRepository() 
        );
        
        //Clientes
        Cliente c1 = new Cliente(200001L, "Alexis" ,"601288123");
        Cliente c2 = new Cliente(200002L, "Victoria" ,"60146456");
        Cliente c3 = new Cliente(200003L, "Axel" ,"601454544");

        manager.persist(c1);
        manager.persist(c2);
        manager.persist(c3);

        //Concesionarios
        Concesionario con1 = new Concesionario(1,"audi", "Calle de margo robbie", "601746362");
        Concesionario con2 =new Concesionario(2,"BMW", "Calle de tsitsipas", "60174612");
        Concesionario con3 =new Concesionario(3,"Volkswagen", "Calle de djokovic", "601741232");
        manager.persist(con1);
        manager.persist(con2);
        manager.persist(con3);

        //Coches
        Coche cc1 = new Coche(1,"Audi", "TT", 2017, "rojo", 17000, c1,con1);
        Coche cc2 = new Coche(2,"Audi", "A3", 2020, "Azul", 20000, c2,con2);
        Coche cc3 = new Coche(3,"Audi", "A4", 2010, "Verde", 15000, c3,con3);
        Coche cc4 = new Coche(4,"ferrari", "loki", 2021, "Naranja", 150000, c2,con1);
        manager.persist(cc1);
        manager.persist(cc2);
        manager.persist(cc3);
        manager.persist(cc4);
       
        manager.getTransaction().commit();
        
        
        List<Coche> coches = controller.getCoches();
        System.out.println(coches.toString());
        
        List<Concesionario> concesionarios = controller.getConcesionarios();
        System.out.println(concesionarios.toString());

        List<Cliente> clientes = controller.getClientes();
        System.out.println(clientes.toString());

        Coche cochesito = controller.getCocheById(2);

        System.out.println(cochesito.toString());

        Coche cocheInsert = new Coche(5,"Audi", "A6", 2018, "verde", 19000, c2,con1);
        
        controller.createCoche(cocheInsert);
        
        System.out.println(cocheInsert.toString());

        cocheInsert.setAño(2020);
        cocheInsert.setColor("turquesa");
        controller.updateCoche(cocheInsert);
        
        System.out.println(cocheInsert.toString());

        boolean eliminado = controller.deleteCoche(cocheInsert);

        System.out.println("EL coche ha sido eliminado: "+ eliminado);

        manager.close();

    }


}