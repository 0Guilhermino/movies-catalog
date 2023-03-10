package br.com.mv.projmv.dto;

import br.com.mv.projmv.entity.Categoria;

public class CategoriaDto {

    private Long id;
    private String categoria;

    public CategoriaDto() {

    }

    public CategoriaDto(Categoria categoria) {

    }

    public CategoriaDto(Long id, String categoria) {
        this.id = id;
        this.categoria = categoria;
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
}
