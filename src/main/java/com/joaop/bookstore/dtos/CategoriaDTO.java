package com.joaop.bookstore.dtos;

import com.joaop.bookstore.domain.Categoria;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Setter
public class CategoriaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Campo NOME requerido")
    @Length(min = 3, max = 100, message = "O campo NOME deve ter entro 3 e 100 caracteres")
    private String nome;

    @NotEmpty(message = "Campo DESCRIÇÃO requerido")
    @Length(min = 3, max = 200, message = "O campo DESCRIÇÃO deve ter entro 3 e 200 caracteres")
    private String descricao;

    public CategoriaDTO() {
        super();
    }

    public CategoriaDTO(Categoria obj) {
        super();
        this.id = obj.getId();
        this.nome =obj.getNome() ;
        this.descricao = obj.getDescricao();
    }

}
