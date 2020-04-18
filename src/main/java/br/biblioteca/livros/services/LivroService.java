package br.biblioteca.livros.services;

import br.biblioteca.livros.model.Livro;
import br.biblioteca.livros.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    LivroRepository livroRepository;


    public List<Livro> listaTodosLivros(){
        return livroRepository.listaLivros();
    }

    public void salvarLivro(Livro livro) {
        livroRepository.save(livro);
    }

    public Livro buscaLivro(Long id){
        return livroRepository.findById(id).orElseThrow(() -> new RuntimeException());

    }
}

