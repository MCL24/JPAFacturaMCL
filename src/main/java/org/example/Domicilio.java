package org.example;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Domicilio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Iid;

    private String nombreCalle;
    private int numero;
}
