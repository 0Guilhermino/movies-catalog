package br.com.mv.projmv.controller;

import br.com.mv.projmv.dto.FilmeDto;
import br.com.mv.projmv.entity.Filme;
import br.com.mv.projmv.services.FilmeServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeServiceImpl filmeService;

    @PostMapping
    public ResponseEntity<Filme> salvar(@RequestBody FilmeDto dto) {

        Filme filme = new Filme();
        BeanUtils.copyProperties(dto, filme);
        filme.setDataRegistro(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(filmeService.save(filme));
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




