package com.joaop.bookstore.resouces;

import com.joaop.bookstore.domain.Categoria;
import com.joaop.bookstore.dtos.CategoriaDTO;
import com.joaop.bookstore.services.CategoriaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResources {

    @Autowired
    private CategoriaServices services;

    @GetMapping(value = "/{id}") // localhost:8080/categoria/id
    public ResponseEntity<Categoria> findById(@PathVariable Integer id) {
        Categoria obj = services.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    //AQUI IRÁ RETORNAR TODAS AS CATEGORIAS, MAS SEM SEUS LIVROS
    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> findAll() {
        List<Categoria> list = services.findAll();
        List<CategoriaDTO> listDTO = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
        // transformei uma lista de categioa para uma lista de categoriaDTO

        return ResponseEntity.ok().body(listDTO);
    }

    //CRIA UMA NOVA CATEGORIA E COMO O ID = NULL, NÃO IMMPORTA O ID QUE VOCÊ VAI COLOCAR ELE SEMPRE ESTARÁ CERTO
    @PostMapping
    public ResponseEntity<Categoria> create(@RequestBody Categoria obj) {
        obj = services.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CategoriaDTO> update(@PathVariable Integer id, @RequestBody CategoriaDTO objDto) {
        Categoria newObj = services.update(id, objDto);
        return ResponseEntity.ok().body(new CategoriaDTO(newObj));
    }
}
