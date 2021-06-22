package br.ufscar.dc.dsw.controller;

import javax.validation.constraints.Null;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufscar.dc.dsw.service.spec.IProfissionalService;

@Controller
@RequestMapping("/")
public class ListaController {

	@Autowired
	private IProfissionalService dao;
	
	@GetMapping("listar")
	public String listaProfissionais(ModelMap model) {
		model.addAttribute("profissionais", dao.buscarTodos());
		return "/listar";
	}

}
