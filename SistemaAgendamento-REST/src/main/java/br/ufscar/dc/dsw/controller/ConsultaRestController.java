package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Profissional;
import br.ufscar.dc.dsw.domain.Consulta;

import br.ufscar.dc.dsw.domain.Consulta;
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Profissional;
import br.ufscar.dc.dsw.security.ClienteDetails;
import br.ufscar.dc.dsw.security.ProfissionalDetails;
import br.ufscar.dc.dsw.service.spec.IConsultaService;
import br.ufscar.dc.dsw.service.spec.IClienteService;
import br.ufscar.dc.dsw.service.spec.IProfissionalService;



@CrossOrigin
@RestController
public class ConsultaRestController {
    @Autowired
    private IConsultaService service;

    @Autowired
    private IClienteService clienteService;

    @Autowired
    private IProfissionalService profissionalService;
    
    private boolean isJSONValid(String jsonInString) {
        try {
            return new ObjectMapper().readTree(jsonInString) != null;
        } catch (IOException e) {
            return false;
        }
    }
    
    @GetMapping(path = "/consultas")
    public ResponseEntity<List<Consulta>> lista() {
        List<Consulta> lista = service.buscarTodos();

        if (lista.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(lista);
    }
    
    @GetMapping(path = "/consultas/{id}")
    public ResponseEntity<Consulta> lista(@PathVariable("id") long id) {
        Consulta consulta = service.buscaPorId(id);
        if (consulta == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(consulta);
    }

    @GetMapping(path = "/consultas/clientes/{id}")
    public ResponseEntity<List<Consulta>> listaConsultasPorCliente(@PathVariable("id") long id) {
        Cliente cliente = clienteService.buscarPorId(id);
        List<Consulta> lista = service.buscarTodos(cliente);
        if (lista.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(lista);
    }

    @GetMapping(path = "/consultas/profissionais/{id}")
    public ResponseEntity<List<Consulta>> listaConsultasPorProfissional(@PathVariable("id") long id) {
        Profissional profissional = profissionalService.buscarPorId(id);
        List<Consulta> lista = service.buscarTodos(profissional);
        if (lista.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(lista);
    }
}
