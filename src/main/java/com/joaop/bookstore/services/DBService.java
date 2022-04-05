package com.joaop.bookstore.services;

import com.joaop.bookstore.domain.Categoria;
import com.joaop.bookstore.domain.Livro;
import com.joaop.bookstore.repository.CategoriaRepository;
import com.joaop.bookstore.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private LivroRepository livroRepository;

    public void instanciaBaseDeDados() {
        Categoria cat1 = new Categoria(null, "Informática", "Livros de informatica");
        Categoria cat2 = new Categoria(null, "Ficção Científica", "Ficção Científica");
        Categoria cat3 = new Categoria(null, "Biografias", "Livros de Biografias");

        Livro l1 = new Livro(null, "Clean Code", "Rober Martin", "Loren Ipsum", cat1);
        Livro l2 = new Livro(null, "Engenharia de Software", "Rober Martin", "Loren Ipsum", cat1);
        Livro l3 = new Livro(null, "The Time Machine", "M. G. Wills", "Loren Ipsum", cat2);
        Livro l4 = new Livro(null, "The War of the Worlds", "M. G. Wills", "Loren Ipsum", cat2);
        Livro l5 = new Livro(null, "I, Robot", "Isaac Asiew", "Loren Ipsum", cat2);

        cat1.getLivros().addAll(Arrays.asList(l1,l2));
        cat2.getLivros().addAll(Arrays.asList(l3,l4,l5));

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));

    }
}
