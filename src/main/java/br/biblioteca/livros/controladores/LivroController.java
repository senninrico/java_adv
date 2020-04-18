package br.biblioteca.livros.controladores;

import java.util.Arrays;
import java.util.List;

import br.biblioteca.livros.model.Livro;
import br.biblioteca.livros.model.Autor;

import br.biblioteca.livros.services.AutorService;
import br.biblioteca.livros.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	LivroService livroService;

	@Autowired
	AutorService autorService;

	@GetMapping("/list")
	public ModelAndView livros() {		
		ModelAndView modelAndView = new ModelAndView("livros/list");

		List<Livro> listaLivros = livroService.listaTodosLivros();

		modelAndView.addObject("livros", listaLivros);
		return modelAndView;
	}

	@GetMapping("/novo")
	public ModelAndView createForm(@ModelAttribute Livro livro) {
		ModelAndView modelAndView = new ModelAndView("livros/form");
		List<Autor> listaAutores = autorService.listaAutores();
		modelAndView.addObject("listaAutores", listaAutores);
		return modelAndView;
	}

	@PostMapping(value = "/gravar")
	public ModelAndView create(Livro livro) {
		livroService.salvarLivro( livro);

		return new ModelAndView("redirect:/livros/list");
	}

	@GetMapping("/alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") Long id) {
		Livro livro = livroService.buscaLivro(id);
		List<Autor> listaAutores = autorService.listaAutores();

		ModelAndView modelAndView = new ModelAndView("livros/form");
		modelAndView.addObject("listaAutores", listaAutores);
		modelAndView.addObject("livro", livro);
		return modelAndView;
	}

	@GetMapping("/excluir/{id}")
	public ModelAndView excluir(@PathVariable("id") Long id) {
		return new ModelAndView("redirect:/livros/list");
	}

}
