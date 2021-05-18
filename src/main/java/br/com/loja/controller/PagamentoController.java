package br.com.loja.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.loja.dto.TransportadoraDTO;
import br.com.loja.models.CarrinhoCompras;
import br.com.loja.models.TipoPagamento;
import br.com.loja.service.ClienteService;
import br.com.loja.service.TransportadoraService;


@RequestMapping("/pagamento")
@Controller
public class PagamentoController {

	@Autowired
	private CarrinhoCompras carrinho;
	@Autowired
	private TransportadoraService transportadoraService;
	@Autowired
	private ClienteService clienteService;
	private Double total;
	
	@GetMapping
	public String finalizar(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		String nome;    

		if (principal instanceof UserDetails) {
		    nome = ((UserDetails)principal).getUsername();
		} else {
		    nome = principal.toString();
		}
		model.addAttribute("carrinho", carrinho);
		model.addAttribute("transportadoras", transportadoraService.listar());
		model.addAttribute("cliente", clienteService.getOne(nome));
		return "finalizarCompra";
	}
	
	@PostMapping("/confirmarCompra")
	public ModelAndView pagamento(Long id) {
		TransportadoraDTO transportadora = transportadoraService.getOne(id);
		total =  carrinho.getTotal().doubleValue() +transportadora.getFrete().doubleValue();
		ModelAndView model = new ModelAndView("finalizarPagamento");
		model.addObject("total", total);
		model.addObject("tipoPagamento", TipoPagamento.values());
		return model;
	}
	
	@PostMapping("/pagar")
	public String pagar(Model model, String tipoPagamento, Integer parcelas) {
		model.addAttribute("parcelas", parcelas);
		model.addAttribute("valorParcela", total/parcelas);
		model.addAttribute("tipoPagamento", tipoPagamento);
		if(tipoPagamento.equals("Credito")) {
			return "credito";
		}else if(tipoPagamento.equals("Boleto")) {
			return "boleto";
		}
		return "pix";
	}
	
	@GetMapping("/finalizado")
	public String finalizarCompra(Model model) {
		Random rdm = new Random();
		int numeroPedido = rdm.nextInt(199999-100000 +1)+100000;
		model.addAttribute("numeroPedido", Integer.valueOf(numeroPedido));
		return "confirmacao";
	}
}
