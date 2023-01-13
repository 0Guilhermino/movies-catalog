package br.com.mv.projmv.services;

import br.com.mv.projmv.dto.CategoriaDto;
import br.com.mv.projmv.dto.FilmeDto;
import br.com.mv.projmv.entity.Categoria;
import br.com.mv.projmv.entity.Filme;
import br.com.mv.projmv.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl {

    @Autowired
    CategoriaRepository categoriaRepository;

    public CategoriaDto save(CategoriaDto categoriaDto) {
        return categoriaRepository.save(categoriaDto);
    }




    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> findById(Long id) {
        return categoriaRepository.findById(id);
    }

    public void delete(Categoria categoria) {
        categoriaRepository.delete(categoria);
    }
}
