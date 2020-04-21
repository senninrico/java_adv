package br.biblioteca.livros.dto;

import br.biblioteca.livros.model.Autor;

import javax.persistence.*;
import java.io.Serializable;

public class LivroDTO {

        private Long id;

        private String nome;


        private int quantidadePaginas;


        private String autor;

        public Long getId() {
            return id;
        }

        public void setId(final Long id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(final String nome) {
            this.nome = nome;
        }

        public int getQuantidadePaginas() {
            return quantidadePaginas;
        }

        public void setQuantidadePaginas(final int quantidadePaginas) {
            this.quantidadePaginas = quantidadePaginas;
        }

        public String getAutor() {
            return autor;
        }

        public void setAutor(final String autor) {
            this.autor = autor;
        }


    }


