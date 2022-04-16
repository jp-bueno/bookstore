package com.joaop.bookstore.services;

import com.joaop.bookstore.domain.Livro;
import com.joaop.bookstore.repository.LivroRepository;
import com.joaop.bookstore.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    //FindById
    public Livro findById(Integer id){
        Optional<Livro> obj = livroRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo" + Livro.class.getName()));
    // Ele irá buscar o livro pelo seu id através do repository e retorná-lo, se caso não achar deverá retornar a mensagem no ElseThrow
    }

}
