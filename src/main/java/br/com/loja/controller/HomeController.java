package br.com.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.loja.service.ProdutoService;

@Controller
public class HomeController {

	@Autowired
	private ProdutoService produtoService;
	
	@RequestMapping("/home")
	public String home(Model model) {
		model.addAttribute("produtos", produtoService.listar());
		return "home";
	}
}
