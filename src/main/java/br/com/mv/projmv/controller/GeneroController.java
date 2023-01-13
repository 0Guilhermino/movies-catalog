package br.com.mv.projmv.controller;

import br.com.mv.projmv.dto.CategoriaDto;
import br.com.mv.projmv.dto.FilmeDto;
import br.com.mv.projmv.entity.Categoria;
import br.com.mv.projmv.entity.Filme;
import br.com.mv.projmv.services.CategoriaServiceImpl;
import br.com.mv.projmv.services.FilmeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/filmes")
public class GeneroController {

    @Autowired
    private CategoriaServiceImpl categoriaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoriaDto saveFilm(@RequestBody CategoriaDto dto) {
        return categoriaService.save(dto);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> findFilmById(@PathVariable Long id) {
        Optional<Filme> filme = filmeService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(filme.get());
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<FilmeDto> getAllFilms(@PageableDefault(page = 0, size = 10,sort = "id")Pageable pageable){
        return filmeService.findAll(pageable);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteFilm(@PathVariable Long id){
        Optional<Filme> optionalFilme = filmeService.findById(id);
        if(!optionalFilme.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ops, filme não encontrado!");
        }
        filmeService.delete(optionalFilme.get());
        return ResponseEntity.status(HttpStatus.OK).body("Filme deletado com sucesso!");
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public FilmeDto updateFilm(@PathVariable Long id, @RequestBody FilmeDto filmeDto){
        filmeDto = filmeService.update(id, filmeDto);
        return filmeDto;
    }


}




