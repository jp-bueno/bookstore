package com.joaop.bookstore.services;

import com.joaop.bookstore.domain.Livro;
import com.joaop.bookstore.repository.LivroRepository;
import com.joaop.bookstore.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private CategoriaServices categoriaServices;

    //FindById
    public Livro findById(Integer id){
        Optional<Livro> obj = livroRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo" + Livro.class.getName()));
    // Ele irá buscar o livro pelo seu id através do repository e retorná-lo, se caso não achar deverá retornar a mensagem no ElseThrow
    }

    public List<Livro> findAll(Integer id_cat) {
        categoriaServices.findById(id_cat);
        return livroRepository.findAllByCategoria(id_cat);
    }

    public Livro update(Integer id, Livro obj) {
        Livro newObj = findById(id);
        updateData(newObj, obj);
        return livroRepository.save(newObj);
    }

    private void updateData(Livro newObj, Livro obj) {
        newObj.setTitulo(obj.getTitulo());
        newObj.setNome_autor(obj.getNome_autor());
        newObj.setTexto(obj.getTexto());
    }
}
