package br.com.mv.projmv.controller;

import br.com.mv.projmv.dto.CategoriaDto;
import br.com.mv.projmv.entity.Categoria;
import br.com.mv.projmv.services.CategoriaServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaServiceImpl categoriaService;

    @PostMapping
    public ResponseEntity<Categoria> salvarCategoria(@RequestBody CategoriaDto categoriaDto) {
        Categoria categoria = new Categoria();
        BeanUtils.copyProperties(categoriaDto, categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.save(categoria));
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> getAllCategoria() {
        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarCategoriaPorId(@PathVariable Long id) {
        Optional<Categoria> categoriaOptional = categoriaService.findById(id);
        if (!categoriaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Gênero não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(categoriaOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarCategoria(@PathVariable Long id) {
        Optional<Categoria> categoriaOptional = categoriaService.findById(id);
        if (!categoriaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não informada!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(categoriaOptional.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarCategoria(@PathVariable Long id,@RequestBody CategoriaDto categoriaDto) {
        Optional<Categoria> categoriaOptional = categoriaService.findById(id);
        if (!categoriaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não encontrado.");
        }
        Categoria categoria = new Categoria();
        BeanUtils.copyProperties(categoriaDto, categoria);
        categoria.setId(categoriaOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.save(categoria));
    }


}




