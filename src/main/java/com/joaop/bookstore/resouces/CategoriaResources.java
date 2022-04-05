package com.joaop.bookstore.resouces;

import com.joaop.bookstore.domain.Categoria;
import com.joaop.bookstore.services.CategoriaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
