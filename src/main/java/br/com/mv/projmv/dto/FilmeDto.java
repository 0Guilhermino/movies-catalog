package br.com.mv.projmv.dto;

import br.com.mv.projmv.entity.Filme;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FilmeDto {

    private String titulo;
    private int ano;
    private String duracao;

    public FilmeDto(Filme filme) {
        this.titulo = filme.getTitulo();
        this.ano = filme.getAno();
        this.duracao = filme.getDuracao();
    }
}
