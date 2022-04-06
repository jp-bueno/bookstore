package com.joaop.bookstore.services;

import com.joaop.bookstore.domain.Categoria;
import com.joaop.bookstore.repository.CategoriaRepository;
import com.joaop.bookstore.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaServices {

    @Autowired
    private CategoriaRepository repository;

    public Categoria findById(Integer id){
        Optional<Categoria> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!: Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }
}
