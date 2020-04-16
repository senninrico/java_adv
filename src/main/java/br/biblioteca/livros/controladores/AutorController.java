package br.biblioteca.livros.controladores;

import br.biblioteca.livros.model.Autor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

@Controller
@RequestMapping("/autores")
public class AutorController {

	@GetMapping("/list")
	public ModelAndView autores() {
		ModelAndView modelAndView = new ModelAndView("autores/list");
		modelAndView.addObject("autores", Arrays.asList(new Autor()));
		return modelAndView;
	}

	@GetMapping("/novo")
	public ModelAndView createForm() {
		ModelAndView modelAndView = new ModelAndView("autores/form");
		return modelAndView;
	}

	@PostMapping(value = "/gravar")
	public ModelAndView create() {
		return new ModelAndView("redirect:/autores/list");
	}

	@GetMapping("/alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("autores/form");
		return modelAndView;
	}

	@GetMapping("/excluir/{id}")
	public ModelAndView excluir(@PathVariable("id") Long id) {
		return new ModelAndView("redirect:/autores/list");
	}

}
