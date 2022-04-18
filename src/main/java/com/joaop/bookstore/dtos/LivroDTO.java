package com.joaop.bookstore.dtos;

import com.joaop.bookstore.domain.Livro;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class LivroDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Campo TITULO requerido")
    @Length(min = 3, max = 50, message = "O campo TITULO deve ter entro 3 e 50 caracteres")
    private String titulo;

    @NotEmpty(message = "Campo TEXTO requerido")
    @Length(min = 3, max = 2000000, message = "O campo TEXTO deve ter entro 3 e 2.000.000 caracteres")
    private String texto;

    @NotEmpty(message = "Campo NOME DO AUTOR requerido")
    @Length(min = 3, max = 50, message = "O campo NOME DO AUTOR deve ter entro 3 e 50 caracteres")
    private String nome_autor;

    public LivroDTO(Livro obj) {
        super();
        this.id = obj.getId();
        this.titulo = obj.getTitulo();
    }
}
