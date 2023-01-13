package br.com.mv.projmv.entity;

import br.com.mv.projmv.dto.CategoriaDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "tb_film")
public class Filme implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private int ano;
    private String duracao;
    private LocalDateTime dataRegistro;

	@OneToMany
	@JoinTable(name = "film_categoria", joinColumns = @JoinColumn(name = "filme_id"),
			inverseJoinColumns = @JoinColumn(name = "categoria_id"))
	private List<Categoria> categoria;
    
    public Filme() {
		
	}
    
    public Filme(Long id, String titulo, int ano, String duracao, LocalDateTime dataRegistro, List<Categoria> categoria) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.ano = ano;
		this.duracao = duracao;
		this.dataRegistro = dataRegistro;
		this.categoria = categoria;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getDuracao() {
		return duracao;
	}
	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}
	public LocalDateTime getDataRegistro() {
		return dataRegistro;
	}
	public void setDataRegistro(LocalDateTime dataRegistro) {
		this.dataRegistro = dataRegistro;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Categoria> getCategoria() {
		return categoria;
	}

	public void setCategoria(List<Categoria> categoria) {
		this.categoria = categoria;
	}
}
