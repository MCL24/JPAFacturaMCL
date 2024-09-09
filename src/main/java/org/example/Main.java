package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        System.out.println("Se creó el Entity Manger y seguimos...");

        try {
            entityManager.getTransaction().begin();

            Categoria perecedero = new Categoria("Perecederos");
            Categoria lacteos = new Categoria("Lacteos");
            Categoria limpieza = new Categoria("Limpieza");
            Categoria bebidas = new Categoria("Bebidas");
            Categoria panaderia = new Categoria("Panadería");

            Articulo leche = new Articulo(3,"leche 1",1000);
            Articulo detergente = new Articulo(4,"Detergente",500);
            Articulo carne = new Articulo(5,"Carne",7000);
            Articulo pan = new Articulo(6,"Pan",1500);
            Articulo yogurt = new Articulo(7,"Yogurt",900);

            leche.getCategorias().add(perecedero);
            leche.getCategorias().add(lacteos);

            lacteos.getArticulos().add(leche);
            perecedero.getArticulos().add(leche);
            detergente.getCategorias().add(limpieza);
            limpieza.getArticulos().add(detergente);

//            Factura fac1 = new Factura("27/08/2024", 40);
//
//            Cliente cliente = new Cliente("Alberto", "Cortez", 34);
//            Domicilio domicilio = new Domicilio("suipacha",239);
//
//            cliente.setDomicilio(domicilio);
//
//            fac1.setCliente(cliente);
//
//            DetalleFactura linea1 = new DetalleFactura();
//
//            linea1.setArticulo(leche);
//            linea1.setCantidad(4);
//            linea1.setSubtotal(450);
//
//            fac1.getFacturas().add(linea1);
//
//            DetalleFactura linea2 = new DetalleFactura();
//
//            linea2.setArticulo(detergente);
//            linea2.setCantidad(1);
//            linea2.setSubtotal(50);
//
//            fac1.getFacturas().add(linea2);
//
//            entityManager.persist(fac1);
//
//            entityManager.flush();
//
//            entityManager.getTransaction().commit();

            //---------------------------------------------------------------------------
            // Persistir una nueva entidad Person
            //entityManager.getTransaction().begin();

            //Persona person = new Persona("Pepe", 25);
            //entityManager.persist(person);
            //entityManager.getTransaction().commit();

            // Consultar y mostrar la entidad persistida
            //Persona retrievedPerson = entityManager.find(Persona.class, person.getId());
            //System.out.println("Retrieved Person: " + retrievedPerson.getName());

        }catch (Exception e){

//        entityManager.getTransaction().rollback();
        System.out.println(e.getMessage());
        System.out.println("No se pudo grabar la clase Factura");}

        // Cerrar el EntityManager y el EntityManagerFactory
        entityManager.close();
        entityManagerFactory.close();
    }
}
