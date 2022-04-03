package com.joaop.bookstore;

import com.joaop.bookstore.domain.Categoria;
import com.joaop.bookstore.domain.Livro;
import com.joaop.bookstore.repository.CategoriaRepository;
import com.joaop.bookstore.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
//ComandLineRunner toda vez que você starta a implementação ela executa o que está no método
public class BookstoreApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informatica", "livros de TI");

		Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Loren Ipsun", cat1);

		// Categoria conheceu os livros e os livros conheceram a categoria
		cat1.getLivros().addAll(Arrays.asList(l1));

		// Salvar dados no banco de dados
		this.categoriaRepository.saveAll(Arrays.asList(cat1));
		this.livroRepository.saveAll(Arrays.asList(l1));
	}
}
