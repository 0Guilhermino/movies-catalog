package br.com.mv.projmv.controller;

import br.com.mv.projmv.dto.FilmeDto;
import br.com.mv.projmv.entity.Filme;
import br.com.mv.projmv.repository.FilmeRepository;
import br.com.mv.projmv.services.FilmeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeServiceImpl service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<FilmeDto> salvar(@RequestBody FilmeDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarPorId(@PathVariable Long id) {
        Optional<Filme> filme = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(filme.get());
    }

        @GetMapping
        public ResponseEntity<List<Filme>> getAllFIlmes() {
            return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
        }


    }

