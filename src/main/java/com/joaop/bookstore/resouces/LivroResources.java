package com.joaop.bookstore.resouces;


import com.joaop.bookstore.domain.Livro;
import com.joaop.bookstore.dtos.LivroDTO;
import com.joaop.bookstore.services.LivroService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/livros") //endpoint /livros
public class LivroResources {

    @Autowired
    public LivroService livroService;

    @GetMapping("/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Integer id){
        Livro obj = livroService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<LivroDTO>> findAll(@RequestParam(value = "categoria", defaultValue = "0")Integer id_cat){
        List<Livro> list = livroService.findAll(id_cat);
        List<LivroDTO> listDTO = list.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
        //localhost:8008/livros?categoria=1
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Livro> update(@PathVariable Integer id, @RequestBody Livro obj) {
        Livro newObj = livroService.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

    //Atualizar apenas uma informação
    @PatchMapping(value = "/{id}")
    public ResponseEntity<Livro> updatePatch(@PathVariable Integer id, @RequestBody Livro obj) {
        Livro newObj = livroService.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }
}
