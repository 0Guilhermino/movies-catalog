package br.com.mv.projmv.services;

import br.com.mv.projmv.dto.FilmeDto;
import br.com.mv.projmv.entity.Filme;
import br.com.mv.projmv.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class FilmeServiceImpl {

    @Autowired
    private FilmeRepository repository;

    public FilmeDto save(FilmeDto dto) {
        Filme entity = new Filme();
        entity.setTitulo(dto.getTitulo());
        entity.setAno(dto.getAno());
        entity.setDuracao(dto.getDuracao());
        entity.setDataRegistro(LocalDateTime.now());
        repository.save(entity);
        return dto;
    }

    public List<Filme> findAll() {
        return repository.findAll();
    }

    public Optional<Filme> findById(Long id) {
        return repository.findById(id);
    }
}
