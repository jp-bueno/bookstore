package com.joaop.bookstore.dtos;

import com.joaop.bookstore.domain.Categoria;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CategoriaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
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
