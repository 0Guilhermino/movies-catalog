package br.com.mv.projmv.dto;

import br.com.mv.projmv.entity.Filme;
import lombok.Data;
import lombok.NoArgsConstructor;


public class FilmeDto {

    private String titulo;
    private int ano;
    private String duracao;

    public FilmeDto(Filme filme) {
        this.titulo = filme.getTitulo();
        this.ano = filme.getAno();
        this.duracao = filme.getDuracao();
    }
    
    public FilmeDto() {

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
    
    
    
}
