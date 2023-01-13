package br.com.mv.projmv.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_categoria")
public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String categoria;
        @ManyToOne
        private Filme filme;

    public Categoria() {

    }

    public Categoria(Long id, String categoria, Filme filme) {
        this.id = id;
        this.categoria = categoria;
        this.filme = filme;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }
}
