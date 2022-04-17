package com.joaop.bookstore.dtos;

import com.joaop.bookstore.domain.Livro;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class LivroDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String titulo;

    public LivroDTO(Livro obj) {
        super();
        this.id = obj.getId();
        this.titulo = obj.getTitulo();
    }
}
