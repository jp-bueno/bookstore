package com.joaop.bookstore.services;

import com.joaop.bookstore.domain.Categoria;
import com.joaop.bookstore.dtos.CategoriaDTO;
import com.joaop.bookstore.repository.CategoriaRepository;
import com.joaop.bookstore.services.exceptions.DataIntegrityViolationException;
import com.joaop.bookstore.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServices {

    @Autowired
    private CategoriaRepository repository;

    public Categoria findById(Integer id){
        Optional<Categoria> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!: Id: " + id + ", Tipo: " + Categoria.class.getName()));

    }

    // retornar uma lista de categorias.
    public List<Categoria> findAll( ){
        return repository.findAll();
    }

    // Criar uma categoria nova
    public Categoria create(Categoria obj) {
        obj.setId(null);
        return repository.save(obj);
    }

    //Put
    public Categoria update(Integer id, CategoriaDTO objDto) {
        Categoria obj = findById(id);
        obj.setNome(obj.getNome());
        obj.setDescricao(obj.getDescricao());
        return repository.save(obj);

    }

    public void delete(Integer id) {
        findById(id);
//        repository.deleteById(id);
        try {
            repository.deleteById(id);
        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Categoria não pode ser deleteda, possui livros associados");
        }
    }
}
