package com.joaop.bookstore.service;

import com.joaop.bookstore.domain.Categoria;
import com.joaop.bookstore.domain.Livro;
import com.joaop.bookstore.repository.CategoriaRepository;
import com.joaop.bookstore.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
// CLASSE QUE IRÁ FICAR COM O SALVAMENTO DA NOSSA BASE DE DADOS
@Service
public class DBService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private LivroRepository livroRepository;

    public void instanciaBaseDeDados() {
        Categoria cat1 = new Categoria(null, "Informatica", "livros de TI");
        Categoria cat2 = new Categoria(null, "Ficcção Científica", "Ficção Cientifica");

        Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Loren Ipsun", cat1);
        Livro l2 = new Livro(null, "Engenharia de Software", "Louis V. Gerstner", "Loren ipsun",cat2);
        Livro l3 = new Livro(null, "The Time Machine", "M. G. Wells", "Loren ipsun", cat2);
        Livro l4 = new Livro(null, "The War", "M. G. Wills", "Loren ipsun", cat2);
        Livro l5 = new Livro(null, "I, Robot", "Isaac Asimov", "Loren ipsun", cat2);

        // Categoria conheceu os livros e os livros conheceram a categoria
        cat1.getLivros().addAll(Arrays.asList(l1, l2));
        cat2.getLivros().addAll(Arrays.asList(l3, l4, l5));


        // Salvar dados no banco de dados
        categoriaRepository.saveAll(Arrays.asList(cat1));
        livroRepository.saveAll(Arrays.asList(l1));
    }
}
