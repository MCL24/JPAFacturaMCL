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
public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String denominacion;

    // Constructor personalizado que acepta solo un argumento de tipo String
    public Categoria(String denominacion) { this.denominacion = denominacion;}

    @ManyToMany(mappedBy = "categorias")
    @Builder.Default
    private Set<Articulo> articulos = new HashSet<>();

    public Set<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(Set<Articulo> articulos) {
        this.articulos = articulos;
    }

}
