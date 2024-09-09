package org.example;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
@Builder

@Entity
public class Articulo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private int cantidad;
    private String denominacion;
    private int precio;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "articulo_categoria",
            joinColumns = @JoinColumn(name = "articulo_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )

    @Builder.Default
    private Set<Categoria> categorias = new HashSet<>();

    //public Set<Categoria> getCategorias() {return categorias;}

    //public void setCategorias(Set<Categoria> categorias) {this.categorias = categorias;}

    // Constructor personalizado que acepta int, String, int
    public Articulo(int cantidad, String denominacion, int precio) {
        this.cantidad = cantidad;
        this.denominacion = denominacion;
        this.precio = precio;

    }
}
