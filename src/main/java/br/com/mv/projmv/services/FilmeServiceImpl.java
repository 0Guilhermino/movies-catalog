package br.com.mv.projmv.services;

import br.com.mv.projmv.dto.CategoriaDto;
import br.com.mv.projmv.dto.FilmeDto;
import br.com.mv.projmv.entity.Categoria;
import br.com.mv.projmv.entity.Filme;
import br.com.mv.projmv.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class FilmeServiceImpl {

    @Autowired
    private FilmeRepository repository;

    public Filme save(Filme filme) {
        return repository.save(filme);
    }


    public Page<FilmeDto> findAll(Pageable pageable) {
        Page<Filme> list = repository.findAll(pageable);
        return list.map(x -> new FilmeDto(x));
    }

    public Optional<Filme> findById(Long id) {
        return repository.findById(id);
    }

    public void delete(Filme filme) {
        repository.delete(filme);
    }

    public FilmeDto update(Long id, FilmeDto filmeDto) {
        Optional<Filme> optionalFilme = repository.findById(id);
        Filme filmEntity = optionalFilme.get();
            filmEntity.setTitulo(filmeDto.getTitulo());
            filmEntity.setAno(filmeDto.getAno());
            filmEntity.setDuracao(filmeDto.getDuracao());
            filmEntity.setDataRegistro(LocalDateTime.now());
            repository.save(filmEntity);
            return new FilmeDto((filmEntity));
        }
    }

