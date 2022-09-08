package com.listacontatosapp.controlles;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContatoController {

	@RequestMapping("/cadastrarContato")
	public String form() {
		return "formContato";
	}
}
