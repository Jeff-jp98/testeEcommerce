package br.com.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import br.com.loja.dto.ProdutoDTO;
import br.com.loja.models.CarrinhoCompras;
import br.com.loja.models.CarrinhoItem;
import br.com.loja.service.ProdutoService;

@Controller
@RequestMapping("/carrinho")
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class CarrinhoComprasController {

	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private CarrinhoCompras carrinho;
	
	@RequestMapping("/add/{id}")
	public ModelAndView add(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/carrinho");
		CarrinhoItem carrinhoItem = criaItem(id);
		carrinho.add(carrinhoItem);
		return modelAndView;
	}
	
	
	@GetMapping
	public String itens(Model model) {
		model.addAttribute("carrinho", carrinho);
		return "carrinho";
	}

	private CarrinhoItem criaItem(Long id) {
		ProdutoDTO produto = produtoService.getOne(id);
		CarrinhoItem carrinhoItem = new CarrinhoItem(produto);
		return carrinhoItem;
	}
	
	@PostMapping("/remover/{id}")
	public String remover(@PathVariable Long id) {
		carrinho.remover(produtoService.getOne(id));
		return "redirect:/carrinho";
	}
	
	
}
