package br.ufscar.dc.dsw.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Profissional;
import br.ufscar.dc.dsw.service.spec.IClienteService;
import br.ufscar.dc.dsw.service.spec.IProfissionalService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private IClienteService daoC;
	
	@Autowired
	private IProfissionalService daoP;
	
	@GetMapping("/listarCliente")
	public String listaCliente(ModelMap model) {
		model.addAttribute("clientes", daoC.buscarTodos());
		return "admin/listarCliente";
	}
	
	@GetMapping("/listarProfissional")
	public String listaProfissional(ModelMap model) {
		model.addAttribute("profissionais", daoP.buscarTodos());
		return "admin/listarProfissional";
	}
	
	@GetMapping("/cadastrarCliente")
	public String cadastrarCliente(Cliente cliente) {
		return "admin/cadastrarCliente";
	}
	
	@GetMapping("/cadastrarProfissional")
	public String cadastrarProfissional(Profissional profissional) {
		return "admin/cadastrarProfissional";
	}
	
	@GetMapping("/excluirCliente/{id}")
	public String excluirCliente(@PathVariable("id") Long id, ModelMap model) {
		if(daoC.clienteTemConsultas(id))
			model.addAttribute("fail", "Cliente não excluído. Possui consulta(s) vinculada(s).");
		else {
			daoC.excluir(id);
			model.addAttribute("sucess", "Cliente excluído com sucesso.");
		}
		return listaCliente(model);
	}
	
	@PostMapping("/salvarCliente")
	public String salvarCliente(@Valid Cliente cliente, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors())
			return "admin/cadastrarCliente";
		else {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			cliente.setSenha(encoder.encode(cliente.getSenha()));
			daoC.salvar(cliente);
			attr.addFlashAttribute("sucess", "Cliente adicionado com sucesso.");
			return "redirect:/admin/listarCliente";
		}
	}
	
	@GetMapping("/editarCliente/{id}")
	public String preEditarCliente(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("cliente", daoC.buscarPorId(id));
		return "admin/cadastrarCliente";
	}
	
	
	@PostMapping("/editarCliente")
	public String editarCliente(@Valid Cliente cliente, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors())
			return "admin/cadastroCliente";
		daoC.salvar(cliente);
		attr.addFlashAttribute("sucess", "Cliente editado com sucesso");
		return "redirect:/admin/listarCliente";
	}
	
}
