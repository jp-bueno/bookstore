package com.joaop.bookstore.repository;

import com.joaop.bookstore.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Spring DATA JPA facilita para criarmos tabelas (para não usar o SQL)
@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {
}
