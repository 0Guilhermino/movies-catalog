package br.com.mv.projmv.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Table(name = "tb_filme")
public class Filme implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private int ano;
    private String duracao;
    private LocalDateTime dataRegistro;
    
    
    public Filme() {
		
	}
    
    public Filme(Long id, String titulo, int ano, String duracao, LocalDateTime dataRegistro) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.ano = ano;
		this.duracao = duracao;
		this.dataRegistro = dataRegistro;
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
    
    



}
