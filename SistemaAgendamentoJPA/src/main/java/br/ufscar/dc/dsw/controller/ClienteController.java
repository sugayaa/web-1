package br.ufscar.dc.dsw.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.service.spec.IClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private IClienteService service;

    @GetMapping("/cadastrar")
    public String cadastrar(Cliente cliente) {
        return "cliente/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model) {
        model.addAttribute("cliente",service.buscarTodos());
        return "cliente/lista";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Cliente cliente, BindingResult result, RedirectAttributes attr) {

        if (result.hasErrors()) {
            return "cliente/cadastro";
        }

        service.salvar(cliente);
        attr.addFlashAttribute("sucess", "Cliente inserido com sucesso.");
        return "redirect:/clientes/listar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("cliente", service.buscarPorId(id));
        return "cliente/cadastro";
    }

    @PostMapping("/editar")
    public String editar(@Valid Cliente cliente, BindingResult result, RedirectAttributes attr) {

        if (result.hasErrors()) {
            return "cliente/cadastro";
        }

        service.salvar(cliente);
        attr.addFlashAttribute("sucess", "Cliente editado com sucesso.");
        return "redirect:/clientes/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, ModelMap model) {
        if (service.clienteTemConsultas(id)) {
            model.addAttribute("fail", "Cliente não excluído. Possui consulta(s) vinculada(s).");
        } else {
            service.excluir(id);
            model.addAttribute("sucess", "Cliente excluído com sucesso.");
        }
        return listar(model);
    }
}
