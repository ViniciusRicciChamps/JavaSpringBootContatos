package com.listacontatosapp.controlles;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.listacontatosapp.models.Contatos;
import com.listacontatosapp.repository.ContatosRepository;





@Controller
public class ContatoController {

	@Autowired
	private ContatosRepository cr;

	@RequestMapping(value = "/cadastrarContato", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String form() {
		return "Contatos/formContato";
	}
	
	
	//os asteriscos ignora o que vem antes da URL
	@RequestMapping(method = RequestMethod.POST, value = "**/cadastrarContato" )
	@ResponseStatus(HttpStatus.OK)
	public ModelAndView formulario(@Valid Contatos contatos, BindingResult result,
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("Contatos/formContato");
			Iterable<Contatos> iterableContatos = cr.findAll();
			modelAndView.addObject("contatos", iterableContatos);
			modelAndView.addObject("contatosobj", contatos);
			
			List<String> msg = new ArrayList<String>();
			for(ObjectError error : result.getAllErrors()) {
				msg.add(error.getDefaultMessage());
			}
			 modelAndView.addObject("msg", msg);
			return modelAndView;
		}
		cr.save(contatos);
		ModelAndView AndView = new ModelAndView("Contatos/formContato");
		Iterable<Contatos> iterableContatos = cr.findAll();
		AndView.addObject("contatos", iterableContatos);
		return AndView;

	}

	@GetMapping(value = "/")
	@ResponseStatus(HttpStatus.OK)
	public ModelAndView listaContatos() {
		ModelAndView modelAndView = new ModelAndView("index");
		Iterable<Contatos> contato = cr.findAll();
		modelAndView.addObject("contatos", contato);
		return modelAndView;
	}
	
	@GetMapping(value = "**/editarcontato/{idContato}")
	//@RequestMapping(value = "**/editarcontato/{idContato}", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public ModelAndView editarContato(@PathVariable("idContato") Long id) {
		ModelAndView modelAndView = new ModelAndView("Contatos/formContato");
		Optional<Contatos> contato = cr.findById(id);
		modelAndView.addObject("contatoobj", contato.get());
		return modelAndView;
	}
	
	@GetMapping(value = "/deletarcontato/{idContato}")
	public ModelAndView deletar(@PathVariable("idContato") Long id) {
		cr.deleteById(id);
		ModelAndView modelAndView = new ModelAndView("Contatos/formContato");
		modelAndView.addObject("contatos", cr.findAll());
		return modelAndView;

	}
}
