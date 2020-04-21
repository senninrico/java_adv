package br.biblioteca.livros.api;

import br.biblioteca.livros.dto.LivroDTO;
import br.biblioteca.livros.model.Livro;
import br.biblioteca.livros.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static br.biblioteca.livros.conversor.LivroConverter.toDTO;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    LivroService livroService;

    @GetMapping("/livros/list")
    public ResponseEntity<List<LivroDTO>> livros() {
        List<Livro> listaLivros = livroService.listaTodosLivros();
        return ResponseEntity.ok(toDTO(listaLivros));
    }
}
