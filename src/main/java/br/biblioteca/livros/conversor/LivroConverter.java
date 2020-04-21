package br.biblioteca.livros.conversor;

import br.biblioteca.livros.dto.LivroDTO;
import br.biblioteca.livros.model.Livro;

import java.util.List;
import java.util.stream.Collectors;

public class LivroConverter {

    public static LivroDTO toDTO(Livro livro){
        LivroDTO livroDTO = new LivroDTO();
        livroDTO.setId(livro.getId());
        livroDTO.setNome(livro.getNome());
        livroDTO.setQuantidadePaginas(livro.getQuantidadePaginas());
        livroDTO.setAutor( livro.getAutor() != null ? livro.getAutor().getNome() : null);


        return livroDTO;
    }

    public static List<LivroDTO> toDTO(List<Livro> livros) {
        return
                livros.stream
                        ().map(l -> toDTO(l)).collect(Collectors.toList());
    }
}
